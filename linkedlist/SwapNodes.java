package linkedlist;

public class SwapNodes {

	public static void main(String[] args) {
		SwapNodes s = new SwapNodes();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ListNode result = s.swapPairs2(head);
		System.out.println(result.next.next.val);
	}
	
	public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur1 = head.next;
        ListNode cur2 = head.next.next;
        cur1.next = head;
        head.next = swapPairs(cur2);
        return cur1;
    } 
	
	public ListNode swapPairs2(ListNode head) {
		if(head == null || head.next == null){
            return head;
        }
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode pre = dummy; //null
		ListNode cur = head; //1
		while(cur != null && cur.next != null) {
			ListNode next = cur.next; //2
			cur.next = next.next; //下一步 1->3
			next.next = cur; //2->1
			pre.next = next; //2作为开头
			pre = cur; //pre = 1
			cur = cur.next;
		}
		return dummy.next;
	}
	
	static class ListNode{
		int val;
		private ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
		public ListNode() {}
	}
	
}
