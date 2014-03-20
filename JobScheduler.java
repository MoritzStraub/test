import java.util.Arrays;
import java.util.Comparator;

/**
 * the JobScheduler class holds some algorithms for jobscheduling
 * 
 * @author moritz straub - 1020525
 * @email mstraub@cosy.sbg.ac.at
 * @author Manuel Leupold - 0922303
 * @email mleupold@cosy.sbg.ac.at
 * @version 0.0.1
 * 
 */
public class JobScheduler {
	private int time_start;
	private Job[] jobs;

	/**
	 * @param time_start
	 * @param jobs
	 */
	public JobScheduler(int time_start, Job[] jobs) {
		this.time_start = time_start;
		this.jobs = jobs;
	}

	/**
	 * @return time_start
	 */
	public int getStartTime() {
		return this.time_start;
	}

	/**
	 * @return job_arr
	 */
	public int[] orderSlackTime() {
		Arrays.sort(jobs, new comp_jobs());
		int[] job_arr = new int[jobs.length];
		for (int i = 0; i < jobs.length; i++) {
			Job job = jobs[i];
			job_arr[i] = job.getID();
		}
		return job_arr;
	}

	/**
	 * @return time_end
	 */
	public int endSlackTime() {
		int time_end = time_start;
		for (int i = 0; i < jobs.length; i++) {
			Job job = jobs[i];
			time_end = time_end + job.getDuration();
		}
		return time_end;
	}

	/**
	 * @return lateness
	 */
	public int latenessSlackTime() {
		int lateness = 0;
		int time_end = time_start;
		Arrays.sort(jobs, new comp_jobs());
		for (int i = 0; i < this.jobs.length; i++) {
			time_end = time_end + this.jobs[i].getDuration();
			if (time_end > this.jobs[i].getDeadline())
				lateness = lateness + (time_end - jobs[i].getDeadline());
		}
		return lateness;
	}

	/**
	 * @return job_arr
	 */
	public int[] orderJobLength() {
		Arrays.sort(jobs, new comp_length());
		int[] job_arr = new int[jobs.length];
		for (int i = 0; i < jobs.length; i++) {
			Job job = jobs[i];
			job_arr[i] = job.getID();
		}
		return job_arr;
	}

	/**
	 * @return time_end
	 */
	public int endJobLength() {
		int time_end = time_start;
		for (int i = 0; i < this.jobs.length; i++) {
			Job job = jobs[i];
			time_end = time_end + job.getDuration();
		}
		return time_end;
	}

	/**
	 * @return lateness
	 */
	public int latenessJobLength() {
		int lateness = 0;
		int time_end = time_start;
		Arrays.sort(jobs, new comp_length());
		for (int i = 0; i < this.jobs.length; i++) {
			time_end = time_end + this.jobs[i].getDuration();
			if (time_end > this.jobs[i].getDeadline())
				lateness = lateness + (time_end - jobs[i].getDeadline());
		}
		return lateness;

	}

	/**
	 * @return job_arr
	 */
	public int[] orderEDF() {
		Arrays.sort(jobs, new comp_deadline());
		int[] job_arr = new int[jobs.length];
		for (int i = 0; i < this.jobs.length; i++) {
			Job job = jobs[i];
			job_arr[i] = job.getID();
		}
		return job_arr;
	}

	/**
	 * @return time_end
	 */
	public int endEDF() {
		int time_end = time_start;
		for (int i = 0; i < this.jobs.length; i++) {
			Job job = jobs[i];
			time_end = time_end + job.getDuration();
		}
		return time_end;
	}

	/**
	 * @return lateness
	 */
	public int latenessEDF() {
		int lateness = 0;
		int time_end = time_start;
		Arrays.sort(jobs, new comp_deadline());
		for (int i = 0; i < this.jobs.length; i++) {
			time_end = time_end + this.jobs[i].getDuration();
			if (time_end > this.jobs[i].getDeadline())
				lateness = lateness + (time_end - jobs[i].getDeadline());
		}
		return lateness;
	}

	class comp_jobs implements Comparator<Job> {

		public int compare(Job job_1, Job job_2) {
			return (job_1.getDeadline() - job_1.getDuration())
					- (job_2.getDeadline() - job_2.getDuration());
		}

	}

	class comp_length implements Comparator<Job> {

		public int compare(Job job_1, Job job_2) {
			return job_1.getDuration() - job_2.getDuration();
		}

	}

	class comp_deadline implements Comparator<Job> {

		public int compare(Job job_1, Job job_2) {
			return job_1.getDeadline() - job_2.getDeadline();
		}

	}
}