// Previous Game Result class

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  

public class PreviousGameResult {

    //private DateTimeFormatter date_time;
    private String date_played;
    private int points;

    public PreviousGameResult(int points){
        setDatePlayed();
        setPoints(points);
    }

    public String getDatePlayed(){ return date_played; }
    private void setDatePlayed(){
        DateTimeFormatter date_played = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now(); 
        this.date_played = date_played.format(now);
    }

    public int getPoints(){ return points; }
    private void setPoints(int points){ this.points = points; }

    public String toString(){
        return getDatePlayed() + "\n" + "Total points: " + getPoints();
    }

}
