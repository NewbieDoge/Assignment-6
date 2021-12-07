/*
 * Class: CMSC203 
 * Instructor: Dr. Kuijt
 * Description: Models a beverage shop's daily/monthly ordering system
 * Due: 12/6/2021
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Darren Yang
*/
public class Smoothie extends Beverage{
	private final double FRUIT_MULTIPLIER = .5;  //used to store the fruit cost constant
	private final double PROTEIN_POWDER_COST = 1.5;  //used to store the protein powder cost constant
	
	/**
	 * constructor for smoothie class
	 * @param name name of beverage
	 * @param size size of beverage
	 * @param numOfFruits number of fruits customer wants
	 * @param proteinPowder used to determine whether the customer wants protein powder in their smoothie
	 */
	public Smoothie(String name, SIZE size, int numOfFruits, boolean proteinPowder)
	{
		super(name, TYPE.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.proteinPowder = proteinPowder;
	}
	
	/**
	 * copy constructor for smoothie class
	 * @param smoothie smoothie object to copy
	 */
	public Smoothie(Beverage smoothie)
	{
		super(smoothie.getBevName(), smoothie.getType(), smoothie.getSize());
		this.proteinPowder = smoothie.proteinPowder;
		this.numOfFruits = smoothie.numOfFruits;
	}
	
	/**
	 * overridden toString method for smoothie class to print smoothie objects into string format
	 */
	public String toString()
	{
		String returnString = super.toString();
		if(proteinPowder)
		{
			returnString += "Contains protein powder\n";
		}
		else
		{
			returnString += "Does not contain protein powder\n";
		}
		
		returnString += (numOfFruits + "\n");
		returnString += calcPrice();
		return returnString;
	}
	
	/**
	 * determines if the current smoothie object is equal to another smoothie object
	 * @return true if they are the same, false otherwise
	 */
	public boolean equals(Beverage beverage)
	{
		if(this.getBevName().equals(beverage.getBevName()) && this.getType().equals(beverage.getType()) && this.getSize().equals(beverage.getSize()))
		{
			return true;
		}
		return false;
	}
	
	/**
	 * used to calculate cost of the smoothie beverage
	 * @return the cost of the smoothie beverage
	 */
	public double calcPrice()
	{
		double total = (super.getBasePrice() + (super.getSize().ordinal() * super.getSizePrice()) + (FRUIT_MULTIPLIER * (double)numOfFruits));
		if(proteinPowder)
		{
			total += PROTEIN_POWDER_COST;
		}
		return total;
	}
	
	/**
	 * returns the number of fruits
	 * @return the number of fruits
	 */
	public int getNumOfFruits()
	{
		return numOfFruits;
	}
	
	/**
	 * returns whether the customer wants protein powder
	 * @return whether the customer wants protein powder
	 */
	public boolean getAddProtein()
	{
		return proteinPowder;
	}
}
