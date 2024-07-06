package Leetcode;

public class LC002 {
	
	public static void main(String[] args) {
		
	}
	
	static class ListNode{
		int value;
		ListNode next;
		ListNode(){}
		ListNode(int value){
			this.value = value;
		}
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode();
		ListNode head = dummy;
		int count = 0;
		while(l1 != null || l2 != null) {
			int num = count;
			if(l1 != null) {
				num += l1.value;
				l1 = l1.next;
			}
			if(l2 != null) {
				num += l2.value;
				l2 = l2.next;
			}
			head.next = new ListNode(num%10);
			count = num/10;
			head = head.next;
		}
		if(count != 0) {
			head.next = new ListNode(count);
		}
		return dummy.next;
	}
	
}
