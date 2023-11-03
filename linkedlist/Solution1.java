package linkedlist;


// Reverse a linkedlist
public class Solution1 {

	static class ListNode{
		
		private int value;
		private ListNode next;
		
		public ListNode(int value) {
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		Solution1 s = new Solution1();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(3);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		ListNode newHead = s.reverse2(node1);
		while(newHead != null) {
			System.out.println(newHead.value);
			newHead = newHead.next;
		}
	}
	
	public ListNode reverse1(ListNode head) {
		if(head == null) {
			return head;
		}
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
	
	public ListNode reverse2(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode newHead = reverse2(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
	
}
