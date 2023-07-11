//Leetcode Problem 142. Linked List Cycle II
/*Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.
 */


 //Solution using Two Pointers slow and fast
 // Time complexity: O(n)  and space complexity: O(1)

class ListNode {
    int val;
    ListNode next;
     ListNode(int x) {
       val = x;
         next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        boolean flag = false;
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
            {
                flag = true;
                break;
            }
        }
        if(!flag) return null;
        slow = head;
        while(slow !=fast)
        {
        slow = slow.next;
        fast = fast.next;
        }


        return fast;
        
    }
}

//Solution using a HashSet

//Time Complexity : O(n) and space complexity : O(n)

/* 
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> cyc = new HashSet<>();
        ListNode curr = head;
        while(curr !=null)
        {
            if(cyc.contains(curr))
            {
                return curr;
            }
            else
            {
                cyc.add(curr);
                curr = curr.next;
            }
        }
        return null;
        
    }
}
*/