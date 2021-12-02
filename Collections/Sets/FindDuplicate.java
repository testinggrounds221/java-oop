package Collections.Sets;

import java.util.HashSet;

/**
 * FindDuplicate
 */

public class FindDuplicate {
	static HashSet<String> findOrg(String[] wrds) {
		HashSet<String> dups = new HashSet<String>();
		HashSet<String> uniq = new HashSet<String>();

		for (String st : wrds) {
			if (!uniq.add(st))
				dups.add(st);
		}
		uniq.removeAll(dups);
		return uniq;
	}

	public static void main(String[] args) {
		String allWords[] = { "heyy", "heyy", "heyy2", "heyyheyy" };
		System.out.println(FindDuplicate.findOrg(allWords));
	}
}