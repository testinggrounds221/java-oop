import java.util.*;
import java.io.*;

public class CopyFile {
	public static void main (String[] args) throws IOException{
		FileInputStream fileInp = new FileInputStream("data.txt");
		FileOutputStream fileOut = new FileOutputStream("output1.txt");
		int i;
		while((i=fileInp.read())!=-1){
			fileOut.write(i);
		}
		fileInp.close();
		fileOut.close();
	}
}
