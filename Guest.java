import java.util.ArrayList;

/** 
 * @author Jasper Burroughs 
 * 
 * This file declares a Guest class, which contains an id number, a name, a company, and a table number
 * This file contains methods to get the information and set the information for a Guest
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
	
	public int getCompany() {
		return company;
	}
	
	public int getTable() {
		return tableNum;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setTabNum(int num) {
		tableNum = num;
		
	}
	
	public String toString() {
		String theString = "";
		theString += "ID number: " + id + ", Name: " + name + ", company: " + company;
		if (tableNum != -1) {
			theString += ", table: " + tableNum;
		}
		else {
			theString += ", table: NA";
		}
		return theString;
	}
}
