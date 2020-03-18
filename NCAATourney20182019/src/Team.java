//Author: Duncan Beauch
//Program: NCAA Tournament Simulation

public class Team {
   private String teamName;
   private boolean status;
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
   
   public boolean getStatus() {
      return status;
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
   
   public void setStatus(boolean status) {
      this.status = status;
   }
   
   public Team match(Team otherTeam) {
      double ourTeamPoints = (16 - this.getSeed()) * 3 + (this.getPointsPerGame() * Math.random() * 1.5);
      double otherTeamPoints = (16 - otherTeam.getSeed()) * 3 + (otherTeam.getPointsPerGame() * Math.random() * 1.5);
      
      /*if(otherTeam.getSeed() > this.getSeed())
         otherTeamPoints += otherTeam.getSeed() * 2;
      else
         ourTeamPoints += this.getSeed() * 2;*/
      
      if(ourTeamPoints > otherTeamPoints)
         return this;
      else if(ourTeamPoints < otherTeamPoints)
         return otherTeam;
      else if(ourTeamPoints == otherTeamPoints) {
         if(this.getSeed() > otherTeam.getSeed())
            return this;
         else
            return otherTeam;
      }
      return null;
   }
   
   public String toString() {
      return this.getName();
   }
}
