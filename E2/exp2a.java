import java.io.*;

//exp 2a.
public class exp2a {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader(new File("D:\\Shreeram\\A_SEM3\\OOP\\E2\\exp2a.txt"));
		BufferedReader rd = new BufferedReader(fr);
		String line = rd.readLine();
		int count = 1;
		while (line != null) {
			System.out.println(count++ + ")" + line);
			line = rd.readLine();
		}
		rd.close();
	}
}