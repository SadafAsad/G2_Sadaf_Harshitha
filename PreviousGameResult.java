// Previous Game Result class

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;   

public class PreviousGameResult {

    //private DateTimeFormatter date_time;
    private String datePlayed;
    private int points = 0;

    private ArrayList<String> resultsOfGames = new  ArrayList<String>(); 
    
    
    public PreviousGameResult(int points){
    	setDatePlayed();
        setPoints(points); 
    }

    public String getDatePlayed(){ return datePlayed; }
    
    private void setDatePlayed(){
        DateTimeFormatter datePlayed = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now(); 
        this.datePlayed = datePlayed.format(now);
    }

    public int getPoints(){ return points; }
    public void setPoints(int points){ this.points = points; }
    
    public void convertResultsIntoList(String datePlayed, int points) {
    	this.resultsOfGames.add("Date/Time: " + this.datePlayed + "\n" + "Score: " + getPoints() + "\n");  
    }
    
    
    public String toString(){
    	return "Date/Time: " + this.datePlayed + "\n" + "Score: " + getPoints() + "\n";
    }
    
    public void storeValues() throws IOException {

    	BufferedWriter writer = new BufferedWriter(new FileWriter(new File("previous_results.txt"),true));
    	
    	String stuffToWrite = toString();

    	writer.write(stuffToWrite);
    	
    	writer.close();

    }
    
}
