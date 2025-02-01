package Leetcode;

import Leetcode.LC002.ListNode;

public class LC021 {

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode dummy = new ListNode();
		ListNode cur = dummy;
		while(list1!=null && list2!=null) {
			if(list1.value <= list2.value) {
				cur.next=list1;
				cur=cur.next;
				list1=list1.next;
			}else {
				cur.next=list2;
				cur=cur.next;
				list2=list2.next;
			}
		}
		if(list1!=null) {
			cur.next=list1;
		}
		if(list2!=null) {
			cur.next=list2;
		}
		return dummy.next;
	}
}
