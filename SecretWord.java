//Secret Word Class

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

public class SecretWord {

    private String actual_word;
    private String current_state_of_secret_word;

    public SecretWord(String file){
        setActualWord(wordGenerator(file));

        // for each char in the actual word, we have a _ in the current state
        int chars_num = this.actual_word.length();
        String str = "";
        for (int i=0; i<chars_num; i++){
            str = str.concat("_");
        }

        setCurrentStateOfSecretWord(str);
    }

    public String getActualWord(){ return actual_word; }
    private void setActualWord(String word){ actual_word = word; }

    private String getCurrentStateOfSecretWord(){ return current_state_of_secret_word; }
    private void setCurrentStateOfSecretWord(String current_state){ current_state_of_secret_word = current_state; }

    public boolean containsLetter(String letter){
        if (getActualWord().contains(letter.toUpperCase())) return true;
        return false;
    }

    public boolean hasLettersRemaining(){
        if (getCurrentStateOfSecretWord().contains("_")) return true;
        return false;
    }

    public String toString(){
        int word_len = getCurrentStateOfSecretWord().length();
        String current_state_displayer = "";

        // adds " " after each character
        for(int i=0; i<word_len; i++){
            current_state_displayer = current_state_displayer + getCurrentStateOfSecretWord().substring(i, i+1) + " ";
        }
        return current_state_displayer;
    }

    private int numberOfLines(String file_name){
        
        // this variable store the number of lines
        int line_counter = 0;

        // basically it's reading the file and counting the lines
        try {
            File file_obj = new File(file_name);
            Scanner file_reader = new Scanner(file_obj);
            while (file_reader.hasNextLine()) {
                file_reader.nextLine();
                line_counter++;
            }
            file_reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return line_counter;
    }

    private String wordGenerator(String file_name){

        // this variable stores the word which is to be guessed
        String secret_word = "";
        int number_of_lines_in_file = numberOfLines(file_name);

        // a random number is being generated
        // which is used to read a random line from the file
        Random rand = new Random();
        int random_int = rand.nextInt(number_of_lines_in_file+1);

        // it's reading the file untill it gets to the random line to be read
        try {
            File file_obj = new File(file_name);
            Scanner file_reader = new Scanner(file_obj);
            for (int i=0; i<random_int; i++) {
              file_reader.nextLine();
            }
            secret_word = file_reader.nextLine();
            file_reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return secret_word.toUpperCase();
    }


}
