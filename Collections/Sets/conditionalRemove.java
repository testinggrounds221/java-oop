package Collections.Sets;

import java.util.*;

public class conditionalRemove {
	public static void main(String args[]) {
		HashSet<String> set = new HashSet<String>();
		set.add("Ravi");
		set.add("Vijay");
		set.add("Arun");
		set.add("Sumit");
		set.add("Sumitqwpqoeeeefw4");
		set.add("Sumitqwpqoeeeefw1");
		set.add("Sumitqwpqoeeeefw2");
		set.add("Sumitqwpqoeeeefw3");

		System.out.println("An initial list of elements: " + set);
		Iterator<String> setIterator = set.iterator();
		while (setIterator.hasNext()) {
			System.out.println(setIterator.next());
		}
		set.removeIf(str -> str.length() > 6);
		System.out.println("Updated List: " + set);

		// Removing specific element from HashSet
		set.remove("Ravi");
		System.out.println("After invoking remove(object) method: " + set);
		HashSet<String> set1 = new HashSet<String>();
		set1.add("Ajay");
		set1.add("Gaurav");

		set.addAll(set1);
		System.out.println("Updated List: " + set);
		// Removing all the new elements from HashSet
		set.removeAll(set1);
		System.out.println("After invoking removeAll() method: " + set);
		// Removing elements on the basis of specified condition
		set.removeIf(str -> str.contains("Vijay"));
		System.out.println("After invoking removeIf() method: " + set);
		// Removing all the elements available in the set
		set.clear();
		System.out.println("After invoking clear() method: " + set);
	}
}