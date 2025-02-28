package Rotate_List;

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val= val;
        this.next = next;
    }
}
public class Solution {
    public static ListNode rotateList(ListNode head , int k){
        ListNode current = head;
        int length = 1;

        while(current.next != null){
            current = current.next;
            length++;
        }

        current.next = head;
        k = k % length;
        int tempHead = length - k;
        ListNode newTail = current;

        while(tempHead -- > 0){
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3,
                        new ListNode(4, new ListNode(5)))));

        int k = 2;

        Solution sol = new Solution();

        ListNode result = sol.rotateList(head, k);

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
