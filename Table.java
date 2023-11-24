import java.util.ArrayList;
public class Table {

	Guest[] table = new Guest[10];
		
	public int configTable(int tableNum, int startIndex, ArrayList<Company> companies) {
		Guest currPerson;
		for (int i = 0; i < table.length; i++) {
			currPerson = companies.get(startIndex).getRandPerson();
				table[i] = currPerson;
				currPerson.setTabNum(tableNum);
			if (startIndex+1 >= companies.size()) {
				startIndex = 0;
			}
			else {
				startIndex++;
			}
		}
		return startIndex;
	}
	
	
	public String toString() {
		String theString = "";
		for (int i = 0; i < table.length; i++) {
			theString += table[i].toString() + " ";
		}
		return theString;
	}
	
	public String namesToString() {
		String theString = "";
		for (int i = 0; i < table.length; i++) {
			theString += table[i].getName() + ", ";
		}
		return theString;
	}
	
	public String getCompanies() {
		String theString = "";
		int comp;
		for (int i = 0; i < table.length; i++) {
			comp = table[i].getCompany();
			theString += (comp) + ", ";
		}
		return theString;
	}
	
	public int getCount() {
		int count = 0;
		for (int i = 0; i < table.length; i++) {
			count++;
		}
		return count;
	}
	
	public String getId() {
		String theString = "";
		int id;
		for (int i = 0; i < table.length; i++) {
			id = table[i].getId();
			theString += (id) + ", ";
		}
		return theString;
	}
}
