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
    }

    public boolean containsLetter(String letter){

        if (this.actual_word.contains(letter.toUpperCase())) return true;
        return false;
    }

    public boolean hasLettersRemaining(){
        return false;
    }

    public String myToString(){
        return "";
    }

    private static int numberOfLines(String file_name){
        
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

    public static String wordGenerator(String file_name){

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
