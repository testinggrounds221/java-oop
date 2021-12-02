package Lab;

import java.util.ArrayList;
// import java.util.Iterator;
import java.util.Map;
import java.util.Hashtable;

public class StudentDuplicate {
	public static void main(String[] args) {
		ArrayList<String> ar = new ArrayList<String>();
		ar.add("ssss");
		ar.add("sss");
		ar.add("ssssssss");

		// Iterator<String> i = ar.iterator();

		// while (i.hasNext()) {
		// String temp = i.next();
		// if (temp.equals("ssss"))
		// i.remove();
		// }
		// Iterator<String> j = ar.iterator();

		// while (j.hasNext()) {
		// System.out.println(j.next());

		// }

		Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
		ht.put("Sjhree", 1);
		ht.put("Sree", 2);
		ht.put("Sreeaaaaas", 2);
		// int arr[] = { 1, 2, 3 };
		for (Map.Entry<String, Integer> enrry : ht.entrySet()) {
			System.out.println(enrry.getKey());
		}
		// System.out.println(ht.entrySet());
		// if (ht.containsKey("Sreeaaaaas")) {
		// int a = ht.get("Sreeaaaaas");
		// System.out.println(ht.get("Sreeaaaaas"));
		// }
		// System.out.println(ht);

	}
}
