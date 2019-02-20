/*
 * Reverse a singly linked list. Iterative and recursive.
 */

package main.java;
import main.java.LinkedListUtils.Node;

public class ReverseLinkedList {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        Node head = LinkedListUtils.createLinkedList(arr);
        LinkedListUtils.printList(head);

        head = reverseIterative(head);
        LinkedListUtils.printList(head);

        head = reverseRecursive(head);
        LinkedListUtils.printList(head);
    }

    public static Node reverseRecursive(Node head) { // O(n) O(n)
        if (head == null || head.next == null)
            return head;

        Node first = head;
        Node second = head.next;

        head.next = null;

        Node curr = reverseRecursive(second);
        second.next = head;

        return curr;
    }

    public static Node reverseIterative(Node head) { // O(n) O(1)
        if (head == null || head.next == null)
            return head;

        Node pre = head;
        Node cur = pre.next;
        head.next = null;

        while(cur != null && pre != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
