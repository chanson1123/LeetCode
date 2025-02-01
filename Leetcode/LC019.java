package Leetcode;

public class LC019 {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head==null) {
			return head;
		}
		if(head.next==null && n==1) {
			return null;
		}
		int nodeLength=0;
		ListNode cur1=head;
		while(cur1!=null) {
			nodeLength++;
			cur1=cur1.next;
		}
		if(n>nodeLength) {
			return head;
		}
		if(n==nodeLength) {
			return head.next;
		}
		ListNode cur2=head;
		int i = 1;
		while(i<nodeLength-n) {
			cur2=cur2.next;
			i++;
		}
		ListNode cur3 = cur2.next;
		if(cur3.next==null) {
			cur2.next=null;
		}else {
			cur2.next=cur3.next;
		}
		return head;
	}
	
}

class ListNode{
	int val;
	ListNode next;
	ListNode(){}
	ListNode(int val){
		this.val=val;
	}
	ListNode(int val,ListNode next){
		this.val=val;
		this.next=next;
	}
}
