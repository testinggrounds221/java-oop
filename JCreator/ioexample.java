import java.io.*;
class ioexample {
	public static void main(String[] args)		{
		try {
			FileInputStream fis = new FileInputStream(new File("input.txt"));
			FileOutputStream fos = new FileOutputStream(new File("output.txt"));

			int i;
			while ((i = fis.read()) != -1){
				char currChar = (char)i;
				if(Character.isLetter(currChar)){
					System.out.println("FileStreamsTest: ");
				}
				fos.write(i);
			}
			fis.close();
			fos.close();
		}

		catch (FileNotFoundException fnfe){
		System.err.println("FileStreamsTest: " +fnfe);
		}

		catch (IOException ioe){
		System.err.println("FileStreamsTest: " + ioe);
		}

	 }
}
