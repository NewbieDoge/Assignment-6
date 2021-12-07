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
public class Coffee extends Beverage{
	private final double EXTRA_COFFEE_PRICE = .5;  //used to store the extra shot constant
	private final double EXTRA_SYRUP_PRICE = .5;  //used to store the extra syrup constant
	
	/**
	 * constructor for coffee class
	 * @param name name of the beverage
	 * @param size size of the beverage
	 * @param extraCoffee boolean to determine if the customer wants an extra shot
	 * @param extraSyrup boolean to determine if the customer wants extra syrup
	 */
	public Coffee(String name, SIZE size, boolean extraCoffee, boolean extraSyrup)
	{
		super(name, TYPE.COFFEE, size);
		this.extraCoffee = extraCoffee;
		this.extraSyrup = extraSyrup;
	}
	
	/**
	 * copy constructor for coffee class
	 * @param coffee beverage to copy 
	 */
	public Coffee(Beverage coffee)
	{
		super(coffee.getBevName(), coffee.getType(), coffee.getSize());
		this.extraCoffee = coffee.extraCoffee;
		this.extraSyrup = coffee.extraSyrup;
	}
	
	/**
	 * overridden toString method for coffee class to print coffee objects into string format
	 */
	public String toString()
	{
		String returnString = super.toString();
		if(extraCoffee)
		{
			returnString += "Contains extra shot\n";
		}
		else
		{
			returnString += "Does not contain extra shot\n";
		}
		
		if(extraSyrup)
		{
			returnString += "Contains extra syrup\n";
		}
		else
		{
			returnString += "Does not contain extra syrup\n";
		}
		
		returnString += calcPrice();
		return returnString;
	}
	
	/**
	 * used to calculate cost of the coffee beverage
	 * @return the cost of the coffee beverage
	 */
	public double calcPrice()
	{
		double total = (super.getBasePrice() + (super.getSize().ordinal() * super.getSizePrice()));
		//System.out.println(extraCoffee);
		if(getExtraShot())
		{
			total += EXTRA_COFFEE_PRICE;
		}
		if(getExtraSyrup())
		{
			total += EXTRA_SYRUP_PRICE;
		}
		//System.out.println(total + "     alkjdflkjasdl lkjalskdf");
		return total;
	}
	
	/**
	 * determines if the current coffee object is equal to another coffee object
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
	 * returns whether the customer wants an extra shot
	 * @return whether the customer wants an extra shot
	 */
	public boolean getExtraShot()
	{
		return extraCoffee;
	}
	
	/**
	 * returns whether the customer wants extra syrup
	 * @return whether the customer wants extra syrup
	 */
	public boolean getExtraSyrup()
	{
		return extraSyrup;
	}
}
