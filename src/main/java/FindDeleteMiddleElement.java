/*
Given a singly linked list, find middle of the linked list. For example, if given linked list is 1->2->3->4->5 then output should be 3.
If there are even nodes, then there would be two middle nodes, we need to print second middle element.
For example, if given linked list is 1->2->3->4->5->6 then output should be 4.

Remove the middle element and print the modified list.
 */

package main.java;
import main.java.LinkedListUtils.Node;

public class FindDeleteMiddleElement {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node head = LinkedListUtils.createLinkedList(arr);
        System.out.println("Original list:");
        LinkedListUtils.printList(head);
        head = findDeleteMiddle(head);
        System.out.println("List after removing middle element:");
        LinkedListUtils.printList(head);
    }

    private static Node findDeleteMiddle(Node head) {
        if(head == null || head.next== null)
            return head;

        Node curr = new Node(-1);
        curr.next = head;
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            curr = curr.next;
            slow = slow.next;
            fast = fast.next.next;
        }

        curr.next = slow.next;
        return head;
    }
}
