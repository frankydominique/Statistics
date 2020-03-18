//Author: Duncan Beauch
//Program: NCAA Tournament Simulation
//Team Statistics: https://www.foxsports.com/college-basketball/team-stats?season=2018&category=scoring&group=2&sort=1&time=0
import java.io.*;
import java.util.*;

public class Tournament {
   public static void main(String[] args) {
      int runs = 300;
      
      Team[] east = {
      new Team("Duke", 1, 76.0),
      new Team("North Dakota", 16, 70.0),
      new Team("VCU", 8, 58.0),
      new Team("Central Florida", 9, 59.5),
      new Team("Mississippi State", 5, 76.0),
      new Team("Liberty", 12, 69.0),
      new Team("VT", 4, 68.7),
      new Team("StLouis", 13, 52.0),
      new Team("Maryland", 6, 73.0),
      new Team("Belmont", 11, 79.0),
      new Team("LSU", 3, 70.3),
      new Team("Yale", 14, 74.0),
      new Team("Louisville", 7, 76.0),
      new Team("Minnesota", 10, 68.0),
      new Team("MichState", 2, 69.0),
      new Team("Bradley", 15, 65.0),
      };
      
      /*Team[] west = {
      new Team("Gonzaga", 1, 77.8),
      new Team("Fairleigh", 16, 65.5),
      new Team("Syracuse", 8, 69.0),
      new Team("Baylor", 9, 74.5),
      new Team("Marquette", 5, 64.0),
      new Team("Murray", 12, 72.5),
      new Team("FSU", 4, 74.7),
      new Team("Vermont", 13, 69.0),
      new Team("Buffalo", 6, 74.5),
      new Team("Arizona State", 11, 74.0),
      new Team("TexasTech", 3, 71.0),
      new Team("NKY", 14, 57.0),
      new Team("Nevada", 7, 61.0),
      new Team("Florida", 10, 59.5),
      new Team("Michigan", 2, 60.7),
      new Team("Montana", 15, 55.0),
      };*/
      Team[] west;
      try{
    	  west = enterTeamWest(new File("Bracket.txt"));
      } catch (FileNotFoundException e)
      {
    	  System.out.println("error");
      }
      
      Team[] south = {
      new Team("UVA", 1, 69.2),
      new Team("Gardner", 16, 56.0),
      new Team("Mississippi", 8, 76.0),
      new Team("Oklahoma", 9, 73.0),
      new Team("Wisconsin", 5, 54.0),
      new Team("Oregon", 12, 64.7),
      new Team("Kansas State", 4, 64.0),
      new Team("UC Irvine", 13, 62.0),
      new Team("Villanova", 6, 61.0),
      new Team("Saint Mary's", 11, 57.0),
      new Team("Purdue", 3, 80.5),
      new Team("OldDominion", 14, 48.0),
      new Team("Cincinnati", 7, 72.0),
      new Team("Iowa", 10, 78.0),
      new Team("Tennessee", 2, 84.7),
      new Team("Colgate", 15, 70.0),
      };
      
      Team[] midwest = {
      new Team("North Carolina", 1, 83.0),
      new Team("Iona", 16, 73.0), 
      new Team("Utah State", 8, 61.0), 
      new Team("Washington", 9, 68.5), 
      new Team("Auburn", 5, 80.6), 
      new Team("New Mexico State", 12, 77.0), 
      new Team("Kansas", 4, 81.0), 
      new Team("Northeastern", 13, 53.0), 
      new Team("Iowa State", 6, 59.0),
      new Team("Ohio State", 11, 60.5), 
      new Team("Houston", 3, 72.0),
      new Team("Georgia State", 14, 55.0), 
      new Team("Wofford", 7, 70.0), 
      new Team("Seton Hall", 10, 68.0),
      new Team("Kentucky", 2, 68.5),
      new Team("Abilene Christ", 15, 44.0),
      };
      
      for(int i = 0; i < runs; i++) {
         //East
      Team[] eastEight = {
      east[0].match(east[1]), 
      east[2].match(east[3]), 
      east[4].match(east[5]), 
      east[6].match(east[7]), 
      east[8].match(east[9]), 
      east[10].match(east[11]), 
      east[12].match(east[13]), 
      east[14].match(east[15]), 
      };
      
      Team[] eastQuarters = {
      eastEight[0].match(east[1]),
      eastEight[2].match(east[3]),
      eastEight[4].match(east[5]),
      eastEight[6].match(east[7]),
      };
      
      Team[] eastSemis = {
      eastQuarters[0].match(east[1]),
      eastQuarters[2].match(east[3]),
      };
      
      Team eastWinner = eastSemis[0].match(eastSemis[1]);
         //End of East
         
         //West
      Team[] westEight = {
      west[0].match(west[1]), 
      west[2].match(west[3]), 
      west[4].match(west[5]), 
      west[6].match(west[7]), 
      west[8].match(west[9]), 
      west[10].match(west[11]), 
      west[12].match(west[13]), 
      west[14].match(west[15]), 
      };
      
      Team[] westQuarters = {
      westEight[0].match(west[1]),
      westEight[2].match(west[3]),
      westEight[4].match(west[5]),
      westEight[6].match(west[7]),
      };
      
      Team[] westSemis = {
      westQuarters[0].match(west[1]),
      westQuarters[2].match(west[3]),
      };
      
      Team westWinner = westSemis[0].match(westSemis[1]);
         //End of West
      
         //South
      Team[] southEight = {
      south[0].match(south[1]), 
      south[2].match(south[3]), 
      south[4].match(south[5]), 
      south[6].match(south[7]), 
      south[8].match(south[9]), 
      south[10].match(south[11]), 
      south[12].match(south[13]), 
      south[14].match(south[15]), 
      };
      
      Team[] southQuarters = {
      southEight[0].match(south[1]),
      southEight[2].match(south[3]),
      southEight[4].match(south[5]),
      southEight[6].match(south[7]),
      };
      
      Team[] southSemis = {
      southQuarters[0].match(south[1]),
      southQuarters[2].match(south[3]),
      };
      
      Team southWinner = southSemis[0].match(southSemis[1]);
         //End of South
         
         //Midwest
      Team[] midwestEight = {
      midwest[0].match(midwest[1]), 
      midwest[2].match(midwest[3]), 
      midwest[4].match(midwest[5]), 
      midwest[6].match(midwest[7]), 
      midwest[8].match(midwest[9]), 
      midwest[10].match(midwest[11]), 
      midwest[12].match(midwest[13]), 
      midwest[14].match(midwest[15]), 
      };
      
      Team[] midwestQuarters = {
      midwestEight[0].match(midwest[1]),
      midwestEight[2].match(midwest[3]),
      midwestEight[4].match(midwest[5]),
      midwestEight[6].match(midwest[7]),
      };
      
      Team[] midwestSemis = {
      midwestQuarters[0].match(midwest[1]),
      midwestQuarters[2].match(midwest[3]),
      };
      
      Team midwestWinner = midwestSemis[0].match(midwestSemis[1]);
         //End of Midwest
      
         //Adds a tournament win to the finals winner
      (eastWinner.match(westWinner).match(southWinner.match(midwestWinner))).addWin();
      
      }
      
      //System.out.printf("East Winner: %s%nWest Winner: %s%nSouth Winner: %s%nMidwest Winner: %s%n", eastWinner, westWinner, southWinner, midwestWinner);
      //System.out.printf("%nAnd the winner is...%s!!!", winner);
      
      int otherWins = runs - east[0].getWins() - west[0].getWins() - south[0].getWins() - midwest[0].getWins();
      System.out.printf("Duke Wins: %d%nGonzaga Wins: %d%nUVA Wins: %d%nUNC Wins: %d%nOther: %d%n%n", east[0].getWins(), west[0].getWins(), south[0].getWins(), midwest[0].getWins(), otherWins);
      System.out.printf("UVA wins %.2f%% of the runs", south[0].getWins() / (double)runs * 100.0);
   }
   
   public static Team[] enterTeamWest(File westBracket) throws FileNotFoundException
   {
	   Team[] westTeam = new Team[16];
	   Scanner scanner = new Scanner(westBracket);
	   int pos = 0;
	   int seed = 1;
	   
	   while(scanner.hasNextLine())
	   {
		   String stats = scanner.nextLine();
		   String name = stats.substring(0, stats.lastIndexOf(' '));
		   double ppg = Double.parseDouble(stats.substring(stats.lastIndexOf(' ')));
		   westTeam[pos] = new Team(name, seed, ppg);
		   pos++;
		   seed++;
	   }
	   
	   return westTeam;
   }
}

