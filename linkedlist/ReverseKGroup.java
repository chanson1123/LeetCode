package linkedlist;

import linkedlist.SwapNodes.ListNode;

public class ReverseKGroup {

	public static void main(String[] args) {
		ReverseKGroup s = new ReverseKGroup();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ListNode result = s.reverseKGroup(head, 3);
		System.out.println(result.val);
	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head == null || head.next == null) {
			return head;
		}
		int length = 0;
		ListNode tmp = head;
		while(tmp != null) {
			tmp = tmp.next;
			length++;
		}
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode pre = dummy;
		ListNode cur = null;
		ListNode next = null;
		while(length >= k) {
			cur = pre.next;
			next = cur.next;
			for(int i = 1; i < k; i++) {
				cur.next = next.next;
				next.next = pre.next;
				pre.next = next;
				next = cur.next;
			}
			pre = cur;
			length -= k;
		}
		return dummy.next;
	}
	
	public ListNode reverseKGroup2(ListNode head, int k) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode tmp = head;
		for(int i = 0; i < k; i++) {
			if(tmp == null) {
				return head;
			}
			tmp = tmp.next;
		}
		ListNode newHead = reverseKGroup(tmp, k);
		ListNode pre = null;
		ListNode cur = head;
		for(int i = 0; i < k; i++) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		head.next = newHead;
		return pre;
	}
	
	
	static class ListNode{
		int val;
		ListNode next;
		public ListNode() {}
		public ListNode(int val) {
			this.val = val;
		}
	}
}
