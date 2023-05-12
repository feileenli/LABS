import java.util.ArrayList;
import java.util.Iterator;

public class Driver1 {

	static String[] strings = {"a", "b", "cc", "dd", "e", "f", "gg", "hh"};
	
	public static void main(String[] args) {
		ArrayList<String> myList = new ArrayList<>();
		for (String s : strings) {
			myList.add(s);
		}
		StringFilter filter = new StringFilter(myList, 1);
		for (String s : filter) {
			System.out.print(s + " ");   // should print "a", "b", "e", "f"
		}
		System.out.println();
		filter.setLengthToKeep(2);
		for (String s : filter) {
			System.out.print(s + " ");   // should print "cc", "dd", "gg", "hh"
		}
		System.out.println();
		Iterator<String> it = filter.iterator();
		while(it.hasNext()) {
			String s = it.next();
			if (s.equals("gg")) {
				it.remove();
			}
		}
		for (String s : filter) {
			System.out.print(s + " ");   // should print "cc", "dd", "hh"
		}
	}

}
