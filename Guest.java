import java.util.ArrayList;
public class Guest {
	String name;
	int company;
	int id;
	int tableNum = -1;
	ArrayList<Guest> allPeople;
	
	public Guest(String initName, int initCompany, int initId) {
		name = initName;
		company = initCompany;
		id = initId;
	}
	
	public int getCompany() {
		return company;
	}
	
	public int getTable() {
		return tableNum;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setTabNum(int num) {
		tableNum = num;
	}
	
	public String toString() {
		return "ID number: " + id + ", Name: " + name + ", company: " + company + ", Table Number: " + tableNum;
	}
}
