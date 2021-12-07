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
public abstract class Beverage {
	private String name;  //used to store the name of the drink
	private final double basePrice = 2;  //used to store the base price constant
	private final double sizePrice = 1;  //used to store the size price constant
	private SIZE size;  //used to store the size of the beverage
	private TYPE type;  //used to store the type of beverage
	protected boolean extraCoffee;  //used to determine if the customer wants double shot in their coffee
	protected boolean extraSyrup;  //used to determine if the customer wants extra syrup in their coffee
	protected boolean offeredOnWeekend;  //used to determine if alcoholic drinks are offered on the weekends
	protected int numOfFruits;  //used to determine how many fruits the customer wants in their smoothie
	protected boolean proteinPowder;  //used to determine if the customer wants protein powder in their smoothie
	
	/**
	 * constructor for beverage class
	 * @param name name of beverage
	 * @param type type of beverage
	 * @param size size of beverage
	 */
	public Beverage(String name, TYPE type, SIZE size)
	{
		this.name = new String(name);
		this.type = type;
		this.size = size;
	}
	
	/**
	 * abstract method to be defined in subclasses, used to calculate cost of each beverage
	 * @return cost of beverage
	 */
	public abstract double calcPrice();
	
	/**
	 * overridden toString method for beverage class to print beverage objects into string format
	 */
	public String toString()
	{
		return name + "\n" + size + "\n";
	}
	
	/**
	 * determines if the current beverage object is equal to another beverage object
	 * @param beverage beverage object to compare with
	 * @return true if they are the same, false otherwise
	 */
	public boolean equals(Beverage beverage)
	{
		if(this.name.equals(beverage.name) && this.size.equals(beverage.size)&& this.type.equals(beverage.type))
		{
			return true;
		}
		return false;
	}
	
	/**
	 * returns the base price constant
	 * @return the base price constant
	 */
	public double getBasePrice()
	{
		return basePrice;
	}
	
	/**
	 * returns the name of the beverage
	 * @return the name of the beverage
	 */
	public String getBevName()
	{
		return name;
	}
	
	/**
	 * returns the size constant 
	 * @return the size constant
	 */
	public double getSizePrice()
	{
		return sizePrice;
	}
	
	/**
	 * returns the size of the beverage
	 * @return the size of the beverage
	 */
	public SIZE getSize()
	{
		return size;
	}
	
	/**
	 * returns the type of the beverage
	 * @return the type of the beverage
	 */
	public TYPE getType()
	{
		return type;
	}
}
