package hashmap;

import java.util.HashMap;
import java.util.Map;

public class RomanAndInteger {

	public static void main(String[] args) {
		RomanAndInteger s = new RomanAndInteger();
		String input = "LVIII";
		System.out.println(s.romanToInt(input));
		int num = 58;
		System.out.println(s.intToRoman(num));
	}
	
	public String intToRoman(int num) {
		StringBuilder result = new StringBuilder();
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        int[] array = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for(int x : array) {
        	while(num >= x) {
        		result.append(map.get(x));
        		num -= x;
        	}
        }
        return result.toString();
	}
	
	// LVIII, IV
	public int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        char[] array = s.toCharArray();
        int result = map.get(array[array.length - 1]);
        for(int i = array.length - 2; i >= 0; i--) {
        	if(map.get(array[i]) < map.get(array[i+1])) {
        		result -= map.get(array[i]);
        	}else {
        		result += map.get(array[i]);
        	}
        }
        return result;
	}
	
}
