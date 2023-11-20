import java.util.ArrayList;
public class Table {

	Guest[] table = new Guest[10];
		
	public void configTable(int tableNum, int startIndex, ArrayList<Company> companies) {
		for (int i = 0; i < table.length; i++) {
			table[i] = companies[startIndex].getRandPerson();
		}
	}
}
