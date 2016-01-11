/** @author varungoel
 * Name: Varun Goel
 *ID: 109991128
 * email: varun.goel@stonybrook.edu
 * CSE 214 HW 1
 * Recitation Section: 7
 * Recitation TA: Anthony Musco
 */ 

import java.util.*;
public class Planner {

	/** The maximum amount of courses that can be saved in the planner */
	final int MAX_COURSES = 50;

	/** The list for storing all the courses */
	private Course[] list;

	/** Default constructor instantiates a Planner object with no courses in it
	 * <dt><b>Postconditions:</b><dd>
	 * 	Creates a new planner; an empty list of courses
	 */
	public Planner(){
		list = new Course[MAX_COURSES + 1];
	}

	/** Method to return number of courses in the planner

	 * <dt><b>Preconditions:</b><dd>
	 * 	Planner has been instantiated
	 * @return Number of courses in the planner (list)
	 */
	public int size(){
		int Size = 0;
		for(int i = 1; i < MAX_COURSES + 1; i++){
			if(list[i] != null)
				Size++;
		}
		return Size;
	}

	/** Method to add courses in the planner
	 * @param newCourse, position
	 * <dt><b>Preconditions:</b><dd>
	 * 	This Course object has been instantiated and 1 ≤ position ≤ size + 1. The number of Course objects in this Planner is less than MAX_COURSES.
	 * <dt><b>Postconditions:</b><dd>
	 * 	The new Course is now listed in the correct preference on the list. All Courses that were originally greater than or equal to position are moved back one position.

	 * @throws IllegalArgumentException, FullPlannerException 
	 */
	public void add(Course newCourse, int position) throws IllegalArgumentException, FullPlannerException{

		if(position > MAX_COURSES){
			throw new IllegalArgumentException("Invalid Position");
		}

		else if(position > this.size() + 1 | position == 0){
			throw new IllegalArgumentException("Invalid Position");
		}


		else if(this.size() == 50){
			throw new FullPlannerException();
		} 

		else{
			int len = list.length;

			//shifts previously placed elements to the right
			for(int i = len - 1; i > position; i--){
				list[i] = list[i-1];
			}
			list[position] = newCourse;

			//for debugging purposes
			//System.out.println(Arrays.toString(list));
		} 
	}

	/** Method to add a course in the planner without a specified position. Adds it at the end of the list
	 * @param newCourse

	 * @throws  FullPlannerException 
	 */
	public void add(Course newCourse) throws FullPlannerException {

		if(this.size() == 50){
			throw new FullPlannerException();
		} 

		list[this.size() + 1] = newCourse;
	} 

	/** Method to remove courses in the planner
	 * @param position
	 * <dt><b>Preconditions:</b><dd>
	 * 	This Course object has been instantiated and 1 ≤ position ≤ size.
	 * <dt><b>Postconditions:</b><dd>
	 * 	The Course at the desired position has been removed. All Courses that were originally greater than or equal to position are moved backward one position.

	 * @throws IllegalArgumentException 
	 */
	public void remove(int position) throws IllegalArgumentException, EmptyPlannerException{

		if(this.size() == 0){
			throw new EmptyPlannerException();
		}

		else if(position > this.size() || this.size() == 0){
			throw new IllegalArgumentException("No course at that position");
		}



		else{
			int len = list.length;
			for(int i = position + 1; i < len ; i++){
				list[i-1] = list[i];
			}
			System.out.println("Course at position " + position + " removed");
		}
	}

	/** Method to get courses from the planner
	 * @param position
	 * <dt><b>Preconditions:</b><dd>
	 * 	This Course object has been instantiated and 1 ≤ position ≤ size.
	 * @return Course at the specified position
	 * @throws IllegalArgumentException 
	 * @throws EmptyPlannerException 
	 */
	public Course getCourse(int position) throws IllegalArgumentException, EmptyPlannerException{
		if(this.size() == 0){
			throw new EmptyPlannerException();
		}

		else if(position > this.size())
			throw new IllegalArgumentException("No course at that position");



		else
			return list[position];
	}

	/** Method to print courses from the specified department
	 * @param planner, department
	 * <dt><b>Preconditions:</b><dd>
	 * 	This Course object has been instantiated.
	 * <dt><b>Postconditions:</b><dd>
	 * 	Display table of each course filtered from the Planner.

	 * @throws EmptyPlannerException 
	 */
	public static void filter(Planner planner, String department) throws EmptyPlannerException{
		//use the toString method to print the relevant courses;
		if(planner.size() == 0){
			throw new EmptyPlannerException();
		}
		else{
			for(int i = 1; i <= planner.size(); i++){
				if(planner.list[i].department.equalsIgnoreCase(department)){
					System.out.println(planner.list[i]);
				}
			}
		}
	}

	/**Non-static helper method to print courses from the specified department
	 * @param planner, department
	 * <dt><b>Preconditions:</b><dd>
	 * 	This Course object has been instantiated.
	 * @throws EmptyPlannerException 

	 */

	public  void filter(String department) throws EmptyPlannerException{
		//use the toString method to print the relevant courses;
		if(this.size() == 0){
			throw new EmptyPlannerException();
		}

		else{
			for(int i = 1; i <= this.size(); i++){
				if(this.list[i].department.equalsIgnoreCase(department)){
					System.out.println(this.list[i]);
				}
			}
		}
	}

	/** Method to check courses' existence
	 * @param course
	 *<dt><b>Preconditions:</b><dd>
	 * 	This Course object has been instantiated.
	 * @return boolean
	 * @throws EmptyPlannerException 
	 */
	public boolean exists(Course course) throws EmptyPlannerException{
		if(this.size() == 0){
			throw new EmptyPlannerException();
		}
		else{
			for(int i = 1; i <= this.size(); i++){
				if(course.isEqual(this.list[i])){

					System.out.println(list[i] + " exists at position " + i);
					return true;
				}	
			}
		}
		return false;
	}

	/**
	 * Overriding the clone method 
	 * @return Full copy planner
	 * <dt><b>Preconditions:</b><dd>
	 * 	This Planner object has been instantiated.
	 * Make a deep copy and return that
	 */

	public Object clone(){

		Planner copyPlanner =  new Planner();

		for(int i = 1; i <= this.size();i++){

			copyPlanner.list[i] = (Course) this.list[i].clone();

		}

		return (Planner)copyPlanner;
	}

	/**
	 * Overriding the toString method 
	 * <dt><b>Preconditions:</b><dd>
	 * 	This Planner object has been instantiated.
	 * @return String: description of the course
	 * Format in a tabular style and return the string
	 */
	public String toString(){
		String toReturn = "";
		for(int i = 1; i <= this.size(); i++){
			toReturn = toReturn + i + "\t" + this.list[i].toString();
		}
		return toReturn;
	}

	/**
	 * Uses the toString method to print all the courses
	 * <dt><b>Preconditions:</b><dd>
	 * 	This Planner object has been instantiated.

	 * Format in a tabular style and return the string
	 */
	public void printAllCourses(){
		if(this.size() == 0){
			System.out.println("Planner is empty");
		}
		else
			System.out.println(this.toString());
	}


	public static void main(String[] args) {

	}

}
