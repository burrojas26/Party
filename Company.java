import java.util.ArrayList;

/**
 * @author Jasper Burroughs
 * 
 * This file defines a company class, which contains a list of employees and a number representing the company
 * 
 * It contains a method to add people to the company
 * It contains multiple getters to get the information from the Company class
 */

public class Company {
	
	ArrayList<Guest> employees = new ArrayList<Guest>();
	ArrayList<String> currComps = new ArrayList<String>();
	
	int companyNum;
	String companyName;
	
	public Company(int initCompNum) {
		companyNum = initCompNum;
	}
	
	/*
	 * adds all of the people to the company
	 */
	public void createComp(ArrayList<Guest> allPeople) {
		for (Guest p : allPeople) {
			if (p.getCompany() == companyNum) {
				employees.add(p);
			}
		}
	}
	
	/* 
	 * converts the information to a string
	 */
	public String toString() {
		String theString = "";
		for (Guest g : employees) {
			theString += g.toString() + " ";
		}
		return theString;
	}
	
	public int getCount() {
		int count = 0;
		for (Guest g : employees) {
			count++;
		}
		return count;
	}
		
	public ArrayList<Guest> getPpl() {
		return employees;
	}
	
	public int getNum() {
		return companyNum;
	}
	
}
