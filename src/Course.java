
/** @author varungoel
 * Name: Varun Goel
 *ID: 109991128
 * email: varun.goel@stonybrook.edu
 * CSE 214 HW 1
 * Recitation Section: 7
 * Recitation TA: Anthony Musco
 */  

import java.util.*;

/**
 * Course class
 */

public class Course implements Cloneable{ 

	static Scanner input = new Scanner(System.in);

	String courseName; 
	String department; 
	String instructor; 
	int courseCode; 
	byte section; 

	/**
	 * Default constructor.
	 * Creates a new course with blank parameters
	 */

	public Course() {
	}

	/**
	 * Constructor with parameters
	 * @param course
	 * Name of the course
	 * @param department
	 * Course department
	 * @param instructor
	 * Instructor teaching the course
	 * @param code
	 * Number code of the course
	 * @param section
	 * Section of the course
	 */

	public Course(String course, String department, String instructor, int code, byte section){
		courseName = course;
		this.department = department;
		this.instructor = instructor;
		courseCode = code;
		this.section = section;
	}

	/**
	 * Sets the course name.
	 * @param course
	 * 
	 */
	public void setCourse(String course){
		courseName = course;
	}

	/**
	 * Gets the course name.
	 * @return String value for course name
	 */

	public String getCourse(){
		return courseName;
	}

	/**
	 * Sets the department name.
	 * @param department
	 * 
	 */

	public void setDepartment(String department){
		this.department = department;
	}

	/**
	 * Gets the department name.
	 * @return String value for department name
	 */

	public String getDepartment(){
		return department;
	}

	/**
	 * Sets the instructor name.
	 * @param instructor
	 * 
	 */

	public void setInstructor(String instructor){
		this.instructor = instructor;
	}

	/**
	 * Gets the instructor name.
	 * @return String value for instructor name
	 */

	public String getInstructor(){
		return instructor;
	}

	/**
	 * Sets the class code.
	 * @param code
	 * @throws NegativeNumberException
	 * 
	 */
	public void setCode(int code) throws NegativeNumberException{
		if(code < 0)
			throw new NegativeNumberException();

		else
			courseCode = code;
	}

	/**
	 * Gets the class code.
	 * @return int
	 */

	public int getCode(){
		return courseCode;
	}

	/**
	 * Sets the class section.
	 * @param section
	 * @throws NegativeNumberException
	 * 
	 */
	public void setSection(byte section) throws NegativeNumberException{
		if(section < 0)
			throw new NegativeNumberException();

		else
			this.section = section;
	}

	/**
	 * Gets the class section.
	 * @return Byte value for class section
	 */

	public byte getSection(){
		return section;
	}

	/**
	 * Overriding the clone method for the course class
	 * @return clone Course
	 * Make a deep copy and return that
	 */
	public Object clone(){
		try {
			Course copyCourse =  (Course) super.clone();

			copyCourse.courseName = courseName;
			copyCourse.courseCode = courseCode;
			copyCourse.department = department;
			copyCourse.instructor = instructor;
			copyCourse.section = section;  
			return (Course)copyCourse;

		} catch (CloneNotSupportedException e) {
			System.out.println("Clone not supported");
			return null;
		}
	}

	/**
	 * Overriding the toString method 
	 * @return String: description of the course
	 * Format in a tabular style and return the string
	 */
	public String toString(){
		return String.format("%s   	%s %s.0%d  	%s", courseName, department, courseCode, section,"   " + instructor + "\n");
	}

	/**
	 * Overriding the equals method 
	 * @param obj
	 * @return boolean
	 */
	public boolean equals(Object obj){

		if(obj instanceof Course){

			String course = ((Course)obj).courseName;
			String dept = ((Course)obj).department;
			int code = ((Course)obj).courseCode;
			byte sec = ((Course)obj).section;
			String inst = ((Course)obj).instructor;

			return(course.equals(this.courseName) & dept.equals(this.department) & inst.equals(this.instructor) & (code == courseCode) & (sec == section));
		}

		else
			return false;
	}

	/**
	 * Helper method for Planner class exists method that uses the overridden equals method
	 * @param obj
	 * @return boolean
	 */
	public boolean isEqual(Course obj){
		return this.equals((Course)obj);
	}

	public static void main(String[] args) {
	}

}
