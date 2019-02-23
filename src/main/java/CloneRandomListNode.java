package main.java;
import java.util.*;

public class CloneRandomListNode {

    // RandomNode
    static class RandomNode{
        int data;
        RandomNode next;
        RandomNode random;

        RandomNode(int d){
            data = d;
            next = null;
            random = null;
        }
    }

    public static RandomNode createLinkedList(int[] arr) {
        RandomNode head = new RandomNode(arr[0]);
        RandomNode curr = head;
        for(int i = 1; i < arr.length; i++) {
            RandomNode temp = new RandomNode(arr[i]);
            curr.next = temp;
            curr = curr.next;
        }
        return head;

    }

    public static void printList(RandomNode head) {
        RandomNode cur = head;
        System.out.println("====================================Linked List====================================");
        while(cur != null) {
            System.out.print(cur.data + "->");
            cur = cur.next;
        }
        System.out.println("NULL\n");

        cur = head;
        while(cur != null) {
            System.out.print(cur.random.data + "->");
            cur = cur.next;
        }
        System.out.println("NULL\n");
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        RandomNode head = createLinkedList(arr);


        RandomNode curr = head;
        curr.random = curr.next.next.next.next;
        curr.next.random = curr.next.next.next;
        curr.next.next.random = curr.next.next;
        curr.next.next.next.random = curr.next;
        curr.next.next.next.next.random = curr;

        printList(head);

        RandomNode newHead = cloneList(head);
        printList(newHead);

    }

    private static RandomNode cloneList(RandomNode head) {
        if(head == null)
            return null;
        Map<RandomNode, RandomNode> map = new HashMap<>();
        RandomNode newHead = new RandomNode(head.data);
        map.put(head,  newHead);

        RandomNode n1 = head;
        RandomNode n2 = newHead;
        n1 = n1.next;

        while(n1 != null) {
            n2.next = new RandomNode(n1.data);
            n2 = n2.next;
            map.put(n1,  n2);
            n1 = n1.next;
        }

        n1 = head;
        n2 = newHead;

        while(n1 != null) {
            if(n1.random != null) {
                n2.random = map.get(n1.random);
            }
            else {
                n2.random = null;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return newHead;

    }
}
