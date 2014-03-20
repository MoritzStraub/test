/**
 * Class Job, which holds 3 methods: getID, getDuration, getDeadline
 * 
 * @author moritz straub - 1020525
 * @email mstraub@cosy.sbg.ac.at
 * @author Manuel Leupold - 0922303
 * @email mleupold@cosy.sbg.ac.at
 * @version 0.0.1
 * 
 */
public class Job {
	private int id;
	private int length;
	private int deadline;

	/**
	 * takes id, length and deadline and sets the variables to that values
	 * 
	 * 
	 * @param id
	 * @param length
	 * @param deadline
	 */
	public Job(int id, int length, int deadline) {
		this.id = id;
		this.length = length;
		this.deadline = deadline;
	}

	/**
	 * returns the job-id
	 * 
	 * 
	 * @return id
	 */
	public int getID() {
		return id;

	}

	/**
	 * returns the job-length
	 * 
	 * 
	 * @return length
	 */
	public int getDuration() {
		return length;

	}

	/**
	 * returns the job-deadline
	 * 
	 * 
	 * @return deadline
	 */
	public int getDeadline() {
		return deadline;

	}

}