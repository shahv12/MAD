import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AddWordsToCategories {
	private static final String wordFrequencyStatistics = "C:/Users/Vaishali/workspace/DictionaryFolders/wordlist/wordFrequency.txt";
	private static final String easy_path = "C:/Users/Vaishali/workspace/DictionaryFolders/wordlist/easy.txt/";
	private static final String medium_path = "C:/Users/Vaishali/workspace/DictionaryFolders/wordlist/medium.txt";
	private static final String hard_path = "C:/Users/Vaishali/workspace/DictionaryFolders/wordlist/hard.txt";
	
	public static void main(String args[]){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(new File(wordFrequencyStatistics)));
			String word;
			File file ;
			PrintWriter pw_easy = new PrintWriter(new FileWriter(easy_path));
    		PrintWriter pw_medium = new PrintWriter(new FileWriter(medium_path));
    		PrintWriter pw_hard = new PrintWriter(new FileWriter(hard_path));
			while((word = reader.readLine()) != null){
	    		String word_freq[] = word.split("\t");
	    		Integer word_cnt = Integer.parseInt(word_freq[1]);
	    		String name = word_freq[0];
	    		if(word_cnt <= 20 ){
	    			pw_hard.println(name);
	    		}
	    		else if(word_cnt > 20 && word_cnt <= 50 ){
	    			pw_medium.println(name);
	    		}
				else if(word_cnt > 50){
					pw_easy.println(name);
	    		}
	    	}
			pw_easy.flush();
			pw_easy.close();
			pw_medium.flush();
			pw_medium.close();
			pw_hard.flush();
			pw_hard.close();
	    	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException ioe){
			
		}
		
	}
}
