import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Categorize {

	private static String alphabets[] = {"a","b","c","d","e","f","g","h","i","j","k","l",
			"m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	private static List<String> alphabet_combination = new ArrayList<String>();
	private static String filePath = "C:/Users/Vaishali/workspace/DictionaryFolders/src/base.txt";
	private static final String SPACE = " ";
	
	public static void main(String args[]) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
		String line = null;
		while((line = reader.readLine()) != null){
			String letters[] = line.split(SPACE);
			for(int i= 0; i < letters.length; i++){
				alphabet_combination.add(letters[i]);
			}
		}
		
		for(int i = 0; i < 26; i++){
			String str = alphabets[i];
			File folder = new File(str);
			folder.mkdir();
			String path = folder.getAbsolutePath();
			System.out.println(path);
			for(int j = 0; j < alphabet_combination.size(); j++){
				String fileName = "_"+str + alphabet_combination.get(j);
				File file = new File(path + "\\" + fileName + ".txt");
				file.createNewFile();
			}
		}
		reader.close();
	}
	
}
