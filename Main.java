
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Initializing System variables
		Scanner keyboardInput = new Scanner(System.in);
		
		// variables in Main 	
		String playerMenuChoices;

		
		// Welcome message 
		System.out.println("*************\n");
		System.out.println("Welcome to the Word Guessing Game hosted by Sadaf & Harshitha! \n");
		System.out.println("*************\n");
		
		do{
			System.out.println("Choose an option from below\n");
			System.out.println("\t1.Start Game");
			System.out.println("\t2.Results of previous games");
			System.out.println("\t3.Exit");
			System.out.print(">>> ");
			
			playerMenuChoices = keyboardInput.nextLine();
			
			//checking user's entered choices 
			if(playerMenuChoices.equals("1")) {
				// the player chooses to start the game
				startGame();
				break;
			} 
			else if (playerMenuChoices.equals("2")) {
				System.out.println("Results of the previous games");
				
				//PreviousGameResult previousResult = new PreviousGameResult(); 
				
				//previousResult.displayString();
			}
			else if (playerMenuChoices.equals("3")) {
				System.out.println("*************\n");
				System.out.println("Oh no! We're sad to see you go! Goodbye~ \n ");
				System.out.println("*************\n");
				break;
			} 
			else {
				System.out.println("Uh-oh we don't have that option but you can select 1, 2 or 3\n");
				System.out.println("*************\n");
			}
		} while (true);	
			
		
		
		// Closing the scanner to avoid resource leak		
		keyboardInput.close();
		
		
	}
	
	
	public static void startGame() {
		
		final int totalNumberOfLevels = 3;
		boolean isDebugOn = true;
		int score = 0;
		
		Scanner sc = new Scanner(System.in);
		
		
		for(int i = 0; i < totalNumberOfLevels; i++) {
			
			//picking a word from the file and sending it to SecretWord object
			SecretWord theSecretWord = new SecretWord();
			
			//creating all these arrayList only when level starts/moves to next one
			ArrayList<Level> gameLevels = new ArrayList<Level>(totalNumberOfLevels);
			
			gameLevels.add(new Level(i, theSecretWord, isDebugOn));

			System.out.println(gameLevels.toString());
			
			/* the player can play until they guess the word AND 
			   they have still chances remaining to guess the word
			*/
			
			while(!(gameLevels.get(0).isWordGuessed()) 
				&& (gameLevels.get(0).getChancesRemaining() != 0)) {
				
				System.out.println("Current Level: " + gameLevels.get(0).getLevelNumber());
				System.out.println("Chances Remaining: " + gameLevels.get(0).getChancesRemaining());
				System.out.println("Secret Word: " + gameLevels.get(0).getTheSecretWord().toString());
				

				System.out.println("\nGuess a letter: ");
				String guessedLetter = sc.nextLine();
				
				System.out.println("You guessed: " + guessedLetter);

				if(gameLevels.get(0).checkGuess(guessedLetter)) {
					System.out.println("CORRECT! " + guessedLetter.toUpperCase() + " is in the word.\n");
				} else {
					System.out.println("WRONG! "+ guessedLetter.toUpperCase() + " is not in the word.\n");
				}
			}
		
			if(gameLevels.get(0).getChancesRemaining() == 0){
			     System.out.println("Sorry you are out of all the guesses! You LOSE!\n");
			} else {
			     System.out.println("Congratulations you have guessed the word! You WIN!\n");
			     score+=gameLevels.get(0).getChancesRemaining();
			     if(gameLevels.get(0).getLevelNumber() < totalNumberOfLevels) {
			    	 System.out.println("Welcome to Level: " + gameLevels.get(0).getLevelNumber());
			    	 
			     }
			     System.out.println("Current Score: " + score);
			     
			}
	
		}
		
		System.out.println("");
		System.out.println("\n*************\n");
		System.out.println("\nThank you for playing the game with us!\n");
		System.out.println("\n*************\n");
		
		//System.out.println("Score = "+ score);
		
		PreviousGameResult previousResult = new PreviousGameResult(score); 
		
		String time = previousResult.getDatePlayed();
		
		previousResult.convertResultsIntoList(time,score);
		
		System.out.println(previousResult.toString());
		
		sc.close();
	}

}
