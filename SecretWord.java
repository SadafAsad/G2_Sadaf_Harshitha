//Secret Word Class
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

public class SecretWord {

    private String actualWord;
    private String currentStateOfSecretWord;

    public SecretWord(){
    	
        setActualWord(wordGenerator());

        // for each char in the actual word, we have a _ in the current state
        int charsNum = this.actualWord.length();
        String str = "";
        for (int i=0; i< charsNum; i++){
            str = str.concat("_");
        }

        setCurrentStateOfSecretWord(str);
    }

    public String getActualWord(){ return actualWord; }
    private void setActualWord(String word){ actualWord = word; }

    public String getCurrentStateOfSecretWord(){ return this.currentStateOfSecretWord; }
    public void setCurrentStateOfSecretWord(String currentState){ this.currentStateOfSecretWord = currentState; }

    public boolean containsLetter(String letter){
        if (getActualWord().contains(letter.toUpperCase())) return true;
        return false;
    }

    public boolean hasLettersRemaining(){
        if (getCurrentStateOfSecretWord().contains("_")) {
        	return true;
        } else {
        	 return false;
        }
    }

    public String toString(){
        int wordLen = getCurrentStateOfSecretWord().length();
        String currentStateDisplayer = "";

        // adds " " after each character
        for(int i=0; i< wordLen; i++){
        	currentStateDisplayer = currentStateDisplayer + getCurrentStateOfSecretWord().substring(i, i+1) + " ";
        }
        return currentStateDisplayer;
    }

    private int numberOfLines(){
        
        // this variable store the number of lines
        int lineCounter = 0;

        // basically it's reading the file and counting the lines
        try {
            //File fileObj = new File(fileName);
            File starting = new File(System.getProperty("user.dir"));
    		File fileToBeRead = new File(starting,"words.txt");
            
    		Scanner fileReader = new Scanner(fileToBeRead);
            while (fileReader.hasNextLine()) {
                fileReader.nextLine();
                lineCounter++;
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return lineCounter;
    }

    private String wordGenerator(){
    	

        // this variable stores the word which is to be guessed
        String secretWord = "";
        int numberOfLinesInFile = numberOfLines();
        
        // a random number is being generated
        // which is used to read a random line from the file
        Random rand = new Random();
        int randomInt = rand.nextInt(numberOfLinesInFile +1);

        // it's reading the file untill it gets to the random line to be read
        try {
        	File starting = new File(System.getProperty("user.dir"));
    		File fileToBeRead = new File(starting,"words.txt");
            
    		Scanner fileReader = new Scanner(fileToBeRead);
          
            for (int i=0; i<randomInt; i++) {
              fileReader.nextLine();
            }
            secretWord = fileReader.nextLine();
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return secretWord.toUpperCase();
    }


}


