import java.util.*;
import java.io.*;

public class ScannerFileIO {
	public static void main (String[] args){
		try {
			Scanner sc = new Scanner(new FileInputStream("data.txt"));
			String line = " ";
			while(sc.hasNext()){
  			line = sc.nextLine();
  			String[] parts = line.split("\t");
				System.out.println(parts[0]);
  			// printArray(parts);
			}
		}
		catch (Exception ex) {
  		System.out.println(ex.getMessage());
		}

  }

  static void printArray(String[] parts){
  	for(String part:parts){
  		System.out.println(part);
  	}

  }
}