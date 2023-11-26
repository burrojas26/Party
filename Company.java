import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author Jasper Burroughs
 * @since 11/20/23
 * 
 * This file defines a company class, which contains a list of employees and a number representing the company
 * 
 * It contains a method to add people to the company and get the company name
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
	 * goes through the companies file and assigns the company a name based on their number
	 */
	public void createComp(ArrayList<Guest> allPeople) {
		ArrayList<String> companyData = new ArrayList<String>();
		for (Guest p : allPeople) {
			if (p.getCompany() == companyNum) {
				employees.add(p);
			}
		}
		//finds the company name
		//code modified from w3 schools
		try {
		  File myObj = new File("companies.txt");
		  Scanner myReader = new Scanner(myObj);
		  while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			companyData.add(data);
		  }
		  myReader.close();
		} 
		catch (FileNotFoundException e) {
		  System.out.println("An error occurred.");
		  e.printStackTrace();
		}
		
		for (String line : companyData) {
			if (!line.equals("")) {
				if (Integer.parseInt(line.split(",")[0]) == companyNum) {
					companyName = line.split(",")[1];
				}
			}
		}
	}
	
	/* 
	 * converts the information to a string
	 * returns the string
	 */
	public String toString() {
		String theString = companyName + ": ";
		for (Guest g : employees) {
			theString += g.getName() + ", ";
		}
		return theString;
	}
	/*
	 * returns the number of people belonging to the company
	 */
	public int getCount() {
		int count = 0;
		for (Guest g : employees) {
			count++;
		}
		return count;
	}
	/*
	 * returns a list of the Guests that belong to the company
	 */	
	public ArrayList<Guest> getPpl() {
		return employees;
	}
	/*
	 * returns the number that represents the company
	 */
	public int getNum() {
		return companyNum;
	}
	/*
	 * returns the name of the company
	 */
	public String getName() {
		return companyName;
	}
	
}
