import java.io.*;
import java.util.*;

public class PhoneDB {
	Hashtable<String, String> nameToNumber;

	PhoneDB() {
		nameToNumber = new Hashtable<String, String>();
	}

	void initialiseDB() {
		try {
			Scanner sc = new Scanner(new FileInputStream("D:\\Shreeram\\A_SEM3\\OOP\\E9\\data.txt")).useDelimiter("\t");
			String[] splitArray;
			while (sc.hasNext()) {
				splitArray = sc.nextLine().split("\t");
				nameToNumber.put(splitArray[0], splitArray[1]);
			}
			sc.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	String queryNumber(String queryString) {
		return nameToNumber.containsKey(queryString) ? nameToNumber.get(queryString) : "-1";
	}

	String queryName(String queryString) {
		for (Map.Entry<String, String> pair : nameToNumber.entrySet()) {
			if (pair.getValue().equals(queryString))
				return pair.getKey();
		}
		return "-1";
	}

	public static void main(String args[]) {

		PhoneDB pDB = new PhoneDB();
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		pDB.initialiseDB();
		do {
			System.out.println();
			System.out.println("1.	To query Name from Phone");
			System.out.println("2.	To query Phone from Name");
			System.out.println("Any other Number to Quit");
			System.out.println("Enter Choice : ");
			choice = sc.nextInt();

			if (choice == 1) {
				System.out.println("Enter Phone : ");
				sc.nextLine();
				String result = pDB.queryName(sc.nextLine());
				if (result == "-1") {
					System.out.println("Phone does not exist in DB");
				} else {
					System.out.println("Name matching Phone : " + result);
				}
			} else if (choice == 2) {
				System.out.println("Enter Name : ");
				sc.nextLine();
				String result = pDB.queryNumber(sc.nextLine());
				if (result == "-1") {
					System.out.println("Name does not exist in DB");
				} else {
					System.out.println("Phone matching Name : " + result);
				}
			} else {
				break;
			}

		} while (true);
		System.out.println("Query Process Complete");
		sc.close();
	}
}