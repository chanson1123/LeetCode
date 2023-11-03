package linkedlist;

public class Solution9 {

	static class ListNode{
		private int value;
		private ListNode next;
		public ListNode(int value) {
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		Solution9 s = new Solution9();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		ListNode head = s.partition(node1, 3);
		while(head != null) {
			System.out.println(head.value);
			head = head.next;
		}
	}
	
	public ListNode partition(ListNode head, int target) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode dummy1 = new ListNode(0);
		ListNode cur1 = dummy1;
		ListNode dummy2 = new ListNode(0);
		ListNode cur2 = dummy2;
		while(head != null) {
			if(head.value < target) {
				cur1.next = head;
				cur1 = cur1.next;
				head = head.next;
			}else {
				cur2.next = head;
				cur2 = cur2.next;
				head = head.next;
			}
		}
		cur1.next = dummy2.next;
		cur2.next = null;
		return dummy1.next;
	}
	
}
