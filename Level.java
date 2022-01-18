/*The level class has info about - 
 	1. The level number
 	2. The number of chances the player has remaining in the level 
 	3. Check the result of the player's guesses
*/

public class Level {
	
	// Properties of Level Class
	int levelNumber = 1; // we can set the default value to 1, as a level always starts with 1! 
	int chancesRemaining = 7; 
	// SecretWord theWord; // whatever instance we create for the Secret Word class must be updated HERE
	boolean debugOn = false; // by default it is false, because we don't want to output the secret word; if this variable is set to true - it has to display the current secret word in plain text
	
	//Constructor of Level Class
	//UPDATE: Secret word could be passed into the Constructor
	public Level() {
		System.out.println("Welcome to Level "+ levelNumber);
		System.out.println("Chances remaining: "+ chancesRemaining);
		// theWord = secretWord; 
		
	}
	
	
	// Behaviours/Actions of Level Class
	
	public String toString() {
		// returns string with level num, the secret word, number of guess, if debugOn is true, output the secret word in text
		
		return "";
	}
	
	public Boolean checkGuess(char guessedLetter) {
		// if the letter is present, update the secret word - return TRUE
		
		//else - reduce the number of chances - return FALSE
		
		return false;
	}
	
	public Boolean isWordGuessed() {
		
		//if the player has guessed the secret word return TRUE
		
		//else false
		
		return false;
		
	}
}
