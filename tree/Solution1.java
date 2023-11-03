package tree;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
	
	static class TreeNode{
		private int value;
		private TreeNode left;
		private TreeNode right;
		public TreeNode(int value) {
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		Solution1 s = new Solution1();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		List<Integer> result = s.postOrder(root);
		result.stream().forEach(System.out :: println);
	}
	
	public List<Integer> preOrder(TreeNode root){
		List<Integer> res = new ArrayList<>();
		preOrder(root, res);
		return res;
	}
	
	private void preOrder(TreeNode root, List<Integer> res) {
		if(root == null) {
			return;
		}
		res.add(root.value);
		preOrder(root.left, res);
		preOrder(root.right, res);
	}
	
	public List<Integer> inOrder(TreeNode root){
		List<Integer> res = new ArrayList<>();
		inOrder(root, res);
		return res;
	}
	
	private void inOrder(TreeNode root, List<Integer> res) {
		if(root == null) {
			return;
		}
		inOrder(root.left, res);
		res.add(root.value);
		inOrder(root.right, res);
	}
	
	public List<Integer> postOrder(TreeNode root){
		List<Integer> res = new ArrayList<>();
		postOrder(root, res);
		return res;
	}
	
	private void postOrder(TreeNode root, List<Integer> res) {
		if(root == null) {
			return;
		}
		postOrder(root.left, res);
		postOrder(root.right, res);
		res.add(root.value);
	}
}
