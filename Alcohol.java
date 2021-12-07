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
public class Alcohol extends Beverage{
	private final double WEEKEND_PRICE = .6;  //used to store the weekend price constant
	
	/**
	 * constructor for alcohol class
	 * @param name name of beverage
	 * @param size size of beverage
	 * @param offeredOnWeekend determines whether it is offere on weekends
	 */
	public Alcohol(String name, SIZE size, boolean offeredOnWeekend)
	{
		super(name, TYPE.ALCOHOL, size);
		this.offeredOnWeekend = offeredOnWeekend;
	}
	
	/**
	 * copy constructor for alcohol class
	 * @param alcohol alcohol object to copy
	 */
	public Alcohol(Beverage alcohol)
	{
		super(alcohol.getBevName(), alcohol.getType(), alcohol.getSize());
		this.offeredOnWeekend = alcohol.offeredOnWeekend;
	}
	
	/**
	 * overridden toString method for alcohol class to print alcohol objects into string format
	 */
	public String toString()
	{
		String returnString = super.toString();
		if(offeredOnWeekend)
		{
			returnString += "Offered on weekends\n";
		}
		else
		{
			returnString += "Not offered on weekends\n";
		}
		
		returnString += calcPrice();
		return returnString;
	}
	
	/**
	 * determines if the current alcohol object is equal to another alcohol object
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
	 * used to calculate cost of the alcohol beverage
	 * @return the cost of the alcohol beverage
	 */
	public double calcPrice()
	{
		double total = (super.getBasePrice() + (super.getSize().ordinal() * super.getSizePrice()));
		if(offeredOnWeekend)
		{
			total += WEEKEND_PRICE;
		}
		return total;
	}
	
	/**
	 * returns whether alcoholic drinks are offered on the weekends
	 * @return whether alcoholic drinks are offered on the weekends
	 */
	public boolean getWeekend()
	{
		return offeredOnWeekend;
	}
}
