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
public class Customer {
	private String name;  //used to store name
	private int age;  //used to store age
	
	/**
	 * constructor for customer class
	 * @param name name of the customer
	 * @param age age of the customer
	 */
	public Customer(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	/**
	 * copy constructor for customer class
	 * @param customer customer object to copy 
	 */
	public Customer(Customer customer)
	{
		this.name = new String(customer.name);
		this.age = customer.age;
	}
	
	/**
	 * overridden toString method for customer class to print customer objects into string format
	 */
	public String toString()
	{
		return name + "\n" + age + "\n"; 
	}
	
	/**
	 * returns the name of the customer
	 * @return the name of the customer
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * returns the age of the customer
	 * @return the age of the customer
	 */
	public int getAge()
	{
		return age;
	}
	
	/**
	 * sets the name of customer
	 * @param name name that will be set to the customer
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * sets the age of the customer
	 * @param age age that will be set to the customer
	 */
	public void setAge(int age)
	{
		this.age = age;
	}
}
