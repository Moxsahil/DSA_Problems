package Merge_Two_Sorted_Lists;

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
    public static ListNode mergeList(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                current.next = list1;
                list1= list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if(list1 != null){
            current.next = list1;
        } else {
            current.next = list2;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        Solution sol = new Solution();
        ListNode result = sol.mergeList(list1, list2);

        printList(result);
    }

    public static void printList(ListNode head){
        System.out.print("Merged Linked list : ");
        while(head != null){
            System.out.print(head.val +  " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
