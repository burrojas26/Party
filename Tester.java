import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Jasper Burroughs
 * @since 11/16/23
 * 
 * This is the file that contains the main method
 * 
 * It asks the user what they like to do as well as uses the methods from the other classes to create a table
 */

public class Tester {
	
	public static void main(String[] args) {
		Party theParty = new Party();
		ArrayList<Guest> allPpl = theParty.getAllPpl();
		ArrayList<Company> companies = theParty.getComps(allPpl);
		String descision = "";
		Scanner scan= new Scanner(System.in);

		//configuring the table with the sorted list of people
		ArrayList<Table> allTables = theParty.configAllTables(10, companies);
		
		/*
		 * Asking the user what they would like to do and directing them to that method
		 */
		while (!descision.equals("quit")) {
			System.out.print("Type tables to see the organized tables, companies to see all the people sorted by companies that wanted to attend, add to add a person, search to find a specific person's table, or quit to quit: ");
			descision = scan.nextLine();
			System.out.println("");
			//prints the tables
			if (descision.equals("tables")) {
				for (Table t : allTables) {
					System.out.print("Table " + t.getNum() + ": ");
					for (Guest g : t.getTable()) {
						System.out.print(g.getName() + ", ");
					}
					System.out.println("There are " + t.getSize() + " guests at this table");
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
				theParty.search(scan.nextLine(), allPpl, companies);
			}
			/*
			 * gets the people again and re-configures the tables
			 * uses the methods from the party class to do this
			 */
			else if (descision.equals("add")) {
				theParty = new Party();
				allPpl = theParty.getAllPpl();
				companies = theParty.getComps(allPpl);
				allTables = theParty.configAllTables(10, companies);
				
			}
			else if (!descision.equals("quit")) {
				System.out.println("Please try again");
			}
		}
		
		
		
		
		
	}
}

