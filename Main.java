
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
				try {
			        BufferedReader inputResults = new BufferedReader(new FileReader("previous_results.txt"));
			        String resultString;
			        while ((resultString = inputResults.readLine()) != null) {
						System.out.print("\n");
			        	System.out.println(resultString);
						System.out.println(inputResults.readLine());
			        }
			        inputResults.close();
			     }
				// Catch block to handle IO exceptions
			    catch (IOException e) {
					if (e instanceof FileNotFoundException){
						System.out.println("No games played yet.");
					}
					else{
			    	System.out.println("Exception Occurred" + e);
					}
			    }
				break;
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
		ArrayList<Level> gameLevels = new ArrayList<Level>(totalNumberOfLevels);
		
		Scanner sc = new Scanner(System.in);
		
		
		for(int i = 0; i < totalNumberOfLevels; i++) {
			
			//picking a word from the file and sending it to SecretWord object
			SecretWord theSecretWord = new SecretWord();
			
			//creating all these arrayList only when level starts/moves to next one
			//ArrayList<Level> gameLevels = new ArrayList<Level>(totalNumberOfLevels);
			
			gameLevels.add(new Level(i, theSecretWord, isDebugOn));

			System.out.println(gameLevels.get(i).toString());
			
			/* the player can play until they guess the word AND 
			   they have still chances remaining to guess the word
			*/
			
			while(!(gameLevels.get(i).isWordGuessed()) 
				&& (gameLevels.get(i).getChancesRemaining() != 0)) {
				
				System.out.println("Current Level: " + gameLevels.get(i).getLevelNumber());
				System.out.println("Chances Remaining: " + gameLevels.get(i).getChancesRemaining());
				System.out.println("Secret Word: " + gameLevels.get(i).getTheSecretWord().toString());
				

				System.out.println("\nGuess a letter: ");
				String guessedLetter = sc.nextLine();
				
				System.out.println("You guessed: " + guessedLetter);

				if(gameLevels.get(i).checkGuess(guessedLetter)) {
					System.out.println("CORRECT! " + guessedLetter.toUpperCase() + " is in the word.\n");
				} else {
					System.out.println("WRONG! "+ guessedLetter.toUpperCase() + " is not in the word.\n");
				}
			}
		
			if(gameLevels.get(i).getChancesRemaining() == 0){
			     System.out.println("Sorry you are out of all the guesses! You LOSE!\n");
				 break;
			} else {
			     System.out.println("Congratulations you have guessed the word! You WIN!\n");
			     score+=gameLevels.get(i).getChancesRemaining();
			     if(gameLevels.get(i).getLevelNumber() < totalNumberOfLevels) {
			    	 System.out.println("Welcome to Level: " + gameLevels.get(i).getLevelNumber());
			    	 
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
		try {
			previousResult.storeValues();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sc.close();
	}

}
