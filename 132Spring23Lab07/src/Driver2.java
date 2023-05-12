import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver2 {
	
	private final static int LENGTH = 6;
	
	public static void main(String[] args) throws IOException {
		ArrayList<String> doc = new ArrayList<>();
		Path path = Paths.get("RomeoAndJuliet.txt");
		Scanner scanner = new Scanner(path);  // Scanners are Iterable!
		
		while(scanner.hasNext()) {
			String word = scanner.next();
			
			/* The following statement removes all characters that are not letters, 
			 * and converts all the letters to lower-case. */
			word = word.replaceAll("[^a-zA-Z ]", "").toLowerCase();
			
			doc.add(word);
		}
		
		StringFilter filter = new StringFilter(doc, LENGTH);
		
		for(String s : filter) {
			System.out.println(s);
		}
		
		scanner.close();
	}

}
