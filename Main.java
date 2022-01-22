
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Initializing System variables
		Scanner keyboardInput = new Scanner(System.in);
		
		// variables in Main 
		int playerMenuChoices;	
				
		
		
		// Welcome message 
		System.out.println("*************\n");
		System.out.println("Welcome to the Word Guessing Game hosted by Sadaf & Harshitha! \n");
		System.out.println("*************\n");
		
		do{
			System.out.println("Choose an option from below\n");
			System.out.println("\t1.Start Game");
			System.out.println("\t2.Results of previous games");
			System.out.println("\t3.Exit");
			
			playerMenuChoices = Integer.parseInt(keyboardInput.nextLine());
			
			//checking user's entered choices 
			if(playerMenuChoices == 1 ) {
				// the player chooses to start the game
				startGame();
				break;
			} 
			else if (playerMenuChoices == 2) {
				System.out.println("Results of the previous games");
				break;
			}
			else if (playerMenuChoices == 3) {
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
	
	public static ArrayList<String> wordsListGenerator() {
		
		//creating an arrayList of words that will be used later
		ArrayList<String> wordsList = new ArrayList<String>();
		
		//manually adding some words to this list
		wordsList.add("Alligator");
		wordsList.add("Cheetah");
		wordsList.add("Cadillac");
		wordsList.add("Honda");
		wordsList.add("Aladdin");
		wordsList.add("Titanic");
		wordsList.add("Baseball");
		wordsList.add("Tennis");
		wordsList.add("Vancouver");
		wordsList.add("Detroit");
		wordsList.add("Paris");
		wordsList.add("London");
		wordsList.add("Winnipeg");
		wordsList.add("Alberta");
		wordsList.add("Montreal");
		wordsList.add("Summer");
		wordsList.add("Winter");
		wordsList.add("Fireworks");
		wordsList.add("Heart");
		wordsList.add("Halloween");
		wordsList.add("Thanksgiving");
		wordsList.add("Miracles");
		wordsList.add("Turkey");
		wordsList.add("Banjo");
		wordsList.add("Stripes");
		
		return wordsList;
		
	}
	
	public static String pickRandomWord(){
		
		ArrayList<String> words = wordsListGenerator();
		
		//create Random object
        Random random = new Random();
		int randomNumber = random.nextInt(words.size());
		
		//get word from words list using the random number
		String output = words.get(randomNumber);
		return output;
	
	}
	
	public static void startGame() {
		
		final int totalNumberOfLevels = 3;
		int startingLevel = 1;
		int numberOfGuesses = 7;
		boolean isDebugOn = true;
		
		Scanner sc = new Scanner(System.in);
		
		String secretWord = pickRandomWord();
		SecretWord theSecretWord = new SecretWord(secretWord);
		
		//creating all these arrayList only when level starts/moves to next one
		ArrayList<Level> gameLevels = new ArrayList<Level>(totalNumberOfLevels);
		
		gameLevels.add(new Level(startingLevel, numberOfGuesses, theSecretWord, isDebugOn));
		
		System.out.println(gameLevels.toString());
		
		System.out.println("Current Level: " + gameLevels.get(0).getLevelNumber());
		System.out.println("Chances Remaining: " + gameLevels.get(0).getChancesRemaining());
		System.out.println("Secret Word: " + gameLevels.get(0).getTheSecretWord().getCurrentStateOfWord());
		
		System.out.println("Guess a letter: ");
		char guessedLetter = sc.nextLine().charAt(0);
		
		System.out.println("You guessed: " + guessedLetter);
		
		if(gameLevels.get(0).checkGuess(guessedLetter)) {
			System.out.println("CORRECT! " + guessedLetter + " is in the word.");
			System.out.println("Secret Word: " + gameLevels.get(0).getTheSecretWord().getCurrentStateOfWord());
		} else {
			System.out.println("Wrong! "+ guessedLetter + " is not in the word.");
			System.out.println("You have chances remainnig: " +	gameLevels.get(0).getChancesRemaining());
		}
		sc.close();
	}

}
