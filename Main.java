
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Initializing System variables
		Scanner keyboardInput = new Scanner(System.in);
		
		// Welcome message 
		System.out.println("*************\n");
		System.out.println("Welcome to the Word Guessing Game hosted by Sadaf & Harshitha! \n");
		System.out.println("*************\n");
		
		
		// Menu of choices 
		
		int userChoices;
		
		do{
			System.out.println("Choose an option from below\n");
			System.out.println("\t1.Start Game");
			System.out.println("\t2.Results of previous games");
			System.out.println("\t3.Exit");
			
			userChoices = keyboardInput.nextInt();
			
			//checking user's entered choices 
			
			if(userChoices == 1 ) {
				System.out.println("User has started the game");
				break;
			} 
			else if (userChoices == 2) {
				System.out.println("Results of the previous games");
				break;
			}
			else if (userChoices == 3) {
				System.out.println("*************\n");
				System.out.println("Oh no! We're sad to see you go! Goodbye~ \n ");
				System.out.println("*************\n");
				break;
			}
			System.out.println("Uh-oh we don't have that option but you can select 1, 2 or 3\n");
			System.out.println("*************\n");
		} while (true);
		
		
	}

}
