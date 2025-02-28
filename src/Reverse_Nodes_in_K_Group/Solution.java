package Reverse_Nodes_in_K_Group;

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val=val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
public class Solution {
    public static ListNode reverseGroup(ListNode head, int k){
        if(head == null || k == 1){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 0;
        ListNode prev = dummy, curr = dummy, next = dummy;

        while(curr.next != null){
            curr = curr.next;
            count++;
        }

        while(count >= k){
            curr = prev.next;
            next = curr.next;

            for(int i=1; i<k;i++){
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            count -= k;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int k = 2;

        Solution sol = new Solution();

        ListNode result = sol.reverseGroup(head, k);

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
