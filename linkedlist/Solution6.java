package linkedlist;

public class Solution6 {

	static class ListNode{
		private int value;
		private ListNode next;
		public ListNode(int value) {
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		Solution6 s = new Solution6();
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(3);
		ListNode a3 = new ListNode(5);
		a1.next = a2;
		a2.next = a3;
		ListNode b1 = new ListNode(2);
		ListNode b2 = new ListNode(4);
		ListNode b3 = new ListNode(6);
		b1.next = b2;
		b2.next = b3;
		
		ListNode head = s.mergeSort(a1, b1);
		while(head != null) {
			System.out.println(head.value);
			head = head.next;
		}
	}
	
	public ListNode mergeSort(ListNode head1, ListNode head2) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		ListNode cur1 = head1;
		ListNode cur2 = head2;
		while(cur1 != null && cur2 != null) {
			if(cur1.value <= cur2.value) {
				cur.next = cur1;
				cur1 = cur1.next;
				cur = cur.next;
			}else {
				cur.next = cur2;
				cur2 = cur2.next;
				cur = cur.next;
			}
		}
		if(cur1 != null) {
			cur.next = cur1;
		}
		if(cur2 != null) {
			cur.next = cur2;
		}
		return dummy.next;
	}
	
}
