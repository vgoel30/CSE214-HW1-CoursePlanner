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
 * Exception for when the planner is full
 *
 */
public class FullPlannerException extends Exception {
		public FullPlannerException(){
			System.out.println("Planner is full!");
		}
}
