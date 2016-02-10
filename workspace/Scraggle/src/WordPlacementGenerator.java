import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordPlacementGenerator {
	private static List<Tile> tile_1 = new ArrayList<Tile>(3);//[] = {2,4,5}
    private static List<Tile> tile_2 = new ArrayList<Tile>(5);//[] = {1,3,4,5,6};
    private static List<Tile> tile_3 = new ArrayList<Tile>(3);//[] = {2,5,6};
    private static List<Tile> tile_4 = new ArrayList<Tile>(5);//[] = {1,2,5,7,8};
    private static List<Tile> tile_5 = new ArrayList<Tile>(8);//[] = {1,2,3,4,6,7,8,9};
    private static List<Tile> tile_6 = new ArrayList<Tile>(5);//[] = {2,3,5,8,9};
    private static List<Tile> tile_7 = new ArrayList<Tile>(3);//[] = {4,5,8};
    private static List<Tile> tile_8 = new ArrayList<Tile>(5);//[] = {4,5,6,7,9};
    private static List<Tile> tile_9 = new ArrayList<Tile>(3);//[] = {5,6,8};
    private static List<List<Tile>> tile_list = new ArrayList<List<Tile>>();
    private static List<Integer> numbers_traversed = new ArrayList<Integer>();
    private static List<Integer> small_tile_nums = new ArrayList<Integer>();
    private static Integer counter = 0;
    private static String[] word_chars = {"z","i","r","c","a","l","o","y","s"};
    private static List<Tile> tiles = new ArrayList<Tile>();
    
    public static void main(String[] args) {
    	for(int i=0; i < 9; i++){
			tiles.add(new Tile(i,false));
			small_tile_nums.add(new Integer(i));
		}
		tile_1.add(tiles.get(1));
		tile_1.add(tiles.get(3));
		tile_1.add(tiles.get(4));
    	
		tile_2.add(tiles.get(0));
		tile_2.add(tiles.get(2));
		tile_2.add(tiles.get(3));
		tile_2.add(tiles.get(4));
		tile_2.add(tiles.get(5));
    	
		tile_3.add(tiles.get(1));
		tile_3.add(tiles.get(4));
		tile_3.add(tiles.get(5));
    	
		tile_4.add(tiles.get(0));
		tile_4.add(tiles.get(1));
		tile_4.add(tiles.get(4));
		tile_4.add(tiles.get(6));
		tile_4.add(tiles.get(7));
    	
		tile_5.add(tiles.get(0));
		tile_5.add(tiles.get(1));
		tile_5.add(tiles.get(2));
		tile_5.add(tiles.get(3));
		tile_5.add(tiles.get(5));
		tile_5.add(tiles.get(6));
		tile_5.add(tiles.get(7));
		tile_5.add(tiles.get(8));
    	
		tile_6.add(tiles.get(1));
		tile_6.add(tiles.get(2));
		tile_6.add(tiles.get(4));
		tile_6.add(tiles.get(7));
		tile_6.add(tiles.get(8));
    	
		tile_7.add(tiles.get(3));
		tile_7.add(tiles.get(4));
		tile_7.add(tiles.get(7));
    	
		tile_8.add(tiles.get(3));
		tile_8.add(tiles.get(4));
		tile_8.add(tiles.get(5));
		tile_8.add(tiles.get(6));
		tile_8.add(tiles.get(8));
	
		tile_9.add(tiles.get(4));
		tile_9.add(tiles.get(5));
		tile_9.add(tiles.get(7));
	
		Collections.shuffle(small_tile_nums);
    	Collections.shuffle(tile_1);
    	Collections.shuffle(tile_2);
    	Collections.shuffle(tile_3);
    	Collections.shuffle(tile_4);
    	Collections.shuffle(tile_5);
    	Collections.shuffle(tile_6);
    	Collections.shuffle(tile_7);
    	Collections.shuffle(tile_8);
    	Collections.shuffle(tile_9);
    	tile_list.add(tile_1);
    	tile_list.add(tile_2);
    	tile_list.add(tile_3);
    	tile_list.add(tile_4);
    	tile_list.add(tile_5);
    	tile_list.add(tile_6);
    	tile_list.add(tile_7);
    	tile_list.add(tile_8);
    	tile_list.add(tile_9);
    	
    	WordPlacementGenerator generator = new WordPlacementGenerator();
    	generator.doPlacement();
    	
	}
    
    private void doPlacement()
    {
    	Integer starting_tile_num = 8;
    	for(int i = 0; i < 9; i++){
    		numbers_traversed.add(starting_tile_num);
    		Tile t = tiles.get(starting_tile_num);	
    		t.setCharacter(word_chars[i]);
    		System.out.println(word_chars[i]);
	    	t.setIsTileEmpty(false);
	    	for(int j = 0; j < 9; j++){
	    		if(tile_1.contains(t)){
	    			tile_1.remove(t);
	    		}
	    		if(tile_2.contains(t)){
	    			tile_2.remove(t);
	    		}
	    		if(tile_3.contains(t)){
	    			tile_3.remove(t);
	    		}
	    		if(tile_4.contains(t)){
	    			tile_4.remove(t);
	    		}
	    		if(tile_5.contains(t)){
	    			tile_5.remove(t);
	    		}
	    		if(tile_6.contains(t)){
	    			tile_6.remove(t);
	    		}
	    		if(tile_7.contains(t)){
	    			tile_7.remove(t);
	    		}
	    		if(tile_8.contains(t)){
	    			tile_8.remove(t);
	    		}
	    		if(tile_9.contains(t)){
	    			tile_9.remove(t);
	    		}
	    	}
	    	List<Tile> tempList = tile_list.get(starting_tile_num);
	    	int max_index = 0;
	    	int max_size = 0;
	    	for(int j= 0; j < tempList.size(); j++){
	    		Tile tile = tempList.get(j);
	    		List<Tile> ttlist = tile_list.get(tile.getPosition());
	    		if(ttlist.size() > max_size){
	    			max_index = j;
	    			max_size = ttlist.size();
	    		}
	    	}
	    	starting_tile_num= max_index;
	    	if(tile_list.get(starting_tile_num).isEmpty()){
	    		while(tile_list.get(starting_tile_num).isEmpty() && counter >0){
	    			small_tile_nums.remove(starting_tile_num);
	    			starting_tile_num = numbers_traversed.get(--counter);
	    		}
	    		if(counter == 0 ){
	    			/*starting_tile_num = small_tile_nums.get(0);
	    			t = tiles.get(starting_tile_num);	
	    	    	t.setCharacter(word_chars[i]);
	    	    	t.setIsTileEmpty(false);*/
	    			break;
	    		}	
	    	}
	    	
	    	starting_tile_num = tile_list.get(max_index).get(0).getPosition();
		    counter ++;
	    }
    	for(int i= 0;i < 9; i++){
    		Tile t = tiles.get(i);
    		System.out.println(t.getPosition() + " " + t.getCharacter());
    	}
    }
    
    private void shuffleNumbers(){
//    	Collections.shuffle(Arrays.asList(small_tile_nums));
//    	Collections.shuffle(Arrays.asList(tile_1));
//        Collections.shuffle(Arrays.asList(tile_2));
//        Collections.shuffle(Arrays.asList(tile_3));
//        Collections.shuffle(Arrays.asList(tile_4));
//        Collections.shuffle(Arrays.asList(tile_5));
//        Collections.shuffle(Arrays.asList(tile_6));
//        Collections.shuffle(Arrays.asList(tile_7));
//        Collections.shuffle(Arrays.asList(tile_8));
//        Collections.shuffle(Arrays.asList(tile_9));
//        System.out.println("\nTile 1 stats....");
//        for(int i=0;i < tile_1.length; i++){
//            System.out.print(tile_1[i] + " ");
//        }
//
//        System.out.println("\nTile 2 stats....");
//        for(int i=0;i < tile_2.length; i++){
//            System.out.print(tile_2[i] + " ");
//        }
//
//        System.out.println("\nTile 3 stats....");
//        for(int i=0;i < tile_3.length; i++){
//            System.out.print(tile_3[i] + " ");
//        }
//
//        System.out.println("\nTile 4 stats....");
//        for(int i=0;i < tile_4.length; i++){
//            System.out.print(tile_4[i] + " ");
//        }
//
//        System.out.println("\nTile 5 stats....");
//        for(int i=0;i < tile_5.length; i++){
//            System.out.print(tile_5[i] + " ");
//        }
//
//        System.out.println("\nTile 6 stats....");
//        for(int i=0;i < tile_6.length; i++){
//            System.out.print(tile_6[i] + " ");
//        }
//
//        System.out.println("\nTile 7 stats....");
//        for(int i=0;i < tile_7.length; i++){
//            System.out.print(tile_7[i] + " ");
//        }
//
//        System.out.println("\nTile 8 stats....");
//
//        for(int i=0;i < tile_8.length; i++){
//            System.out.print(tile_8[i] + " ");
//        }
//        System.out.println("\nTile 9 stats....");
//        for(int i=0;i < tile_9.length; i++){
//            System.out.print(tile_9[i] + " ");
//        }

    }

    public WordPlacementGenerator(){
        
    }
}
