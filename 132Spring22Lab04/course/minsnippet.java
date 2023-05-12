package course;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class minsnippet {
	
		private ArrayList<String> doc;
		private ArrayList<String> one; 
		private ArrayList<String> edited; 
		private List<String> termsCopy; 
		
		private String stringDocs = "";

		private boolean checker; 
		private String result; 


		public MinimumSnippet(Iterable<String> document, List<String> terms) {
			
			termsCopy = terms; 
			one = new ArrayList<String>();
			doc = new ArrayList<String>(); //document stuff 		
			Iterator<String> it = document.iterator();
			
			while (it.hasNext()) {
				String str = it.next();
				//System.out.println(str);
				doc.add(str);
			}		
			
			
			for(int i = 0; i < doc.size(); i++) {
				String res = ""; 
				for(int j = i; j < doc.size(); j++) {
					res += doc.get(j); 
					one.add(res); 
				}
			}
			
			//System.out.println(one);
			
			edited = new ArrayList<String>(); 
			
			for(String x: one) { 
				checker = true; 
				for(String term: terms) {
					if(!x.contains(term)) {
						checker = false; 
						break;
					}
				}
				if(checker) {
					edited.add(x); 
				}
			}
			
			
			//System.out.println(edited);
			
			//find smallest sequence within edited array 
			result = ""; 
			for(String s: edited) {
				if(result.length() == 0 || s.length() < result.length()) {
					result = s; 
				}
			}
		
			for(String s: document) {
				this.stringDocs += s;
			}		
		}

		public boolean foundAllTerms() {
			if (edited.size() > 0) {
				return true; 
			}
			return false;
		}
		
		
		public String result() {
			return result; 
		}
		

		public int getStartingPos() {
			//System.out.println(stringDocs);
			//System.out.println(result);
			return stringDocs.indexOf(result); 
		}

		public int getEndingPos() {
			return stringDocs.indexOf(result) + result.length() - 1; 
		}

		public int getLength() {
			return result.length();
		}

		public int getPos(int index) {
			String term = termsCopy.get(index);
			int indx = result.indexOf(term); 
			int pos = stringDocs.indexOf(result) + indx; 
			return pos;
		}

	}

private int termsSize; 
private int docSize; 
private ArrayList<String> doc; 
private ArrayList<String> current; 
private ArrayList<String> shortest; 
private int count;

doc = new ArrayList<String>(); //document stuff 		
Iterator<String> it = document.iterator();

while (it.hasNext()) {
	String str = it.next();
	//System.out.println(str);
	doc.add(str);
}		

termsSize = terms.size(); 
docSize = doc.size(); 

if (terms.size() < doc.size()) {
	throw  new IllegalArgumentException("Document must be greater than terms");
}

current = new ArrayList<String>(); 
shortest = new ArrayList<String>(); 

count = 0; 
for(int i = 0; i < termsSize; i++ ) {
	for(int j = 0; j <docSize; j++) {
		if (terms.get(i).equals(doc.get(j))) {
			count++; 
		}
	}
	
}



