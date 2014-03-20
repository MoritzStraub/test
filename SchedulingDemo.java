/**
 * Creating new jobs and testing the three supported scheduling algorithms
 * 
 * @author moritz straub - 1020525
 * @email mstraub@cosy.sbg.ac.at
 * @author Manuel Leupold - 0922303
 * @email mleupold@cosy.sbg.ac.at
 * @version 0.0.1
 * 
 */

public class SchedulingDemo {

	public static void main(String[] args) {

		Job[] jobs = { new Job(0, 16, 18), new Job(1, 5, 8), new Job(2, 5, 9), new Job(3, 24, 41),
				new Job(4, 43, 50), new Job(5, 13, 26), new Job(6, 29, 35),new Job(7, 8, 10) };

		JobScheduler scheduler = new JobScheduler(0, jobs);
		System.out.println("Used Greedy Algorithm: Slack Time");
		System.out.println("Number of Jobs:     " + jobs.length);
		System.out.println("Start: " + scheduler.getStartTime());
		System.out.println("End:      " + scheduler.endSlackTime());
		System.out.println("Lateness:  " + scheduler.latenessSlackTime() + "\n");

		System.out.println("Used Greedy Algorithm: Job Length");
		System.out.println("Number of Jobs:     " + jobs.length);
		System.out.println("Start: " + scheduler.getStartTime());
		System.out.println("End:      " + scheduler.endJobLength());
		System.out.println("Lateness:  " + scheduler.latenessJobLength() + "\n");

		System.out.println("Used Greedy Algorithm: EDF");
		System.out.println("Number of Jobs:     " + jobs.length);
		System.out.println("Start: " + scheduler.getStartTime());
		System.out.println("End:      " + scheduler.endEDF());
		System.out.println("Lateness:  " + scheduler.latenessEDF() + "\n");
	}
	
}