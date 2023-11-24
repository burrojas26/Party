import java.util.ArrayList;
public class Tester {
	public static void main(String[] args) {
		Party theParty = new Party();
		ArrayList<Guest> allPpl = theParty.getAllPpl();
		ArrayList<Company> companies = theParty.getComps();
		ArrayList<Table> allTables = theParty.configTables(10);
		
		for (int i = 0; i < allTables.size(); i++) {
			System.out.println("Table " + (int)(i+1) + ": ");
			System.out.print(allTables.get(i).getId());
			System.out.println("Count: " + allTables.get(i).getCount());
			System.out.println("");
		}
	}
}
