/*
    Given a singly linked list, rotate the linked list counter-clockwise by k nodes. Where k is a given positive integer.
    For example, if the given linked list is 10->20->30->40->50->60 and k is 4,
    the list should be modified to 50->60->10->20->30->40. Assume that k is smaller than the count of nodes in linked list.
 */

package main.java;
import main.java.LinkedListUtils.Node;

public class RotateLinkedList {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node head = LinkedListUtils.createLinkedList(arr);
        System.out.println("Original list:");
        LinkedListUtils.printList(head);
        head = rotateList(head, 4);
        System.out.println("List after rotation:");
        LinkedListUtils.printList(head);
    }

    private static Node rotateList(Node head, int k) {
        if(head == null || head.next== null)
            return head;

        Node curr = head;
        for(int i = 1; i < k; i++)
            curr = curr.next;
        Node temp = curr;
        while(temp.next != null)
            temp = temp.next;
        temp.next = head;
        Node newHead = curr.next;
        curr.next = null;
        return newHead;

    }
}
