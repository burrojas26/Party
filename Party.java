import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author Jasper Burroughs
 * @since 11/16/23
 * 
 * This file contains methods to set up the party
 * 
 * It contains a getAllPpl method, which gets all the people from the document and asks the user if they would like to input any people
 * It contains a getComps method, which gets the number of companies from the other documant and returns a list of that number of company classes each with the number that represents them
 * It contains a configAllTables method, which configures the tables by running all of the people in the list that is passed in until it finds a table that they can fit at, if they do not fit at a table they do not get a seat
 * It contains a search method that finds the details of a guest and prints them based on a passed in guest name
 */

public class Party {
	
	ArrayList<String> guests = new ArrayList<String>();
	ArrayList<Guest> finalGuests = new ArrayList<Guest>();
	String rawCompanies = "";
	int numCompanies = 0;
	ArrayList<Company> allCompanies = new ArrayList<Company>();
	String currName;
	int currComp;
	int currId;
	String[] currGuest;
	Scanner scan = new Scanner(System.in);
	
	/*
	 * Gets all of the people from the document 
	 * creates Guests out of the information from the document and returns a list of these Guests
	 */
	public ArrayList<Guest> getAllPpl() {
		//code learned from w3 schools to get information from a file
		try {
		  File myObj = new File("partyguests.txt");
		  Scanner myReader = new Scanner(myObj);
		  while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			guests.add(data);
		  }
		  myReader.close();
		} 
		catch (FileNotFoundException e) {
		  System.out.println("An error occurred.");
		  e.printStackTrace();
		}
		
		for (String i : guests) {
			currGuest = i.split(",");
			currName = currGuest[2] + " " + currGuest[1];
			currComp = Integer.parseInt(currGuest[3]);
			currId = Integer.parseInt(currGuest[0]);
			finalGuests.add(new Guest(currName, currComp, currId));
		}
		String proceed = "false";
		while (!proceed.equals("continue")) {
			System.out.println("Enter a guest's details to add them to the seating chart or type continue (format: name: company): ");
			proceed = scan.nextLine();
			if (!proceed.equals("continue")) {
				// Learned try-catch from w3 schools instructions on reading files
				try {
					currGuest = proceed.split(": ");
					currName = currGuest[0];
					currComp = Integer.parseInt(currGuest[1]);
					currId = finalGuests.size()+1;
					finalGuests.add(new Guest(currName, currComp, currId));
				}
				catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("An error occurred. Please try again");
				}
			}
		}
		return finalGuests;
	}
	
	/*
	 * creates an ArrayList of companies with the specific id from the document of companies
	 */
	public ArrayList<Company> getComps(ArrayList<Guest> allPpl) {
		Company currCompany;
		//Learned how to get information from files from w3 schools
		try {
		  File myObj = new File("companies.txt");
		  Scanner myReader = new Scanner(myObj);
		  while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			rawCompanies += data;
		  }
		  myReader.close();
		} 
		catch (FileNotFoundException e) {
		  System.out.println("An error occurred.");
		  e.printStackTrace();
		}
		numCompanies = rawCompanies.split(",").length-1;
		for (int i = 0; i < numCompanies; i++) {
			currCompany = new Company(i+1);
			currCompany.createComp(allPpl);
			allCompanies.add(currCompany);
		}
		return allCompanies;
	}

	/* 
	 * Creating the sorted lists to use for configuring the table
	 * Must sort the list so that the companies with more people get sorted into the tables first - optimizes the number of people that can fit
	 * configures the tables by going through the list of people passed in until it finds a table they can sit at
	 * if they cannot sit at any table the algorithm moves on to the next person
	 */
	public ArrayList<Table> configAllTables(int numTables, ArrayList<Company> companies) {
		ArrayList<Guest> sortedPpl = new ArrayList<Guest>();
		ArrayList<Company> sortedCompanies = new ArrayList<Company>();
		sortedCompanies.add(companies.get(0));
		ArrayList<Table> allTables = new ArrayList<Table>();
		//this variable is useed to add the Company to the sorted list at the end if it is not bigger than any of the other companies
		boolean smallest = true;
		
		for (int i = 0; i < companies.size(); i++) {
			smallest = true;
			for (int j = 0; j < sortedCompanies.size(); j++) {
				if (companies.get(i).getCount() > sortedCompanies.get(j).getCount()) {
					sortedCompanies.add(j, companies.get(i));
					smallest = false;
					break;
				}
			}
			if (smallest) {
				sortedCompanies.add(companies.get(i));
			}
			
		}
		
		for (Company comp : sortedCompanies) {
			for (Guest p : comp.getPpl()) {
				sortedPpl.add(p);
			}
		}
		
		for (int i = 0; i < numTables; i++) {
			allTables.add(new Table(i+1));
		}
		for (Guest person : sortedPpl) {
			for (Table table : allTables) {
				if (table.search(person.getCompany()) == false && table.getSize() < 10 && person.getTable() == -1) {
					table.addPerson(person);
					person.setTabNum(table.getNum());
				}
			}
		}
		return allTables;
	}

	/*
	 * finds a specific person and prints their information
	 */
	public void search(String name, ArrayList<Guest> allPpl, ArrayList<Company> allCompanies) {
		for (Guest g : allPpl) {
			if (g.getName().equals(name)) {
				System.out.println(g.toString(allCompanies));
			}
		}
	}

	
}
