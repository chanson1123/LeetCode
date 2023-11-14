package hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FirstMissPositive {

	public static void main(String[] args) {
		FirstMissPositive s = new FirstMissPositive();
		int[] nums = {3,4,-1,1};
		System.out.print(s.firstMissingPositive(nums));
	}
	
	public int firstMissingPositive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums) {
        	map.put(x, map.getOrDefault(x, 0) + 1);
        }
        Arrays.sort(nums);
        for(int i = 1; i < Integer.MAX_VALUE; i++) {
        	if(!map.containsKey(i)) {
        		return i;
        	}
        }
        return -1;
    }
	
	public int firstMissingPositive1(int[] nums) {
        int n = nums.length;

        // Step 1: Move all positive integers to their correct positions
        // For example, the number 1 should be at index 0, 2 at index 1, and so on.
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // Step 2: Find the first missing positive integer
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // If all positive integers are present from 1 to n, return n + 1
        return n + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
	
}
