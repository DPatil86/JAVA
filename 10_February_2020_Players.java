import java.util.*;
import java.lang.*;
 
public class Main
{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); //creating a scanner object to read values from keyboard
        Players[] players = new Players[4]; //creating an array of player objects
        for(int i=0; i<players.length; i++){
            int id = s.nextInt();s.nextLine();
            String name = s.nextLine();
            int exp = s.nextInt();
            int matchesPlayed = s.nextInt();
            int runsScored = s.nextInt();
            players[i] = new Players(id, name, exp, matchesPlayed, runsScored); //assigning all the read values to player objects one by one
        }
        int target = s.nextInt();
        double avgRuns[] = calculateAvg(players, target); //calling calculateAvg from main method
        for(int i=0; i<avgRuns.length; i++){
            if(avgRuns[i]>=75)
                System.out.println("Grade A");
            else if(avgRuns[i]>=50 && avgRuns[i]<=74)
                System.out.println("Grade B");
            else
                System.out.println("Grade C");
        }
    }
    public static double[] calculateAvg(Players[] obj, int target){
        double arr[];
        int j = 0;
        for(int i=0; i<obj.length; i++){
            if(obj[i].getMatchesPlayed()<=target) //if the player matches player is less than or equal to target value, then condition works
                j+=1;
        }
        arr = new double[j];
        j = 0;
        for(int i=0; i<obj.length;i++){
            if(obj[i].getMatchesPlayed()<=target)
                arr[i] = (double) (obj[i].getRunsScored()/obj[i].getMatchesPlayed()); //finding avg of each player matches
        }
        return arr;
    }
}
 
class Players{
    int id;
    String name;
    int exp;
    int matchesPlayed;
    int runsScored;
    public Players(int id, String name, int exp, int matchesPlayed, int runsScored){
        this.id = id;
        this.name = name;
        this.exp = exp;
        this.matchesPlayed = matchesPlayed;
        this.runsScored = runsScored;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getExp(){
        return exp;
    }
    public int getMatchesPlayed(){
        return matchesPlayed;
    }
    public int getRunsScored(){
        return runsScored;
    }
}
