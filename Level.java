
public class Level {
	
	//properties 
	private int levelNumber; //by default, our game starts with 1
	private int chancesRemaining; //by default, our game has 7 chances to guess a word
	private SecretWord theSecretWord; 
	private boolean debugOn;
	private final int numberOfChances = 7; 	
	
	//constructor
	public Level(int levelNumber, SecretWord theSecretWord, boolean debugOn) {
		this.levelNumber = levelNumber + 1;
		this.chancesRemaining = this.numberOfChances;
		this.theSecretWord = theSecretWord;
		this.debugOn = debugOn;
	}

	//methods
	public Boolean checkGuess(String guessedLetter) {
		if(this.theSecretWord.containsLetter(guessedLetter.toUpperCase())) {
			//update the letters(s) where this occurs
			int wordLength = this.theSecretWord.getActualWord().length();
			
			String str = this.theSecretWord.getActualWord();
			String currentState = this.theSecretWord.getCurrentStateOfSecretWord();
			char letter = guessedLetter.toUpperCase().charAt(0);
			
			//ArrayList<Character> playerGuesses = new ArrayList<>();
			for(int i= str.indexOf(guessedLetter.toUpperCase()); i < wordLength; i++) {
					if(str.charAt(i) == letter) {
						currentState = currentState.substring(0,i) + guessedLetter.toUpperCase() + currentState.substring(i + 1);
						this.theSecretWord.setCurrentStateOfSecretWord(currentState);
					}
			}
			return true;
		} else {
			//reduce the number of chances
			this.chancesRemaining--;
			return false;
		}
	}
	
	public boolean isWordGuessed() {
		if(this.theSecretWord.hasLettersRemaining()) {
			//player has not guessed the word
			return false;
		} else {
			setLevelNumber();
			return true;
		}
	}

	@Override
	public String toString() {
		String result;
		
		if(isDebugOn()) {
			result = "Level: " + this.levelNumber + "," +"Chances Remaining: " + this.chancesRemaining + ","
					+ "Secret Word: "+ this.theSecretWord.toString() + "," + "Actual Word: "+ this.theSecretWord.getActualWord();
		} else {
			result = "Level: " + this.levelNumber + "," +"Chances Remaining: " + this.chancesRemaining + ","
					+ "Secret Word: "+ this.theSecretWord.toString();
		}
		
		return result;
	}
	
	//getters
	public int getLevelNumber() {
		return this.levelNumber;
	}
	
	public void setLevelNumber() {
		if(levelNumber < 3) {
			this.levelNumber++;
		}
	}
	
	
	
	public int getChancesRemaining() {
		return this.chancesRemaining;
	}

	public SecretWord getTheSecretWord() {
		return this.theSecretWord;
	}

	public boolean isDebugOn() {
		return this.debugOn;
	}

}
