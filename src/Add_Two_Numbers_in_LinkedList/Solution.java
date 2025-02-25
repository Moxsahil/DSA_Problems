package Add_Two_Numbers_in_LinkedList;

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
    public static ListNode totalSum(ListNode l1, ListNode l2){
        ListNode newHead = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode current = newHead;
        int carry = 0;

        while( p != null || q != null){
            int x = 0;
            int y = 0;

            if(p != null){
                x = p.val;
                p = p.next;
            }

            if( q != null){
                y = q.val;
                q = q.next;
            }

            int sum = carry + x + y;
            carry = sum/10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        if(carry > 0){
            current.next = new ListNode(carry);
        }
        return newHead.next;
    }

    public static void printList(ListNode node){
        while(node != null){
            System.out.print(node.val);
            if(node.next != null){
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        Solution sol = new Solution();

        ListNode result = sol.totalSum(l1, l2);

        System.out.println("The total sum of LinkedList element is : ");

        printList(result);
    }
}
