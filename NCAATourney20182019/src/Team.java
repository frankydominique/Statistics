//Author: Duncan Beauch
//Modified by Franky PC
//Program: NCAA Tournament Simulation

public class Team {
   private String teamName;
   private int seed;
   private double pointsPerGame;
   private int wins;
   
   Team(String teamName, int seed, double pointsPerGame) {
      this.teamName = teamName;
      this.seed = seed;
      this.pointsPerGame = pointsPerGame;
      wins = 0;
   }
   
   public String getName() {
      return teamName;
   }
   
   public int getSeed() {
      return seed;
   }
   
   public double getPointsPerGame() {
      return pointsPerGame;
   }

   public int getWins() {
      return wins;
   }
   
   public void addWin() {
      wins++;
   }
   
   public void addWins(int n) {
      wins += n;
   }
   
   /**
    * this method simulates which team will win
    * @param otherTeam the team being competed against
    * @return the winner of this match up
    */
   public Team match(Team otherTeam) {

	  //gets the probability each team will win with a random factor
	  double collectivePoints = this.getPointsPerGame() + otherTeam.getPointsPerGame();
	  double thisTeamProb = ((Math.random() * 1.5) * this.getPointsPerGame()) / collectivePoints;
	  double otherTeamProb = ((Math.random() * 1.5) * otherTeam.getPointsPerGame()) / collectivePoints;
	  
	  //gives a small probability edge to the higher seeded team
	  int seedDiff = this.getSeed() - otherTeam.getSeed();
	  thisTeamProb -= seedDiff / 16.0;
	  
	  //returns the team with the higher probability
	  if(thisTeamProb > otherTeamProb)
		  return this;
	  else if(thisTeamProb < otherTeamProb)
		  return otherTeam;
	  else if(thisTeamProb == otherTeamProb)
	  {
		  thisTeamProb *= (Math.random() * 1.5);
		  otherTeamProb *= (Math.random() * 1.5);
		  if(thisTeamProb > otherTeamProb)
			  return this;
		  else if(thisTeamProb < otherTeamProb)
			  return otherTeam;
	  }
	   
      return null;
   }
   
   public String toString() {
      return this.getName() + " " + this.getPointsPerGame() + " " + this.getSeed();
   }
}
