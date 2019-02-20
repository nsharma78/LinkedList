/*
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3)
 *      + (5 -> 6 -> 4)
 *
 * Output: 7 -> 0 -> 8
 */

package main.java;
import main.java.LinkedListUtils.Node;

public class Add2Numbers {

    public static void main(String[] args) {
        int[] arr1 = {4,4,3};
        int[] arr2 = {5,6,7};
        Node head1 = LinkedListUtils.createLinkedList(arr1);
        Node head2 = LinkedListUtils.createLinkedList(arr2);
        LinkedListUtils.printList(head1);
        LinkedListUtils.printList(head2);

        /*head1 = ReverseLinkedList.reverseIterative(head1);
        head2 = ReverseLinkedList.reverseIterative(head2);

        Node head = add2Numbers(head1, head2);
        LinkedListUtils.printList(ReverseLinkedList.reverseIterative(head));*/
    }
}
