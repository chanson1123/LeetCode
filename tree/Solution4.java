package tree;

public class Solution4 {

	static class TreeNode{
		private int value;
		private TreeNode left;
		private TreeNode right;
		public TreeNode(int value) {
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		Solution4 s = new Solution4();
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		System.out.println(s.isBST(root));
	}
	
	public boolean isBST(TreeNode root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean isBST(TreeNode root, Integer min, Integer max) {
		if(root == null) {
			return true;
		}
		if(root.value < min || root.value > max) {
			return false;
		}
		return isBST(root.left, min, root.value) && isBST(root.right, root.value, max);
	}
	
}
