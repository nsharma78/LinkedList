/*
    Given a linked list, remove the nth node from the end of list and return its head.
    For example, given linked list 1->2->3->4->5 and n = 2, the result is 1->2->3->5.
 */

package main.java;
import main.java.LinkedListUtils.Node;

public class RemoveNthLastNode {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int n = 5;
        Node head = LinkedListUtils.createLinkedList(arr);
        LinkedListUtils.printList(head);

        head = removeNthFromLast(head, n);
        LinkedListUtils.printList(head);
    }

    private static Node removeNthFromLast(Node head, int n) {
        if(head == null || head.next == null)
            return head;

        Node fast = head;
        Node slow = head;

        while(n > 0 && fast != null) {
            fast = fast.next;
            n--;
        }

        //if remove the first node
        if(fast == null && n == 0) {
            head = head.next;
            return head;
        }

        if(fast == null && n > 0)
            return head;

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
