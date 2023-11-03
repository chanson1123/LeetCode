package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindSubstring {
	
	public static void main(String[] args) {
		FindSubstring f = new FindSubstring();
		String s = "foofoobar";
		String[] words = {"foo", "bar"};
		List<Integer> result = f.findSubstring(s, words);
		result.stream().forEach(System.out::println);
	}
	
	// s = foofoobar  words = foo bar
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(words).forEach(word -> map.put(word, map.getOrDefault(word, 0) + 1));
        int wordLength = words[0].length(); //3
        int subLength = words.length * wordLength; //6
        //第一个for-loop把string按照subLength拆分
        for(int i = 0; i <= s.length() - subLength; i++) {
        	String substr = s.substring(i, i + subLength); //foofoo
        	Map<String, Integer> localMap = buildMap(substr, wordLength);
        	if(map.equals(localMap)) {
        		result.add(i);
        	}
        }
        return result;
    }
	//第二个for-loop把拆分过的subtring进一步按照wordLength拆分，装进map
	private Map<String, Integer> buildMap(String s, int wordLength){
		Map<String, Integer> map = new HashMap<>();
		// s = foofoo 
		for(int i = 0; i <= s.length() - wordLength; i+=wordLength) {
			String substr = s.substring(i, i + wordLength); //foo
			map.put(substr, map.getOrDefault(substr, 0) + 1);
		}
		return map;
	}

    
}
