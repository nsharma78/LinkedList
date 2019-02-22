/*
 * Given a singly linked list, determine if it is a palindrome.
 */

package main.java;
import main.java.LinkedListUtils.Node;

public class PalindromeList {

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,2,1};
        Node head = LinkedListUtils.createLinkedList(arr);
        LinkedListUtils.printList(head);

        System.out.println("The given list is palindrome: " + isPalindrome(head));
    }

    private static boolean isPalindrome(Node head) { // O(n) O(1)
        if(head == null || head.next == null)
            return true;

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node first = head;
        Node second = slow.next;
        slow.next = null;
        second = ReverseLinkedList.reverseIterative(second);

        while(second != null) {
            if(first.data != second.data)
                return false;
            first = first.next;
            second = second.next;
        }
        return true;
    }
}
