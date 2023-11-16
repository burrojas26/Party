import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Party {
	
	ArrayList<Guest> people = new ArrayList<Guest>();
	
	ArrayList<Guest>[] tables = new ArrayList<Guest>[10]
	

	public void loadPeople() {
		//loads the people
	}
	
	public void addPerson(Guest person) {
		people.add(person);
	}
	
	public void createTable() {
		for (ArrayList<Guest> table : tables) {
			table = new ArrayList<Guest>();
		}
		for (int i = 0; i < table.length; i++) {
			for (Guest p : people) {
				if (!contains(p, tables[i]) && tables[i].size() < 10) {
					tables[i].add(p);
				}
				
			}
		}
	}
	
	public boolean contains(Guest person, ArrayList<Guest> table) {
		for (Guest p : table) {
			if (p.getCompany() == person.getCompany()) {
				return true;
			}
		}
		return false;
	}
	
}
