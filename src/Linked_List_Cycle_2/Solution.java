package Linked_List_Cycle_2;

/*
    --> Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
    There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
    following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer
    is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.


    Approach -> Detect if a cycle exists using two pointers (slow and fast).
                If a cycle exists, move one pointer to the head. Move both one step at a time;
                the point where they meet is the start of the cycle.

    Time Complexity: O(n)
    Space Complexity : O(1)
*/
class ListNode {
    ListNode next;
    int val;
    ListNode(int x){
        val = x;
        next = null;
    }
}
public class Solution {
    public ListNode detectCycle(ListNode head){
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        Solution sol = new Solution();
        ListNode cycleStart = sol.detectCycle(node1);

        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.val);
        } else {
            System.out.println("No cycle detected.");
        }
    }
}
