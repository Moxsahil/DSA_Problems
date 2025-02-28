package Remove_Duplicate_From_Sorted_List_2;

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

public class Solution {
        public static ListNode removeDuplicate2(ListNode head){
            if(head == null) return null;

            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode prev = dummy;
            ListNode current = head;

            while(current.next != null){
                if(current.next != null && current.val == current.next.val){
                    while(current.next != null && current.val == current.next.val){
                        current = current.next;
                    }
                    prev.next = current.next;
                } else {
                    prev = prev.next;
                }
                current = current.next;
            }
            return dummy.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3,
                        new ListNode(3, new ListNode(4, new ListNode(4,
                        new ListNode(5)))))));

        Solution sol = new Solution();

        ListNode result = sol.removeDuplicate2(head);

        printList(result);
    }

    public static void printList(ListNode head){
            while(head != null){
                    System.out.print(head.val + " -> ");
                if(head.next == null){
                    System.out.println("null");
                }
                head = head.next;
            }
        System.out.println();
    }
}
