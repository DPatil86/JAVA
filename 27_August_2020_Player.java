import java.util.*;
public class Solution{
    public static void main(String[] args){
        int playerId;
        String skill;
        String level;
        int points;
        Scanner s = new Scanner(System.in);
        Player[] player = new Player[4];
        for(int i=0; i<player.length; i++){
            playerId = s.nextInt();s.nextLine();
            skill = s.nextLine();
            level = s.nextLine();
            points = s.nextInt();
            player[i] = new Player(playerId, skill, level, points);
        }
        s.nextLine();
        String getSkill = s.nextLine();
        String getLevel = s.nextLine();
        s.close();
        int getPoints = findPointsForGivenSkill(player, getSkill);
        Player p = getPlayerBasedOnLevel(player, getSkill, getLevel);
        
        if(getPoints == 0)
        	System.out.println("The given Skill is not available");
        else
        	System.out.println(getPoints);
        
        if(p == null)
        	System.out.println("No player is available with specified level, skill and eligibility points");
        else
        	System.out.println(p.getPlayerId());
    }
    public static int findPointsForGivenSkill(Player[] players, String skill) {
    	int count = 0;
    	for(int i=0; i<players.length; i++) {
    		if(skill.equalsIgnoreCase(players[i].getSkill()))
    			count += players[i].getPoints();
    	}
    	return count;
    }
    public static Player getPlayerBasedOnLevel(Player[] players, String skill, String level) {
    	for(int i=0; i<players.length; i++) {
    		if(skill.equalsIgnoreCase(players[i].getSkill()) && level.equalsIgnoreCase(players[i].getLevel()) && players[i].getPoints()>=20)
    			return players[i];
    	}
    	return null;
    }
}
class Player{
	int playerId;
    String skill;
    String level;
    int points;
    Player(){}
    Player(int playerId, String skill, String level, int points){
    	this.playerId = playerId;
    	this.skill = skill;
    	this.level = level;
    	this.points = points;
    }
    int getPlayerId() {
    	return playerId;
    }
    String getSkill() {
    	return skill;
    }
    String getLevel() {
    	return level;
    }
    int getPoints() {
    	return points;
    }
}
