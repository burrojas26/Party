import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Jasper Burroughs
 * 
 * This is the file that contains the main method
 * 
 * It asks the user what they like to do as well as uses the methods from the other classes to create a table
 */

public class Tester {
	
	public static void main(String[] args) {
		Party theParty = new Party();
		ArrayList<Guest> sortedPpl = new ArrayList<Guest>();
		ArrayList<Company> sortedCompanies = new ArrayList<Company>();
		ArrayList<Guest> allPpl = theParty.getAllPpl();
		ArrayList<Company> companies = theParty.getComps(allPpl);
		sortedCompanies.add(companies.get(0));
		String descision = "";
		Scanner scan= new Scanner(System.in);
		
		/*
		 * Creating the sorted lists to use for configuring the table
		 * Must sort the list so that the companies with more people get sorted into the tables first - optimizes the number of people that can fit
		 */
		for (int i = 1; i < companies.size(); i++) {
			for (int j = 0; j < sortedCompanies.size(); j++) {
				if (companies.get(i).getCount() > sortedCompanies.get(j).getCount()) {
					sortedCompanies.add(j, companies.get(i));
					break;
				}
			}
			
		}
		
		for (Company comp : sortedCompanies) {
			for (Guest p : comp.getPpl()) {
				sortedPpl.add(p);
			}
		}
		
		//configuring the table with the sorted list of people
		ArrayList<Table> allTables = theParty.configAllTables(sortedPpl, 10);
		
		/*
		 * Asking the user what they would like to do
		 */
		while (!descision.equals("quit")) {
			System.out.print("Type tables to see the organized tables, companies to see all the people sorted by companies that wanted to attend, add to add a person, search to find a specific person's table, or quit to quit: ");
			descision = scan.nextLine();
			//prints the tables
			if (descision.equals("tables")) {
				for (Table t : allTables) {
					System.out.print("Table: ");
					for (Guest g : t.getTable()) {
						System.out.print(g.getName() + ", ");
					}
					System.out.println(t.getSize());
					System.out.println("");
				}
			}
			/*
			 * prints the people from the different companies
			 */
			else if (descision.equals("companies")) {
				for (Company company : companies) {
					System.out.println(company.toString());
				}
			}
			/*
			 * prints a certain person's information based on user input
			 */
			else if (descision.equals("search")) {
				System.out.print("Who do you want to search for (Enter their name): ");
				theParty.search(scan.nextLine(), allPpl);
			}
			/*
			 * gets the people again and re-configures the tables
			 * uses the methods from the party class to do this
			 */
			else if (descision.equals("add")) {
				theParty = new Party();
				sortedPpl = new ArrayList<Guest>();
				sortedCompanies = new ArrayList<Company>();
				allPpl = theParty.getAllPpl();
				companies = theParty.getComps(allPpl);
				sortedCompanies.add(companies.get(0));
				for (int i = 1; i < companies.size(); i++) {
					for (int j = 0; j < sortedCompanies.size(); j++) {
						if (companies.get(i).getCount() > sortedCompanies.get(j).getCount()) {
							sortedCompanies.add(j, companies.get(i));
							break;
						}
					}
					
				}
				
				for (Company comp : sortedCompanies) {
					for (Guest p : comp.getPpl()) {
						sortedPpl.add(p);
					}
				}
				
				allTables = theParty.configAllTables(sortedPpl, 10);
			}
			else if (!descision.equals("quit")) {
				System.out.println("Please try again");
			}
		}
		
		
		
		
		
	}
}

