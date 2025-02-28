package Reverse_Linked_List_2;

class ListNode{
    int val;
    ListNode next;
    ListNode(){};
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
public class Solution {
    public static ListNode reverseBetween(ListNode head , int left, int right){
        if(left == right || head == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for(int i=1; i<left; i++){
            prev = prev.next;
        }

        ListNode curr = prev.next;
        ListNode next = curr.next;

        for(int i=0; i<right - left; i++){
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int left = 2;
        int right = 4;

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        Solution sol = new Solution();

        ListNode result = sol.reverseBetween(head, left, right);

        printList(result);
    }
    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + " -> ");
            if (head.next == null) {
                System.out.print("null");
            }
            head = head.next;
        }
        System.out.println();
    }
}
