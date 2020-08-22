import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
 
public class Solution
{
 
 public static void main(String[] args)
 {
  //code to read values 
  int playerId;
  String playerName;
  int score1, score2, score3;
  Player[] players = new Player[4];
  Scanner s = new Scanner(System.in);
  for(int i=0; i<4;i++){
      playerId = s.nextInt();s.nextLine();
      playerName = s.nextLine();
      score1 = s.nextInt();
      score2 = s.nextInt();
      score3 = s.nextInt();
      players[i] = new Player(playerId, playerName, score1, score2, score3);
  }
  //code to call required method
  int maxScore = findTotalHundredsCount(players);
  Player player = getTopPlayer(players);
  //code to display the result
  if(maxScore != 0)
    System.out.println(maxScore);
  else
    System.out.println("No Hundreds Scored in Tournament");
  System.out.println(player.getPlayerId()+"#"+player.getPlayerName());
 }
 
 public static int findTotalHundredsCount(Player[] players)
  {
   //method logic
   int count = 0;
   for(int i=0; i<players.length; i++){
       if(players[i].getScore1()>=100)count++;
       if(players[i].getScore2()>=100)count++;
       if(players[i].getScore3()>=100)count++;
   }
   return count;
  }
 
public static Player getTopPlayer(Player[] players)
  {
   //method logic
   Player player = new Player();
   int maxScore = players[0].getScore1()+players[0].getScore2()+players[0].getScore3();
   player = players[0];
   for(int i=1;i<players.length;i++){
       int newScore = players[i].getScore1()+players[i].getScore2()+players[i].getScore3();
       if(newScore>=maxScore){
        maxScore = newScore;
        player = players[i];
       }
   }
   return player;
  }
}
     
class Player
{
  //code to build the class
  int playerId;
  String playerName;
  int score1, score2, score3;
  Player(){}
  Player(int playerId, String playerName, int score1, int score2, int score3){
      this.playerId = playerId;
      this.playerName = playerName;
      this.score1 = score1;
      this.score2 = score2;
      this.score3 = score3;
  }
  int getPlayerId(){
      return playerId;
  }
  String getPlayerName(){
      return playerName;
  }
  int getScore1(){
      return score1;
  }
  int getScore2(){
      return score2;
  }
  int getScore3(){
      return score3;
  }
}
