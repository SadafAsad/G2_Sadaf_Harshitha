
public class Level {
	
	//properties 
	private int levelNumber;
	private int chancesRemaining; 
	private SecretWord theSecretWord; 
	private boolean debugOn; 	
	
	//constructor
	public Level(int levelNumber, int chancesRemaining, SecretWord theSecretWord, boolean debugOn) {
		this.levelNumber = levelNumber;
		this.chancesRemaining = chancesRemaining;
		this.theSecretWord = theSecretWord;
		this.debugOn = debugOn;
	}
	
	//methods
	public Boolean checkGuess(char guessedLetter) {
		if(this.theSecretWord.containsLetter(guessedLetter)) {
			//update the letters(s) where this occurs
			String str = this.theSecretWord.getCurrentStateOfWord();
			int index = this.theSecretWord.getActualWord().indexOf(guessedLetter);
			str = str.substring(0, index) + guessedLetter + str.substring(index + 1,this.theSecretWord.getActualWord().length()- 1);
			this.theSecretWord.setCurrentStateOfWord(str);
			return true;
		} else {
			//reduce the number of chances
			this.chancesRemaining--;
			return false;
		}
	}
	
	public Boolean isWordGuessed() {
		if(this.theSecretWord.hasLettersRemaining()) {
			//player has not guessed the word
			return false;
		} else {
			return true;
		}
	}

	@Override
	public String toString() {
		String result;
		
		if(isDebugOn()) {
			result = "Level: " + this.levelNumber + "," +"Chances Remaining: " + this.chancesRemaining + ","
					+ "Secret Word: "+ this.theSecretWord.getCurrentStateOfWord() + "," + "Actual Word: "+ this.theSecretWord.getActualWord();
		} else {
			result = "Level: " + this.levelNumber + "," +"Chances Remaining: " + this.chancesRemaining + ","
					+ "Secret Word: "+ this.theSecretWord.getCurrentStateOfWord();
		}
		
		return result;
	}
	
	//getters
	public int getLevelNumber() {
		return this.levelNumber;
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
