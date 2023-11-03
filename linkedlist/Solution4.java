package linkedlist;

import java.math.BigDecimal;
import java.util.Date;

// Insert a node in a sorted linkedlist
public class Solution4 {

	static class ListNode{
		private int value;
		private ListNode next;
		public ListNode(int value) {
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		Solution4 s = new Solution4();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		node1.next = node2;
		node2.next = node3;
		ListNode head = s.insert(node1, 4);
		while(head != null) {
			System.out.println(head.value);
			head = head.next;
		}
	}
	
	public ListNode insert(ListNode head, int val) {
		if(head == null || head.value >= val) {
			ListNode newHead = new ListNode(val);
			newHead.next = head;
			return newHead;
		}
		ListNode pre = head;
		ListNode cur = head.next;
		while(cur != null && cur.value < val) {
			pre = pre.next;
			cur = cur.next;
		}
		ListNode newNode = new ListNode(val);
		pre.next = newNode;
		newNode.next = cur;
		return head;
		
	}
}
