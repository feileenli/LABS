package sortingExample;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class BrokenSortingAlgorithms {

	public static void doSort1(ArrayList<Integer> list) {
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			Integer value = it.next();
			if (value < 500) {
				it.remove();
			}
		}
	}
	
	public static void doSort2(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).compareTo(list.get(j)) > 0) {
					Integer temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
	}
	
	public static void doSort3(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			list.set(i, i);
		}
	}
	
	public static void doSort4(ArrayList<Integer> list) {
		Collections.sort(list);
	}
}
