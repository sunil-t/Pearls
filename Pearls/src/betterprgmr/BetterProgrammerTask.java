package betterprgmr;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BetterProgrammerTask {

	public static int countWords(String s) {
		/*
		 * Please implement this method to return the word count in a given
		 * String. Assume that the parameter String can only contain spaces and
		 * alphanumeric characters.
		 */
		if (s.trim().equals(""))
			return 0;

		String[] words = s.split(" ");
		int count = 0;
		for (String word : words) {
			if (!word.trim().equals(""))
				count++;
		}
		return count;
	}

	public static Set<Object> getUniqueElements(Set<Object> a, Set<Object> b) {
		/*
		 * Please implement this method to return a set of elements that can be
		 * found only in set a or set b, but not in both Sets. The method should
		 * not change the content of the parameters.
		 */
		Set<Object> bCopy = b;
		Set<Object> elements = new HashSet<Object>();
		Iterator<Object> aitr = a.iterator();
		while (aitr.hasNext()) {
			Object temp = aitr.next();
			if (!b.contains(temp))
				elements.add(temp);
			else
				bCopy.remove(temp);
		}
		elements.addAll(bCopy);
		return elements;
	}

	// Please do not change this interface
	public static interface Node {
		int getValue();

		List<Node> getChildren();
	}

	public static List<Node> traverseTreeInDepth(Node root) {
		/*
		 * Please implement this method to traverse the tree in depth and return
		 * a list of all passed nodes.
		 * 
		 * The method shall work optimally with large trees.
		 */
		List<Node> depthFirst = new LinkedList<BetterProgrammerTask.Node>();

		while (root.getChildren() != null) {
			List<Node> sibling = root.getChildren();
			for (Node node : sibling) {
				depthFirst.addAll(traverseTreeInDepth(node));
			}
		}
		depthFirst.add(root);
		return depthFirst;
	}
	
}
