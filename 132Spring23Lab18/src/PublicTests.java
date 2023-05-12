import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PublicTests {

	StringTree tree;

	@Test
	void testAdd() {
		tree = new StringTree("A");
		tree.addChild("A", "B");
		tree.addChild("A", "C");
		tree.addChild("A", "D");
		tree.addChild("B", "E");
		tree.addChild("B", "F");
		tree.addChild("D", "G");
		tree.addChild("G", "H");
		tree.addChild("H", "I");
		tree.addChild("C", "J");
		assertTrue(tree.root.data.equals("A"));
		testPath("AB");
		testPath("AC");
		testPath("AD");
		testPath("ABE");
		testPath("ABF");
		testPath("ACJ");
		testPath("ADG");
		testPath("ADGH");
		testPath("ADGHI");
	}

	@Test
	public void testCount() {
		tree = new StringTree("A");
		tree.addChild("A", "B");
		tree.addChild("A", "C");
		tree.addChild("A", "D");
		tree.addChild("B", "E");
		tree.addChild("B", "F");
		tree.addChild("D", "G");
		tree.addChild("G", "H");
		tree.addChild("H", "I");
		tree.addChild("C", "J");
		assertTrue(tree.countElements() == 10);
	}
	
	@Test
	public void testFindLongestString() {
		tree = new StringTree("AX");
		tree.addChild("AX", "B");
		tree.addChild("AX", "CY");
		tree.addChild("AX", "D");
		tree.addChild("B", "EZ");
		tree.addChild("B", "FZH");
		tree.addChild("D", "GQ");
		tree.addChild("GQ", "HLMNO");
		tree.addChild("HLM", "IZZZ");
		tree.addChild("CY", "JRPX");
		tree.addChild("CY", "O");
		tree.addChild("O", "ABCDEFG");
		tree.addChild("ABCDEFG", "LMNOPQ");
		assertTrue(tree.findLongestString().equals("ABCDEFG"));
	}
	
	private void testPath(String path) {
		assertTrue(tree.root.data.equals(String.valueOf(path.charAt(0))));
		System.out.println("\nverified " + tree.root.data);
		testPathHelper(path, tree.root, 0);
	}

	private void testPathHelper(String path, StringTree.Node localRoot, int pos) {
		if (pos >= path.length() - 1) {
			return;
		}
		for (StringTree.Node n : localRoot.children) {
			if (n.data.equals(String.valueOf(path.charAt(pos + 1))) ) {
				System.out.println("verified " + n.data);
				testPathHelper(path, n, pos + 1);
				return;
			}
		}
		fail();
	}

}
