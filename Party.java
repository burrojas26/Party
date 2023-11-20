import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Party {
	
	ArrayList<String> guests = new ArrayList<String>();
	ArrayList<Guest> finalGuests = new ArrayList<Guest>();
	ArrayList<String> currComps = new ArrayList<String>();
	ArrayList<Integer> companies = new ArrayList<Integer>();
	ArrayList<Company> allCompanies = new ArrayList<Company>();
	String currName;
	int currComp;
	int currId;
	String[] currGuest;
	
	public ArrayList<Guest> getAllPpl() {
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
		return finalGuests;
	}
	
		public ArrayList<Company> getComps() {
		try {
		  File myObj = new File("companies.txt");
		  Scanner myReader = new Scanner(myObj);
		  while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			currComps.add(data);
		  }
		  myReader.close();
		} 
		catch (FileNotFoundException e) {
		  System.out.println("An error occurred.");
		  e.printStackTrace();
		}
		
		for (int i = 1; i <= (currComps.size()/2) + 1; i++) {
			companies.add(i);
		}
		for (int i = 0; i < companies.size(); i++) {
			allCompanies.add(new Company(i+1, companies));
		}
		return allCompanies;
	}
}
