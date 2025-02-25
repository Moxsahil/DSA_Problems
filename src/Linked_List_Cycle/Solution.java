package Linked_List_Cycle;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        this.val=x;
        this.next=null;
    }

}
public class Solution {
    public boolean hasCycle(ListNode head){
        if(head == null || head.next == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != fast){
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-2);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;

        Solution sol = new Solution();
        boolean ans = sol.hasCycle(head);

        if(ans){
            System.out.println("Yes, Given LinkedList has cycle");
        } else{
            System.out.println("No, Given LinkedList has not cycle");
        }
    }
}
