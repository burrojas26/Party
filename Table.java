import java.util.ArrayList;

/**
 * @author Jasper Burroughs
 * @since 11/20/23
 * 
 * This class represents a table, and contains a list of Guests
 * It contains a search method, which searches for a company within the table
 * It contains an addPerson method, which adds a Guest to the list based on the passed in Guest
 * It contains multiple getter methods to get the various parts of the table such as, the people at the table, the number of people at the table, and the table number
 */

public class Table {

	ArrayList<Guest> table = new ArrayList<Guest>();
	int tableNum;	
	
	public Table(int num) {
		tableNum = num;
	}
	
	/*
	 * Searches for a specific company within a table
	 */
	public boolean search(int company) {
		for (Guest person : table) {
			if (person.getCompany() == company) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Adds a Guest class to the table's list of Guests
	 */
	public void addPerson(Guest thePerson) {
		table.add(thePerson);
	}
	
	/*
	 * returns a list of Guests that makes up the Table
	 */
	public ArrayList<Guest> getTable() {
		return table;
	}
	
	/*
	 * returns the number of people at the table
	 */
	public int getSize() {
		return table.size();
	}
	/*
	 * returns the table number
	 */
	public int getNum() {
		return tableNum;
	}
	
	/*
	 * Returns one string with all the names of the people at the table
	 */
	public String toString() {
		String theString = "";
		for (Guest g : table) {
			theString += ", " + g.getName();
		}
		return theString;
	}
}
