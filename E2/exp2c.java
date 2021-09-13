import java.io.*;

// exp 2c 
public class exp2c {
	public static void main(String[] args) throws Exception {
		int ch = 0;
		int word = 0;
		int line = 0;

		File file = new File("D:\\Shreeram\\A_SEM3\\OOP\\E2\\exp2a.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String str = br.readLine();
		while (str != null) {
			line++;
			String wor[] = str.split(" ");
			word += wor.length;
			for (int j = 0; j < wor.length; j++)
				ch += wor[j].length();
			str = br.readLine();
		}
		System.out.println("Number of characters : " + ch);
		System.out.println("Number of words : " + word);
		System.out.println("Number of lines : " + line);

		br.close();
	}
}