package Partition_List;

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

}
public class Solution {
    public static ListNode partitionList(ListNode head , int x){
        if(head == null){
            return null;
        }

        ListNode greaterHead = new ListNode(0);
        ListNode lessHead = new ListNode(0);

        ListNode greater =  greaterHead;
        ListNode less =  lessHead;

        while(head != null){
            if(head.val < x){
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }
        greater.next = null;
        less.next = greaterHead.next;
        return lessHead.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3,
                        new ListNode(2, new ListNode(5, new ListNode(2))))));

        Solution sol = new Solution();
        int x = 3;

        ListNode result = sol.partitionList(head, x);

        printList(result);
    }
    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + " -> ");
            if(head.next == null){
                System.out.print("null");
            }
            head = head.next;
        }
        System.out.println();
    }
}
