package main.java;

public class LinkedListUtils {

    static class Node {

        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        Node head = createLinkedList(arr);
        printList(head);
    }

    public static Node createLinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node cur = head;

        for(int i = 1; i < arr.length; ++i) {
            cur.next = new Node(arr[i]);
            cur.next.next = null;
            cur = cur.next;
        }
        return head;
    }

    public static void printList(Node head) {
        Node cur = head;
        while(cur != null) {
            System.out.print(cur.data + "->");
            cur = cur.next;
        }
        System.out.print("NULL");
    }
}
