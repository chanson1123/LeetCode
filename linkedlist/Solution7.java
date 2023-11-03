package linkedlist;

public class Solution7 {

	static class ListNode{
		private int value;
		private ListNode next;
		public ListNode(int value) {
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		Solution7 s = new Solution7();
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(0);
		ListNode a3 = new ListNode(1);
		a1.next = a2;
		a2.next = a3;
		ListNode b1 = new ListNode(9);
		ListNode b2 = new ListNode(0);
		ListNode b3 = new ListNode(9);
		b1.next = b2;
		b2.next = b3;
		ListNode result = s.addTwo(a1, b1);
		while(result != null) {
			System.out.println(result.value);
			result = result.next;
		}
	}
	
	//147 => 7->4->1
	public ListNode addTwo(ListNode h1, ListNode h2) {
		ListNode result = new ListNode(0);
		ListNode head = result;
		int count = 0;
		while(h1 != null || h2 != null) {
			int sum = count;
			if(h1 != null) {
				sum += h1.value;
				h1 = h1.next;
			}
			if(h2 != null) {
				sum += h2.value;
				h2 = h2.next;
			}
			head.next = new ListNode(sum % 10);
			count = sum / 10;
			head = head.next;
		}
		if(count != 0) {
			head.next = new ListNode(count);
		}
		return result.next;
	}
	
}
