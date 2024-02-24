package com.devamatre.theorem.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * Your LC225ImplementStackUsingQueues object will be instantiated and called as such:
 * LC225ImplementStackUsingQueues instance = new LC225ImplementStackUsingQueues();
 * instance.push(x);
 * int param_2 = instance.pop();
 * int param_3 = instance.top();
 * boolean param_4 = instance.empty();
 * </pre>
 *
 * @author Rohtash Lakra
 * @created 1/31/24 12:13 PM
 */
public class LC225ImplementStackUsingQueues {

    Queue<Integer> pushQueue = new LinkedList<>();
    Queue<Integer> popQueue = new LinkedList<>();
    int top = -1;

    public LC225ImplementStackUsingQueues() {

    }

    public void push(int x) {
        top = x;
        popQueue.offer(x);
    }

    public int pop() {
        int remove = -1;
        // move all elements > 1 to pushQueue
        while (!popQueue.isEmpty()) {
            remove = popQueue.remove();
            if (!popQueue.isEmpty()) {
                pushQueue.add(remove);
            }
        }

        // move all elements back to popQueue
        while (!pushQueue.isEmpty()) {
            top = pushQueue.remove();
            popQueue.add(top);
        }

        return remove;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return popQueue.isEmpty();
    }
}