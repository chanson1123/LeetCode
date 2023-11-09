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
	
	public void solveSudoku(char[][] board) {
		solve(board);
	}
	
	public boolean solve(char[][] board) {
		for(int row = 0; row < 9; row++) {
			for(int col = 0; col < 9; col++) {
				if(board[row][col] == '.') {
					for(char num = '1'; num <= '9'; num++) {
						if(isValid(board, row, col, num)) {
							board[row][col] = num;
							if(solve(board)) {
								return true;
							}else {
								board[row][col] = '.';
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean isValid(char[][] board, int row, int col, char ch) {
		for(int i = 0; i < 9; i++) {
			if(board[row][i] == ch) return false;
			if(board[i][col] == ch) return false;
		}
		int r = row - row % 3;
		int c = col - col % 3;
		for(int i = r; i < r + 3; i++) {
			for(int j = c; j < c + 3; j++) {
				if(board[i][j] == ch) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean isValidSudoku(char[][] board) {
		for(int row = 0; row < 9; row++) {
			if(!isValidRow(board, row)) {
				return false;
			}
		}
		for(int col = 0; col < 9; col++) {
			if(!isValidCol(board, col)) {
				return false;
			}
		}
		for(int row = 0; row < 9; row += 3) {
			for(int col = 0; col < 9; col += 3) {
				if(!isValidSubGrid(board, row, col)) {
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean isValidSubGrid(char[][] board, int row, int col) {
		boolean[] seen = new boolean[9];
		for(int i = row; i < row + 3; i++) {
			for(int j = col; j < col + 3; j++) {
				if(seen[board[row][col] - '1']) {
					return false;
				}
				seen[board[row][col] - '1'] = true;
			}
		}
		return true;
	}
	
	private boolean isValidCol(char[][] board, int col) {
		boolean[] seen = new boolean[9];
		for(int row = 0; row < 9; row++) {
			if(seen[board[row][col] - '1']) {
				return false;
			}
			seen[board[row][col] - '1'] = true;
		}
		return true;
	}
	
	private boolean isValidRow(char[][] board, int row) {
		boolean[] seen = new boolean[9];
		for(int col = 0; col < 9; col++) {
			if(seen[board[row][col] - '1']) {
				return false;
			}
			seen[board[row][col] - '1'] = true;
		}
		return true;
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
