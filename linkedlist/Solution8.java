package linkedlist;

public class Solution8 {

	static class ListNode{
		private int value;
		private ListNode next;
		public ListNode(int value) {
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		Solution8 s = new Solution8();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(2);
//		ListNode node6 = new ListNode(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
//		node5.next = node6;
		
		System.out.println(s.isPalindrome(node1));
	}
	
	public boolean isPalindrome(ListNode head) {
		if(head == null || head.next == null) {
			return true;
		}
		ListNode head2 = reverse2(findMid(head));
		while(head2 != null) {
			if(head.value != head2.value) {
				return false;
			}
			head = head.next;
			head2 = head2.next;
		}
		return true;
	}
	
	private ListNode findMid(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	private ListNode reverse1(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;
		ListNode next = null;
		while(cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
	
	private ListNode reverse2(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode newHead = reverse2(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
	
}
