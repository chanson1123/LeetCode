package tree;

public class Solution2 {

	static class TreeNode{
		private int value;
		private TreeNode left;
		private TreeNode right;
		public TreeNode(int value) {
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		Solution2 s = new Solution2();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(s.isBalanced(root));
	}
	
	public boolean isBalanced(TreeNode root) {
		if(root == null) {
			return true;
		}
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		if(Math.abs(leftHeight - rightHeight) > 1) {
			return false;
		}
		return isBalanced(root.left) && isBalanced(root.right);
	}
	
	private int getHeight(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	
}
