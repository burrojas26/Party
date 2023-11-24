import java.util.ArrayList;
public class Company {
	
	ArrayList<Guest> employees = new ArrayList<Guest>();
	ArrayList<String> currComps = new ArrayList<String>();
	
	ArrayList<Integer> companies;
	int companyNum;
	String companyName;
	
	public Company(int initCompNum, ArrayList<Integer> initCompanies) {
		companyNum = initCompNum;
		companies = initCompanies;
	}
	
	public void createComp(ArrayList<Guest> allPeople) {
		for (Guest p : allPeople) {
			if (p.getCompany() == companyNum) {
				employees.add(p);
			}
		}
	}
	
	public Guest getRandPerson() {
		for (Guest e : employees) {
			if (e.getTable() == -1) {
				return e;
			}
		}
		return new Guest("", companyNum, 0);
	}
	
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
		
	
}
