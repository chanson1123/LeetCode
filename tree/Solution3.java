package tree;

public class Solution3 {

	static class TreeNode{
		private int value;
		private TreeNode leftNode;
		private TreeNode rightNode;
		public TreeNode(int value){
			this.value = value;
		}
	}
		public static void main(String[] args) {
			Solution3 s = new Solution3();
			TreeNode root = new TreeNode(1);
			root.leftNode = new TreeNode(2);
			root.rightNode = new TreeNode(2);
			System.out.println(s.isSymmetric(root));
		}
		
		public boolean isSymmetric(TreeNode root) {
			if(root == null) {
				return true;
			}
			return isSymmetric(root.leftNode, root.rightNode);
		}
		
		private boolean isSymmetric(TreeNode left, TreeNode right) {
			if(left == null && right == null) {
				return true;
			}else if(left == null || right == null) {
				return false;
			}else if(left.value != right.value) {
				return false;
			}
			return isSymmetric(left.leftNode, right.rightNode) && isSymmetric(left.rightNode, right.leftNode);
		}
		
	
}
