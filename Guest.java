import java.util.ArrayList;

/** 
 * @author Jasper Burroughs 
 * @since 11/16/23
 * 
 * This file declares a Guest class, which contains an id number, a name, a company, and a table number
 * This file contains methods to get the information and set the information for a Guest
 * This file contains a method to convert all of the person's information to a string and use a passed in list to get the name of teh company that corresponds to the number
 */

public class Guest {
	String name;
	int company;
	int id;
	int tableNum;
	ArrayList<Guest> allPeople;
	
	public Guest(String initName, int initCompany, int initId) {
		name = initName;
		company = initCompany;
		id = initId;
		//Table number is -1 because it has not been declared yet
		tableNum = -1;
	}
	
	/*
	 * returns the number that represents the company that the Guest belongs to
	 */
	public int getCompany() {
		return company;
	}
	/*
	 * returns the name of the company that the Guest belongs to
	 */
	public String getCompanyName(ArrayList<Company> companies) {
		String theString = "";
		for (Company c : companies) {
			if (c.getNum() == company) {
				theString += c.getName();
			}
		}
		return theString;
	}
	/*
	 * returns the table number that the Guest has been assigned to
	 */
	public int getTable() {
		return tableNum;
	}
	/*
	 * returns the name of the Guest
	 */
	public String getName() {
		return name;
	}
	/*
	 * returns the id of the Guest
	 */
	public int getId() {
		return id;
	}
	/*
	 * sets the table number to a pssed in int
	 */
	public void setTabNum(int num) {
		tableNum = num;
		
	}
	
	/*
	 * converts all of the person's information to a string
	 * looks through a passed in list of companies to get the name of the company that the number corresponds to
	 */
	public String toString(ArrayList<Company> companies) {
		String theString = "";
		theString += "ID number: " + id + ", Name: " + name + ", company: " + getCompanyName(companies);
		if (tableNum != -1) {
			theString += ", table: " + tableNum;
		}
		else {
			theString += ", table: NA";
		}
		return theString;
	}
}
