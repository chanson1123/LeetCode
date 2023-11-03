package linkedlist;

public class Solution3 {

	static class ListNode{
		private int value;
		private ListNode next;
		public ListNode(int value) {
			this.value = value;
		}
	}
	
	
	public boolean hasCycle(ListNode head) {
		if(head == null || head.next == null) {
			return false;
		}
		ListNode fast = head;
		ListNode slow = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) {
				return true;
			}
		}
		return false;
	}
	
}
