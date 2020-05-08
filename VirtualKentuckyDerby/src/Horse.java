
public class Horse {

	private String name;
	private double payOff;
	private int wins;
	
	public Horse(String name, double payOff)
	{
		this.name = name;
		this.payOff = payOff;
		wins = 0;
	}
	
	public double generateProbability()
	{
		double probability = 1.0 / 13 * (int)(Math.random() * 13) * payOff;
		return probability;
	}
	
	public void addWins()
	{
		wins++;
	}
	
	public int getWins()
	{
		return wins;
	}
	
	public String toString()
	{
		return name + ", " + payOff;
	}
}
