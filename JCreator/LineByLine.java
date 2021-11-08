import java.util.*;
import java.io.*;

public class LineByLine{
	public static void main (String[] args) throws IOException {
		Scanner fileScanner = new Scanner(new FileInputStream("data.txt"));
		int count = 0;
		while(fileScanner.hasNext()){
			System.out.println(count++ + ") "+fileScanner.nextLine());
		}
  }
}