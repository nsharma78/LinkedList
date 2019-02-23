/*
 * Implement the following operations of a stack using queues.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Note: only standard queue operations are allowed, i.e., poll(), offer(), peek(), size() and isEmpty() in Java.
 */

package main.java;
import java.util.*;

public class StackUsingQueues {

    LinkedList<Integer> one;
    LinkedList<Integer> two;
    int size;

    public StackUsingQueues() {
        one = new LinkedList<>();
        two = new LinkedList<>();
        size = 0;
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("Is Emnpty: " + stack.isEmpty());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println("Is Emnpty: " + stack.isEmpty());
    }

    void push(int i) {
        if(one.isEmpty())
            one.add(i);
        else {
            while(!one.isEmpty())
                two.add(one.remove());
            one.add(i);
            while(!two.isEmpty())
                one.add(two.remove());
        }
        size++;
    }

    int pop() {
        size--;
        return one.remove();
    }

    int top() {
        return one.peek();
    }

    boolean isEmpty() {
        return size == 0;
    }
}
