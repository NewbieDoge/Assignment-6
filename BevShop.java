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
import java.util.ArrayList;
public class BevShop implements BevShopInterface{
	private int numOfAlcoholDrinks;  //Number of alcoholic beverages
	private ArrayList<Order> listOfOrders = new ArrayList<Order>();  //list of orders
	private int age;  //used to store age
	private int orderTime;  //used to store order times
	private DAY orderDay;  //used to store order days
	private Customer customer;  //used to reference a customer
	private final int MAX_ALCOHOL = 3;  //the limit for number of alcoholic beverages
	private final int MIN_AGE = 21;  //the minimum age for drinking alcoholic beverages
	private final int MIN_TIME = 8;  //the minimum time to order a beverage
	private final int MAX_TIME = 23;  //the maximum time to order a beverage
	private final int MAX_FRUIT = 5;  //the limit for number of fruits in smoothie
	
	/**
	 * Prints out the BevShop objects in string format
	 * @return a String of the orders and a monthly sale
	 */
	public String toString()
	{
		String returnString = "";
		for(int i = 0; i < listOfOrders.size(); i++)
		{
			returnString += (listOfOrders.get(i).toString() + "\n");
		}
		returnString += totalMonthlySale();
		return returnString;
	}
	
	/**
	 * Checks to see if the order time is valid
	 * @param time gives the time that needs to be checked
	 * @return true if time is within range, false otherwise
	 */
	public boolean validTime(int time)
	{
		if(time >= MIN_TIME && time <= MAX_TIME)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * checks if the number of alcohol beverages for the current order has reached the maximum
	 * @return true if number of alcohol drinks for the current order has reached the maximum, false otherwise
	 */
	public boolean eligibleForMore()
	{
		if(numOfAlcoholDrinks < MAX_ALCOHOL)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * check the valid age for the alcohol drink
	 * @param age the age  
	 * @return returns true if age is more than minimum eligible age , false otherwise  
	 */
	public boolean validAge(int age)
	{
		if(age > MIN_AGE)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Creates a new order ,  NO BEVERAGE is added to the order yet 
	  * @param time time of the order  
	  * @param day day of the order of type DAY
	  * @param customer customer who made the order
	 */
	public void startNewOrder(int time, DAY day, Customer customer)
	{
		listOfOrders.add(new Order(time, day, customer));
		numOfAlcoholDrinks = 0;
	}
	
	/**
	 * Creates a new order ,  NO BEVERAGE is added to the order yet 
	  * @param time time of the order  
	  * @param day day of the order of type DAY
	  * @param customerName customer name 
	  * @param customerAge customer age
	 */
	public void startNewOrder(int time, DAY day, String customerName, int customerAge)
	{
		listOfOrders.add(new Order(time, day, new Customer(customerName, customerAge)));
		numOfAlcoholDrinks = 0;
	}
	
	/**
	 * process the Coffee order for the current order by adding it to the current order
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param extraShot true if the coffee beverage has extra shot , false otherwise
	 * @param extraSyrup true if the coffee beverage has extra syrup , false otherwise
	 */
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup)  //Coffee
	{
		listOfOrders.get(listOfOrders.size()-1).addNewBeverage(bevName, size, extraShot, extraSyrup);
	}
	
	/**
	 * process the Alcohol order for the current order by adding it to the current order
	 * @param bevName beverage name
	 * @param size beverage size
	 */
	public void processAlcoholOrder(String bevName, SIZE size)  //Alcohol
	{
		listOfOrders.get(listOfOrders.size() - 1).addNewBeverage(bevName, size);
	}
	
	/**
	 * process the Smoothie order for the current order  by adding it to the current order
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param numOfFruits number of fruits to be added 
	 * @param addProtein true if protein is added , false otherwise
	 */
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtein)
	{
		listOfOrders.get(listOfOrders.size() - 1).addNewBeverage(bevName, size, numOfFruits, addProtein);
	}
	
	/**
	 * locate an order based on  the order number
	 * @param orderNo the order number
	 * @return the index of the order in the list of Orders  if found or -1 if not found
	 */
	public int findOrder(int orderNo)
	{
		for(int i = 0; i < listOfOrders.size(); i++)
		{
			if(listOfOrders.get(i).getOrderNo() == orderNo)
			{
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * locates an order in the list of orders and returns the total value on the order.
	 * @param orderNo the order number
	 * @returns the calculated price on this order.
	 */
	public double totalOrderPrice(int orderNo)
	{
		for(int i = 0; i < listOfOrders.size(); i++)
		{
			if(listOfOrders.get(i).getOrderNo() == orderNo)
			{
				return listOfOrders.get(i).calcOrderTotal();
			}
		}
		return -1;
	}
	
	/**
	 * Calculates the total sale of all the orders for this beverage shop
	 *  @return the total sale of all the orders 
	 */
	public double totalMonthlySale()
	{
		double total = 0;
		for(int i = 0; i < listOfOrders.size(); i++)
		{
			total += listOfOrders.get(i).calcOrderTotal();
		}
		return total;
	}
	
	/**
	 * sorts the orders within this bevShop using the Selection
	 * sort algorithm
	 */
	public void sortOrders()
	{
		for(int i = 0; i < listOfOrders.size() - 1; i++)
		{
			int leastTemp = listOfOrders.get(i).getOrderNo();
			for(int j = i+1; j < listOfOrders.size(); j++)
			{
				if(listOfOrders.get(j).getOrderNo() < leastTemp)
				{
					Order orderTemp = listOfOrders.get(j);
					listOfOrders.set(j, listOfOrders.get(i));
					listOfOrders.set(i, orderTemp);
				}
			}
		}
	}
	
	/**
	 * returns Order in the list of orders at the index
	 * Notes: this method returns the shallow copy of the order
	 * @return Order in the list of orders at the index 
	 */
	public Order getOrderAtIndex(int index)
	{
		return listOfOrders.get(index);
	}
	
	/**
	 * returns the maximum number of alcoholic drinks
	 * @return 3
	 */
	public int getMaxOrderForAlcohol()
	{
		return MAX_ALCOHOL;
	}
	
	/**
	 * returns the minimum age required for drinking alcohol
	 * @return 21
	 */
	public int getMinAgeForAlcohol()
	{
		return MIN_AGE;
	}
	
	/**
	 * returns the current order 
	 * @return a deep copy of the current order
	 */
	public Order getCurrentOrder()
	{
		return new Order(listOfOrders.get(listOfOrders.size() -1));
	}
	
	/**
	 * returns the number of alcoholic drinks in the current order
	 * @return the number of alcoholic drinks in the current order
	 */
	public int getNumOfAlcoholDrink()
	{
		return numOfAlcoholDrinks;
	}
	
	/**
	 * checks if the max fruit count is reached
	 * @param num number of fruits to check
	 * @return true if the number is less than 5, false otherwise
	 */
	public boolean isMaxFruit(int num)
	{
		if(num > MAX_FRUIT)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * returns the number of orders in the order list
	 * @return the number of orders in the order list
	 */
	public int totalNumOfMonthlyOrders()
	{
		return listOfOrders.size();
	}
}
