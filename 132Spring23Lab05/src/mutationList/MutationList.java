package mutationList;

import java.util.ArrayList;
import java.util.Random;


/* MutationList inherits all of the ArrayList<Integer> features!
 * A MutationList Is-A ArrayList of Integers 
 */


public class MutationList extends ArrayList<Integer> {
		
	private static Random random = new Random();
	
	/* Let's add a method to the ArrayList API */

	public void mutate() {
		for (int i = 0; i < size(); i++) {
			if (random.nextBoolean()) {
				set(i, get(i) + 1);
			} else {
				set(i, get(i) - 1);
			}
		}
	}

	
	/* Here we are overriding some of the inherited methods that we don't want! */
	
	@Override
	public boolean remove(Object x) {
		throw new UnsupportedOperationException("DENIED!");
	}
	
	@Override
	public Integer remove(int index) {
		throw new UnsupportedOperationException("DENIED!");
	}
}
