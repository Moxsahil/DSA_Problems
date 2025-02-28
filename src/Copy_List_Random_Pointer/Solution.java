package Copy_List_Random_Pointer;

class Node {
    int val;
    Node next;
    Node random;

    Node(int val){
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class Solution {
    public static Node copyRandom(Node n1){
        if(n1 == null){
            return n1;
        }

        //creating a copy of original list and appending it to right of original nodes
        Node current = n1;
        while(current != null){
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }

        current = n1;
        while(current != null){
            if(current.random != null){
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        current = n1;
        Node copiedHead = n1.next;
        Node copy = copiedHead;
        while(current != null){
            current.next = current.next.next;
            if(copy.next != null){
                copy.next = copy.next.next;
            }
            current=current.next;
            copy = copy.next;
        }
        return copiedHead;
    }
    public static void main(String[] args) {
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;

        n1.random = null;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        Solution sol = new Solution();
        Node copiedHead = sol.copyRandom(n1);
        printList(copiedHead);

    }
    public static void printList(Node head){
        while(head != null){
            System.out.print("Value: " + head.val);
            if(head.random != null){
                System.out.print(", random: " + head.random.val);
            } else{
                System.out.print(", random: null");
            }
            System.out.println();
            head=head.next;
        }
    }
}
