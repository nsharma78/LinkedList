/*
    Given a singly linked list L: L0→L1→ ... →Ln-1→Ln,
    reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→...
    For example, given {1,2,3,4,5,6}, reorder it to {1,6,2,5,3,4}. You must do this in-place without altering the nodes' values.
 */

package main.java;
import main.java.LinkedListUtils.Node;

public class ReorderList {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        Node head = LinkedListUtils.createLinkedList(arr);
        LinkedListUtils.printList(head);

        head = reorderList(head);
        LinkedListUtils.printList(head);
    }

    private static Node reorderList(Node head) {
        if(head == null || head.next == null)
            return head;

        Node slow = head;
        Node fast = head;

        //use a fast and slow pointer to break the link to two parts.
        while (fast != null && fast.next != null && fast.next.next!= null) {
            //why need third/second condition?
            System.out.println("pre " + slow.data + " " + fast.data);
            slow = slow.next;
            fast = fast.next.next;
            System.out.println("after " + slow.data + " " + fast.data);
        }

        Node second = slow.next;
        slow.next = null;

        second = ReverseLinkedList.reverseIterative(second);

        Node n1 = head;
        Node n2 = second;

        //merge two lists
        while(n2 != null) {
            Node temp1 = n1.next;
            Node temp2 = n2.next;

            n1.next = n2;
            n2.next = temp1;

            n1 = temp1;
            n2 = temp2;

        }
        return head;
    }
}
