package 剑指Offer;

import java.util.Stack;

public class Offer09_用两个栈实现队列 {

    public static void main(String[] args) {
        CQueue obj = new CQueue();
        obj.appendTail(3);
        int param_1 = obj.deleteHead();
        int param_2 = obj.deleteHead();
        System.out.println(param_2);
    }

    private static class CQueue {
        Stack<Integer> stackIn;
        Stack<Integer> stackOn;

        public CQueue() {
            stackIn = new Stack<>();
            stackOn = new Stack<>();
        }

        public void appendTail(int value) {
            stackIn.push(value);
        }

        public int deleteHead() {
            if (stackOn.isEmpty()) {
                if (stackIn.isEmpty()) return -1;
                while (!stackIn.isEmpty()) {
                    stackOn.push(stackIn.pop());
                }
            }
            return stackOn.pop();
        }

    }

}
/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */