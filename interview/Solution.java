package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = new int[] {2,4,5,7};
		List<List<Integer>> result = s.twoSum2(nums, 9);
		result.stream().forEach(s1 -> {s1.stream().forEach(System.out::print); System.out.println();});
	}
	
	
	static class ListNode{
		int value;
		private ListNode next;
		public ListNode() {};  //框架用反射，子类或许会调用父类的super()
		public ListNode(int value) {
			this.value = value;
		}
		public ListNode(int value, ListNode next) {
			this.value = value;
			this.next = next;
		}
	}
	//sorted: have to check duplication, we cannot use the same element twice
	public List<List<Integer>> twoSum2(int[] nums, int target){
		List<List<Integer>> result = new ArrayList<>();
		int i = 0;
		int j = nums.length - 1;
		while(i < j) {
			if(nums[i] + nums[j] == target) {
				List<Integer> list = Arrays.asList(i, j);
				result.add(list);
				i++;
				j--;
			}else if(nums[i] + nums[j] < target) {
				i++;
			}else {
				j--;
			}
		}
		return result;
	}
	
	//unsorted: every element is unique
	public List<List<Integer>> twoSum1(int[] nums, int target){
		List<List<Integer>> result = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(target - nums[i])) {
				List<Integer> list = Arrays.asList(map.get(target - nums[i]), i);
				result.add(list);
			}else {
				map.put(nums[i], i);
			}
		}
		return result;
	}
}
