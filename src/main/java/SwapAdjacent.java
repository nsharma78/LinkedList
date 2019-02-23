/*
    Given a linked list, swap every two adjacent nodes and return its head.
    For example, given 1->2->3->4, you should return the list as 2->1->4->3.
    Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */

package main.java;
import main.java.LinkedListUtils.Node;

public class SwapAdjacent {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        Node head = LinkedListUtils.createLinkedList(arr);
        LinkedListUtils.printList(head);
        head = swapAdjacent(head);
        LinkedListUtils.printList(head);
    }

    private static Node swapAdjacent(Node head) { // O(n) O(1)

        if(head == null || head.next == null)
            return head;

        //a fake head
        Node h = new Node(0);
        h.next = head;

        Node p1 = head;
        Node p2 = head.next;

        Node pre = h;
        while(p1 != null && p2 != null){
            pre.next = p2;

            Node t = p2.next;
            p2.next = p1;
            pre = p1;
            p1.next = t;

            p1 = p1.next;

            if(t != null)
                p2 = t.next;
        }

        return h.next;

    }
}
