package linkedlist;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

// Find the middle node of the linkedlist
public class Solution2 {

	static class ListNode{
		private int value;
		private ListNode next;
		public ListNode(int value) {
			this.value = value;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution2 s = new Solution2();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		ListNode mid = s.findMid(node1);
		System.out.println(mid.value);
		
		String test = "cc";
		Files.write(Paths.get("test.txt"), test.getBytes(), StandardOpenOption.APPEND);
	}
	
	
	public ListNode findMid(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
}
