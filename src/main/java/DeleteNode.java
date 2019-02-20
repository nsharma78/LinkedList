/*'
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
 */

package main.java;
import main.java.LinkedListUtils.Node;

public class DeleteNode {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        Node head = LinkedListUtils.createLinkedList(arr);
        LinkedListUtils.printList(head);
        Node node = head.next.next;
        deleteNode(node);
        LinkedListUtils.printList(head);
    }

    private static void deleteNode(Node node) { // O(1) O(size of Node)
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
