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
 * Manager class to manage the Planner
 * Presents a menu based interface where the user can select what they want to do with the planner
 */

public class PlannerManager{
	static Scanner input = new Scanner(System.in);

	/**
	 * Static method to print the menu from where the user can select what they want to do next
	 */
	public static void printMenu(){
		System.out.println("(A) Add Course	(G) Get Course	(R) Remove Course");
		System.out.println("(P) Print Courses in Planner	(F) Filter by Department Code	(L) Look For Course");
		System.out.println("(S) Size	(B) Backup	(PB) Print Courses in Backup");
		System.out.println("(RB) Revert to Backup	(Q) Quit");
	}

	/**
	 * Method ensures that an integer is received and ensures proper execution if an exception is caught
	 
	 * @return integer: proper integer that can be used
	 */
	public static int acceptInt(){
		boolean continueInput = true;
		int number = 0;
		do{
			try{
				number = input.nextInt();
				continueInput = false;
			}
			catch(InputMismatchException ex){
				System.out.println("Not valid (Enter a number)");
				input.nextLine();
			}

		}
		while(continueInput || number < 0);
		return number;
	}

	/**
	 * Method ensures that a byte is received and ensures proper execution if an exception is caught
	 
	 * @return Byte: proper Byte that can be used
	 */
	public static byte acceptByte(){
		boolean continueInput = true;
		byte number = 0;
		do{
			try{
				number = input.nextByte();

				continueInput = false;
			}
			catch(InputMismatchException ex){
				System.out.println("Not valid (Enter a positive number)");
				input.nextLine();
			}
		}
		while(continueInput || number < 0);
		return number;
	}


	/**
	 * Method that is invoked when user decides to add a course
	 * @return Course 
	 */
	public static Course addCourse(){

		String courseName,department,instructor;
		int courseCode, position;
		byte section;

		System.out.println("Enter Course Name");
		courseName = input.nextLine();

		//Get department
		System.out.println("Enter department");
		department = input.nextLine();

		//Get instructor info
		System.out.println("Enter instructor");
		instructor = input.nextLine();

		//Get course code
		System.out.println("Enter Course code (+ve number)");
		courseCode = acceptInt();

		//Get section
		System.out.println("Enter section (+ve number)");
		section = acceptByte();

		Course C1 = new Course(courseName,department,instructor,courseCode,section);
		System.out.println(courseName + " added to the the planner");
		input.nextLine();
		return C1;
	}

	public static void main(String[] args) {

		Planner P1 = new Planner();
		Planner P2 = new Planner(); //the backup planner

		printMenu();

		String option = input.nextLine().toUpperCase();

		while(!option.equals("Q")){

			//If user wants to enter a course
			if(option.equals("A")){
				System.out.println("Enter position to place the course");
				int position = acceptInt();
				input.nextLine();
				try {
					P1.add(addCourse(),position);
				} catch (IllegalArgumentException e) {
					System.out.println("Enter a different position! + \n");
				} catch (FullPlannerException e) {
					System.out.println("Sorry, planner is full!");
				}
				
			}

			//If user wants to get a course
			else if(option.equals("G")){
				System.out.println("Enter position of the course");
				int position = acceptInt();
				input.nextLine();
				try{
					System.out.println(P1.getCourse(position));
				}
				catch(IllegalArgumentException e){
					System.out.println("Enter a valid position");
				}
				catch(EmptyPlannerException e){

				}
			}

			//If user wants to remove a course
			else if(option.equals("R")){
				System.out.println("Enter position of the course you want to remove");
				int position = acceptInt();
				input.nextLine();
				try{
					P1.remove(position);
				}
				catch(IllegalArgumentException e){
					System.out.println("Enter a valid position");
				}
				catch(EmptyPlannerException e){

				}
			}

			//If user wants to print all courses in the planner
			else if(option.equals("P")){
				P1.printAllCourses();
			}

			//If user wants to filter courses by department
			else if(option.equals("F")){
				System.out.println("Enter the department whose courses you want");
				String department = input.nextLine();
				try {
					P1.filter(department);
				} catch (EmptyPlannerException e) {
					
				}
			}

			//If user wants to look for a course (check it's existence)
			if(option.equals("L")){
				if(P1.size() == 0){
					System.out.println("Planner is empty");
					printMenu();
				}

				else{
					String courseName,department,instructor;
					int courseCode, position;
					byte section;

					System.out.println("Enter Course Name");
					courseName = input.nextLine();

					//Get department
					System.out.println("Enter department");
					department = input.nextLine();

					//Get instructor info
					System.out.println("Enter instructor");
					instructor = input.nextLine();

					//Get course code
					System.out.println("Enter Course code (+ve number)");
					courseCode = acceptInt();

					//Get section
					System.out.println("Enter section (+ve number)");
					section = acceptByte();

					Course C1 = new Course(courseName,department,instructor,courseCode,section);
					try {
						System.out.println(P1.exists(C1));
					} catch (EmptyPlannerException e) {
					}
				}
				input.nextLine();
			}

			//if user wants to know the number of courses in the planner
			else if(option.equals("S")){
				System.out.println(P1.size());
			}

			//if user wants to backup the planner
			else if(option.equals("B")){
				P2 = (Planner)P1.clone();
				System.out.println("Backup created");
			}

			//if user wants to print the backup planner
			else if(option.equals("PB")){
				P2.printAllCourses();
			}

			//if user wants to revert to backup
			else if(option.equals("RB")){
				P1 = (Planner)P2.clone();
			}

			printMenu();
			option = input.nextLine().toUpperCase();

		}
		

	}

}
