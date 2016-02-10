import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CategorizeGame {
	private static final String wordFrequencyStatistics = "C:/Users/Vaishali/workspace/DictionaryFolders/wordlist/wordFrequency.txt";
	private static Map<Integer, Integer> no_of_words = new HashMap<Integer,Integer>();
	
	public static void main(String args[]){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(new File(wordFrequencyStatistics)));
			String word ; 
			no_of_words.put(10, 0);
			no_of_words.put(20, 0);
			no_of_words.put(30, 0);
			no_of_words.put(40, 0);
			no_of_words.put(50, 0);
			no_of_words.put(60, 0);
			no_of_words.put(70, 0);
			no_of_words.put(80, 0);
			no_of_words.put(90, 0);
			no_of_words.put(100, 0);
			no_of_words.put(110, 0);
			no_of_words.put(120, 0);				
			no_of_words.put(130, 0);
			no_of_words.put(140, 0);
			no_of_words.put(150, 0);
			no_of_words.put(160, 0);
			no_of_words.put(170, 0);
			
	    	while((word = reader.readLine()) != null){
	    		String word_freq[] = word.split("\t");
	    		Integer word_cnt = Integer.parseInt(word_freq[1]);
	    		if(word_cnt <= 20){
	    			no_of_words.put(10, no_of_words.get(10) + 1);
	    		}
	    		else if(word_cnt > 20 && word_cnt <= 50){
	    			no_of_words.put(20, no_of_words.get(20) + 1);
	    		}
				else if(word_cnt > 50){
					no_of_words.put(30, no_of_words.get(30) + 1);
				}
	    	}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException ioe){
			
		}
		Iterator<Integer> itr = no_of_words.keySet().iterator();
		while(itr.hasNext()){
			Integer base_line = itr.next();
			Integer num_words = no_of_words.get(base_line);
			System.out.println(base_line + "\t" + num_words);
		}
		
	}
}
