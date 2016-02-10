import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class addWordsToFile {

	private static String filePath = "C:/Users/Vaishali/workspace/DictionaryFolders/wordlist/wordlist.txt";
	private static String srcPath = "C:/Users/Vaishali/workspace/DictionaryFolders/src/";
	
	public static void main(String args[]) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
		String word = null;
		while((word = reader.readLine()) != null){
			String folder = word.substring(0, 1);
			String fileName = "_" + word.substring(0,3);
			String path = srcPath + folder + "/" + fileName + ".txt";
			PrintWriter printWriter = new PrintWriter(new FileWriter(path, true));
			printWriter.println(word);
			printWriter.close();
		}
		reader.close();
	}
} 
