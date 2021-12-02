package assgn3;

// Illustrate a java program by Identifying the suitable collection for storing the game details such as game name, number of players etc. Store the game details in the random order. Perform the following operations. 
// •Display the number of games that are inserted in the collection•Check whether the collection contains the game“Chess”•Retrieve the game name(s)by giving the player number

import java.util.*;

public class GameDB {

	public static void main(String args[]) {
		int n, num_players, num_games = 0, flag = 0;
		String game_name;
		Scanner obj1 = new Scanner(System.in);
		Scanner obj2 = new Scanner(System.in);
		Hashtable<Integer, String> ht = new Hashtable<Integer, String>();

		System.out.println("Enter the number of games to insert");
		n = obj1.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Enter the game:");
			game_name = obj2.nextLine();
			System.out.println("Enter the number of players for " + game_name);
			num_players = obj1.nextInt();
			ht.put(num_players, game_name);
		}

		for (Map.Entry m : ht.entrySet()) {
			num_games++;
		}
		System.out.println("The number of games inserted is:" + num_games);

		if (ht.containsValue("Chess")) {
			System.out.println("The game Chess is found in hashtable");
		} else {
			System.out.println("The game Chess is not found in hashtable");
		}
		int value;

		System.out.println("Enter the number of players:");
		value = obj1.nextInt();

		System.out.println("The game containing " + value + " number of players is " + ht.get(value));

	}
}
