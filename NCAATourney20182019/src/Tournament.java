//Author: Duncan Beauch
//Modified by Franky PC
//Program: NCAA Tournament Simulation
//Team Statistics: https://www.foxsports.com/college-basketball/team-stats?season=2018&category=scoring&group=2&sort=1&time=0
import java.io.*;
import java.util.*;

public class Tournament {
   public static void main(String[] args) {
      int runs = 300;
      
      //modified by Franky
      Team[] east = new Team[16];
      try {
    	  east = enterTeam(new File("EastBracket.txt"));
      } catch(FileNotFoundException e)
      {
    	  System.out.println("error");
      }
      
      //modified by franky
      Team[] west = new Team[16];
      try{
    	  west = enterTeam(new File("WestBracket.txt"));
      } catch (FileNotFoundException e)
      {
    	  System.out.println("error");
      }
      
      //modified by franky
      Team[] south = new Team[16]; 
      try{
   	   south = enterTeam(new File("SouthBracket.txt"));
     } catch (FileNotFoundException e)
     {
      	  System.out.println("error");
     }
      
      //modified by franky
      Team[] midwest = new Team[16];
      try{
   	   midwest = enterTeam(new File("MidwestBracket.txt"));
     } catch (FileNotFoundException e)
     {
      	  System.out.println("error");
     }
      
      //process modified by franky
      for(int i = 0; i < runs; i++) {
         //East
      
      Team eastWinner = conferenceTourney(east);
         //End of East
         
         //West
      Team westWinner = conferenceTourney(west);
         //End of West
      
         //South
      
      Team southWinner = conferenceTourney(south);
         //End of South
         
         //Midwest
      Team midwestWinner = conferenceTourney(midwest);
         //End of Midwest
      
         //Adds a tournament win to the finals winner
      (eastWinner.match(westWinner).match(southWinner.match(midwestWinner))).addWin();
      
      }
      
      int otherWins = runs - east[0].getWins() - west[0].getWins() - south[0].getWins() - midwest[0].getWins();
      System.out.printf("Duke Wins: %d%nGonzaga Wins: %d%nUVA Wins: %d%nUNC Wins: %d%nOther: %d%n%n", east[0].getWins(), west[0].getWins(), south[0].getWins(), midwest[0].getWins(), otherWins);
      System.out.printf("UVA wins %.2f%% of the runs", south[0].getWins() / (double)runs * 100.0);
   }
   
   /**
    * this method was created by Franky to read the files about each conference rather than to right and pair
    * them by hand
    * @param bracket the bracket of teams from this conference (west, east, south, midwest)
    * @return a new array of Team objects representing each team in the conference on the bracket
    * @throws FileNotFoundException
    */
   public static Team[] enterTeam(File bracket) throws FileNotFoundException
   {
	   Team[] team = new Team[16];
	   Scanner scanner = new Scanner(bracket);
	   int pos = 0;
	   int seed = 1;
	   
	   while(scanner.hasNextLine())
	   {
		   String stats = scanner.nextLine();
		   String name = stats.substring(0, stats.lastIndexOf(' '));
		   double ppg = Double.parseDouble(stats.substring(stats.lastIndexOf(' ')));
		   team[pos] = new Team(name, seed, ppg);
		   pos++;
		   seed++;
	   }
	   
	   scanner.close();
	   
	   return team;
   }
   
   /**
    * this conference tourney was originally created by duncan and then was modified by franky
    * she used the same layout but switched out which arrays were used to better match the bracket.
    * duncan lined teams up with consecutive pairing while franky made sure to follow the line ups
    * and order of the brackets
    * @param team an array of the teams in this conference
    * @return the winner of this conference
    */
   public static Team conferenceTourney(Team[] team)
   {
	   Team[] eight = {
			      team[0].match(team[15]), 
			      team[7].match(team[8]), 
			      team[4].match(team[11]), 
			      team[3].match(team[12]), 
			      team[5].match(team[10]), 
			      team[2].match(team[13]), 
			      team[6].match(team[9]), 
			      team[1].match(team[14]), 
			      };
			      
			      Team[] quarters = {
			      eight[0].match(eight[1]),
			      eight[2].match(eight[3]),
			      eight[4].match(eight[5]),
			      eight[6].match(eight[7]),
			      };
			      
			      Team[] semis = {
			      quarters[0].match(quarters[1]),
			      quarters[2].match(quarters[3]),
			      };
			      
			      Team winner = semis[0].match(semis[1]);
			         //End of East
			      
			      return winner;
   }
}

