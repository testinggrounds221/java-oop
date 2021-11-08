//Write a Java program that displays the number of characters, lines and words in a text?
import java.io.*;
import java.util.*;

public class CountChar{
	public static void main (String[] args) throws IOException{
		Scanner sc = new Scanner(new FileInputStream("data.txt"));
		int nLine = 0, nChar = 0, nWords = 0;
		while(sc.hasNext()) {
			String line = sc.nextLine();
			nChar+=line.length();
			nLine++;
			for(int i=0;i<line.length();i++){
				if(line[i]==","||line[i]=="."||line[i]=="!"||line[i]==" "||)
					nWords++;
			}
		}
		System.out.println(nChar);
		System.out.println(nLine);
		System.out.println(nWords);
  }

}