package Collections.Sets;

import java.util.*;

public class MapInterface {

}

class MapExample1 {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		// Adding elements to map
		map.put(1, "Amit");
		map.put(5, "Rahul");
		map.put(2, "Jai");
		map.put(6, "Amit");
		System.out.println(map.containsKey(2));
		System.out.println(map.containsValue("2"));
		Stack<Map.Entry<Integer, String>> stk = new Stack<Map.Entry<Integer, String>>();
		// TreeSet<Map.Entry<Integer, String>> tr = new TreeSet<Map.Entry<Integer,
		// String>>();
		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(stk::push);
		// for (Map.Entry<Integer, String> entry : map.entrySet()) {
		// System.out.println(entry.getKey() + " " + entry.getValue());
		// }
		Iterator<Map.Entry<Integer, String>> t = stk.iterator();
		while (t.hasNext()) {
			System.out.println(t.next().getKey());

		}
	}
}
