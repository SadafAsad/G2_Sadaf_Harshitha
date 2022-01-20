//Secret Word Class

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

public class SecretWord {

    public String actual_word;
    public String current_state_of_secret_word;

    public SecretWord(String file){
        this.actual_word = wordGenerator(file);

        // for each char in the actual word, we have a _ in the current state
        int chars_num = this.actual_word.length();
        for (int i=0; i<chars_num; i++){
            this.current_state_of_secret_word = this.current_state_of_secret_word.concat("_");
        }
    }

    public boolean containsLetter(String letter){

        // this variable stores actual word length
        int actual_word_len = this.actual_word.length();
        
        // checks if actual word contains letter
        if (this.actual_word.contains(letter.toUpperCase())){

            int start_at = 0;
            int end_at = actual_word_len-1;
            int index_letter;

            // searchs for all the 'letter's in actual word and updates the current state
            while (start_at<=end_at){
                index_letter = this.actual_word.indexOf(letter, start_at);

                // if the last letter in the actual word is 'letter'
                // just to avoid index out of range error
                if (index_letter==end_at){
                    this.current_state_of_secret_word = this.current_state_of_secret_word.substring(0, index_letter) + letter.toUpperCase();
                }
                else{
                    this.current_state_of_secret_word = this.current_state_of_secret_word.substring(0, index_letter) + letter.toUpperCase() + this.current_state_of_secret_word.substring(index_letter+1, actual_word_len-1);
                }
                start_at = index_letter+1;
            }
            return true;
        }
        return false;
    }

    public boolean hasLettersRemaining(){
        if (this.current_state_of_secret_word.contains("_")) return true;
        return false;
    }

    public String toString(){
        int word_len = this.current_state_of_secret_word.length();
        String current_state_displayer = "";

        // adds " " after each character
        for(int i=0; i<word_len; i++){
            current_state_displayer = current_state_displayer + this.current_state_of_secret_word.substring(i, i+1) + " ";
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
