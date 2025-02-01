package Leetcode;

import Leetcode.LC002.ListNode;

public class LC024 {
	public ListNode swapPairs1(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode dummy = new ListNode();
		ListNode cur = dummy;
		ListNode cur1 = head;
		while(cur1!=null && cur1.next!=null) {
			ListNode cur2 = cur1.next;
			ListNode cur3 = cur2.next;
			cur2.next = cur1;
			cur1.next = cur3;
			cur.next = cur2;
			cur = cur1;
			cur1 = cur3;
		}
		return dummy.next;
	}
	
	public ListNode swapPairs2(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode cur2 = head.next;
		ListNode cur3 = cur2.next;
		cur2.next = head;
		head.next = swapPairs2(cur3);
		return cur2;
	}
}
