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
import java.util.Random;
public class Order implements Comparible, OrderInterface{
	private int orderNum;  //used to store the order number
	private int orderTime;  //used to store the time the order was made
	private DAY orderDay;  //used to store the day the order was made
	private ArrayList<Beverage> listOfBevs = new ArrayList<Beverage>();  //used to store the list of beverages made on the order
	private Customer customer;  //used to store the customer who made the order
	private Random generator = new Random();  //used to generate random numbers
	
	/**
	 * used to generate random numbers between 10000 and 90000
	 * @return the random number generated
	 */
	public int rng()
	{
		orderNum = generator.nextInt(80000) + 10000;
		return orderNum;
	}
	
	/**
	 * constructor for the order class
	 * @param orderTime time that the order was made
	 * @param orderDay day the the order was made
	 * @param customer customer who made the order
	 */
	public Order(int orderTime, DAY orderDay, Customer customer)
	{
		this.orderNum = rng();
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.customer = new Customer(new String(customer.getName()), customer.getAge());
	}
	
	/**
	 * copy constructor for the order class
	 * @param order order to copy 
	 */
	public Order(Order order)
	{
		this.orderNum = order.orderNum;
		this.orderTime = order.orderTime;
		this.orderDay = order.orderDay;
		this.customer = new Customer(new String(order.customer.getName()), order.customer.getAge());
		for(int i = 0; i < order.listOfBevs.size(); i++)
		{
			switch(order.listOfBevs.get(i).getType())
			{
			case COFFEE : this.listOfBevs.add(i, new Coffee(order.listOfBevs.get(i)));
			break;
			
			case ALCOHOL : this.listOfBevs.add(i, new Alcohol(order.listOfBevs.get(i)));
			break;
			
			default : this.listOfBevs.add(i, new Smoothie(order.listOfBevs.get(i)));
			}
		}
	}
	
	/**
	 * add a new beverage to the list of beverages
	 * @param beverage beverage to add to the list
	 */
	public void addNewBeverage(Beverage beverage)
	{
		listOfBevs.add(beverage);
	}
	
	/**
	 * overridden toString method for order class to print order objects into string format
	 */
	public String toString()
	{
		String returnString = orderNum + "\n" + orderTime + "\n" + orderDay + "\n" + customer.getName() + "\n" + customer.getAge() + "\n" + calcOrderTotal() + "\n";
		for(int i = 0; i < listOfBevs.size(); i++)
		{
			returnString += (listOfBevs.get(i).toString() + "\n");
		}
		return returnString;
	}
	
	/**
	 * compares the current order number to the parameter order number
	 * @param order order to compare order numbers with
	 * @return 1 if the current order number is greater, -1 if the other order number is greater, 0 if they are the same
	 */
	public int compareTo(Order order)
	{
		if(this.orderNum > order.orderNum) 
		{
			return 1;
		}
		else if(this.orderNum < order.orderNum) 
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
	
	/**
	 * returns the current order number 
	 * @return the current order number
	 */
	public int getOrderNo()
	{
		return orderNum;
	}
	
	/**
	 * returns the time the order was made
	 * @return the time the order was made
	 */
	public int getOrderTime()
	{
		return orderTime;
	}
	
	/**
	 * returns the day the order was made
	 * @return the day the order was made
	 */
	public DAY getOrderDay()
	{
		return orderDay;
	}
	
	/**
	 * returns the list of beverages
	 * @return the list of beverages
	 */
	public ArrayList<Beverage> getListOfBevs()
	{
		return listOfBevs;
	}
	
	/**
	 * returns the customer who made the order
	 * @return the customer who made the order
	 */
	public Customer getCustomer()
	{
		return customer;
	}
	
	/**
	 * Calculates and returns the total amount for this order
	 * @return total amount for this order
	 */
	public double calcOrderTotal()
	{
		double total = 0;
		for(int i = 0; i < listOfBevs.size(); i++)
		{
			total += listOfBevs.get(i).calcPrice();
		}
		return total;
	}
	
	/**
	 * checks if the day is equal to saturdy or sunday
	 * @param day the day of the week
	 * @return true if the day is a weekend day (Saturday or Sunday)
	 */
	public boolean isWeekend()
	{
		if(orderDay.equals(DAY.SATURDAY)|| orderDay.equals(DAY.SUNDAY))
		{
			return true;
		}
		return false;
	}
	
	/**
	 * returns the beverage listed in the itemNo of the order, for example if
	 * itemNo is 0 this method will return the first beverage in the order
	 * Note: this method returns the shallow copy of the Beverage
	 * 
	 * @return the beverage listed in the itemNo of the order or null if there
	 *         is no item in the order
	 */
	public Beverage getBeverage(int itemNo)
	{
		return listOfBevs.get(itemNo);
	}
	
	/**
	 * adds coffee order to this order
	 * @param bevName beverage name
	 * @param size beverage size of type SIZE
	 * @param extraShot true if the coffee beverage has extra shot , false otherwise
	 * @param extraSyrup true if the coffee beverage has extra syrup , false otherwise
	 */
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup)  //Coffee
	{
		listOfBevs.add(new Coffee(bevName, size, extraShot, extraSyrup));
	}
	
	/**
	 * Adds the Smoothie beverage to this order
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param numOfFruits number of fruits added 
	 * @param addPRotien true if protein is added, false otherwise
	 */
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addProtein)  //Smoothie
	{
		listOfBevs.add(new Smoothie(bevName, size, numOfFruits, addProtein));
	}
	
	/**
	 * adds alcohol order to this order
	 * @param bevName beverage name
	 * @param size beverage size
	 */
	public void addNewBeverage(String bevName, SIZE size)  //Alcohol
	{
		listOfBevs.add(new Alcohol(bevName, size, isWeekend()));
	}
	
	/**
	 * returns the number of beverages of same type in an order
	 * @param type the type of the beverage
	 * @return number of beverages of type type in this order
	 */
	public int findNumOfBeveType(TYPE type)
	{
		int total = 0;
		for(int i = 0; i < listOfBevs.size(); i++)
		{
			if(listOfBevs.get(i).getType().equals(type))
			{
				total++;
			}
		}
		return total;
	}
	
	/**
	 * returns the total number of items in the list of beverages
	 * @return the total number of items in the list of beverages
	 */
	public int getTotalItems()
	{
		return listOfBevs.size();
	}
}
