/*
    Given a sorted linked list, delete all duplicates such that each element appear only once.
    For example,
    Given 1->1->2, return 1->2.
    Given 1->1->2->3->3, return 1->2->3.
 */

package main.java;
import main.java.LinkedListUtils.Node;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3,4,4,5,5,5,6};
        Node head = LinkedListUtils.createLinkedList(arr);
        LinkedListUtils.printList(head);

        removeDuplicates(head);
        LinkedListUtils.printList(head);
    }

    private static void removeDuplicates (Node head) { // O(n) O(1) where n is the number of nodes in the list
        if(head == null || head.next == null)
            return;

        Node cur = head;
        Node nxt = cur.next;

        while(nxt.next != null) {
            if(cur.data == nxt.data)
                cur.next = nxt.next;
            else
                cur = nxt;
            nxt = nxt.next;
        }
    }

}
