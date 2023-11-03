package hashmap;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		int[] nums = new int[] {2,1,4,5};
		Integer res = s.findMissing(nums);
		System.out.println(res);
	}
	
	public Integer findMissing(int[] nums) {
		int n = nums.length;
		Set<Integer> set = new HashSet<>();
		for(Integer x : nums) {
			set.add(x);
		}
		for(int i = 1; i < n; i++) {
			if(!set.contains(i)) {
				return i;
			}
		}
		return n;
	}
	
}
