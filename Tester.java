import java.util.ArrayList;
public class Tester {
	public static void main(String[] args) {
		Party theParty = new Party();
		for (Guest g : theParty.getAllPpl()) {
			System.out.println(g.toString());
		}
		ArrayList<Integer> companies = theParty.getComps();
		for (Integer i : companies) {
			System.out.println(i);
		}
	}
}
