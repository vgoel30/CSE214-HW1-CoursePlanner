/** @author varungoel
 * Name: Varun Goel
 *ID: 109991128
 * email: varun.goel@stonybrook.edu
 * CSE 214 HW 1
 * Recitation Section: 7
 * Recitation TA: Anthony Musco
 */ 

/**
 * Custom Exception
 * Exception for when the planner is empty
 *
 */

public class EmptyPlannerException extends Exception {
		public EmptyPlannerException(){
			System.out.println("Planner is empty!");
		}
}
