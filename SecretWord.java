//Secret Word Class

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

public class SecretWord {

    String actual_word;
    String current_state_of_secret_word;

    public static boolean containsLetter(char letter){
        return false;
    }

    public static boolean hasLettersRemaining(){
        return false;
    }

    public static String myToString(){
        return "";
    }

    public static int numberOfLines(String file_name){
        
        // this variable store the number of lines
        int line_counter = 0;

        // basically i am reading the file and counting the lines
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


}
