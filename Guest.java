public class Guest {
	String name;
	int company;
	int id;
	
	public Guest(String initName, int initCompany, int initId) {
		name = initName;
		company = initCompany;
		id = initId;
	}
	
	public int getCompany() {
		return company;
	}
}
