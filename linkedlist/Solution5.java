package linkedlist;

public class Solution5 {

	static class ListNode{
		private int value;
		private ListNode next;
		public ListNode(int value) {
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		Solution5 s = new Solution5();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(3);
		node1.next = node2;
		node2.next = node3;
		ListNode head = s.remove(node1, 3);
		while(head != null) {
			System.out.println(head.value);
			head = head.next;
		}
	}
	
	public ListNode remove(ListNode head, int val) {
		while(head != null && head.value == val) {
			head = head.next;
		}
		if(head == null) {
			return head;
		}
		ListNode pre = head;
		ListNode cur = head.next;
		while(cur != null) {
			if(cur.value == val) {
				cur = cur.next;
				pre.next = cur;
			}else {
				pre = pre.next;
				cur = cur.next;
			}
		}
		return head;
	}
	
}
