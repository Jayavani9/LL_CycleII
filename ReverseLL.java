/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ReverseLL {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
       ListNode rev = reverseList(head.next);
       //System.out.println(rev.val);
       //System.out.println(head.val);
       head.next.next = head;
       head.next = null;
       return rev;
       /* 
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode n = head.next;
        while(n != null){
            curr.next = prev;
            prev = curr;
            curr = n;
            n = n.next;
        }
        curr.next = prev;
        return curr;
        */
    }
}