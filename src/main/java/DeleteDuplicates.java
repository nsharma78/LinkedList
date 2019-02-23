/*
    Given a sorted linked list, delete all duplicates such that each element appear only once.
    For example,
    Given 1->1->2, return 2.
    Given 1->1->2->3 return in 2->3
 */

package main.java;
import main.java.LinkedListUtils.Node;

public class DeleteDuplicates {

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3,4,4,5,5,5,6};
        Node head = LinkedListUtils.createLinkedList(arr);
        LinkedListUtils.printList(head);

        head = deleteDuplicates(head);
        LinkedListUtils.printList(head);
    }

    private static Node deleteDuplicates (Node head) { // O(n) O(1) where n is the number of nodes in the list
        if(head == null || head.next == null)
            return head;

        Node dummy = new Node(0);
        dummy.next = head;
        Node cur = dummy;

        while(cur.next != null && cur.next.next != null) {
            if(cur.next.data == cur.next.next.data) {
                int dup = cur.next.data;
                while(cur.next != null && cur.next.data == dup)
                    cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

}
