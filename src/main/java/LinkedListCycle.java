/*
 * Given a linked list, determine if it has a cycle in it.
 *
 * 1->2->3->4->5->7-
 *            ^     |
 *            |_____|
 */

package main.java;
import main.java.LinkedListUtils.Node;

public class LinkedListCycle {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        Node head = LinkedListUtils.createLinkedList(arr);
        LinkedListUtils.printList(head);
        System.out.println("The list contains cycle: " + hasCycle(head));

       createCycle(head);

        System.out.println("The list contains cycle: " + hasCycle(head));
    }

    private static void createCycle(Node head) { // O(n) O(1)
        Node pre = head;
        Node cur = head.next;
        for (int i = 0; i < 5; i++){
            cur = cur.next;
            pre = pre.next;
        }

        cur.next = pre;
        //LinkedListUtils.printList(head);
    }

    private static boolean hasCycle(Node head) { //O(n) O(1)
        if(head == null || head.next == null)
            return true;

        Node slow = head.next;
        Node fast = head.next.next;

        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }
}
