/*
 * Implement the following operations of a queue using stacks.
 * add(x) -- Push element x to the back of queue.
 * remove() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 */

package main.java;
import java.util.Stack;

public class QueueUsingStacks {

    Stack<Integer> one;
    Stack<Integer> two;
    int size;

    public QueueUsingStacks() {
        one = new Stack<Integer>();
        two = new Stack<Integer>();
        size = 0;
    }

    public boolean empty() {
        return (size == 0);
    }

    public int peek() {
        return one.peek();
    }

    public int remove() {
        size--;
        return one.pop();
    }

    public void add(int i) { // O(n) O(n)
        if(one.isEmpty())
            one.push(i);
        else {
            while(!one.isEmpty())
                two.push(one.pop());
            one.push(i);
            while(!two.isEmpty())
                one.push(two.pop());
        }
        size++;
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println("Is Emnpty: " + queue.empty());
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println("Is Emnpty: " + queue.empty());
    }

}
