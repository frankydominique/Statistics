import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VirtualDerbySimulation {

	public static Horse[] enterHorses(File field) throws FileNotFoundException
	   {
		   Horse[] horse = new Horse[13];
		   Scanner scanner = new Scanner(field);
		   int pos = 0;
		   
		   while(scanner.hasNextLine())
		   {
			   String line = scanner.nextLine();
			   String name = line.substring(0, line.lastIndexOf(' '));
			   double payoff = Double.parseDouble(line.substring(line.lastIndexOf(' ')));
			   horse[pos] = new Horse(name, payoff);
			   pos++;
		   }
		   
		   scanner.close();
		   
		   return horse;
	   }
	
	public static Horse determineWinner(Horse[] field)
	{
		Horse winner = field[0];
		double winnerProbability = 0;
		
		for(Horse horse: field)
		{
			double current = horse.generateProbability();
			if(current > winnerProbability)
			{
				winner = horse;
				winnerProbability = current;
			}
		}
		
		return winner;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Horse[] field = new Horse[13];
		try {
			field = enterHorses(new File("Field.txt"));
		} catch (FileNotFoundException e)
		{
			System.out.println("Error");
		}
		
		for(int i = 0; i < 1000; i++)
		{	
			Horse winner = determineWinner(field);
			winner.addWins();
		}
		
		for(Horse horse: field)
			System.out.println(horse + " chances: " + horse.getWins() / 1000.0);
		
		
	}

}
