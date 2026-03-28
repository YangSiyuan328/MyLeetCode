package 剑指Offer;

import java.util.Stack;

public class Offer30_包含min函数的栈 {

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        MinStack2 obj2 = new MinStack2();
        test(obj2);
    }

    /*
        ["top","pop","min","pop","min","pop","push","top","min","push","top","min","pop","min"]
        [[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
    */
    private static void test(MinStack2 obj) {
        obj.push(2147483646);
        obj.push(2147483646);
        obj.push(2147483647);
        System.out.println(obj.top());
        obj.pop();
        System.out.println(obj.min());
        obj.pop();
        System.out.println(obj.min());
        obj.pop();
        obj.push(2147483647);
        System.out.println(obj.top());
        System.out.println(obj.min());
        obj.push(-2147483648);
        System.out.println(obj.top());
        System.out.println(obj.min());
        obj.pop();
        System.out.println(obj.min());
    }

    private static class MinStack {
        static Stack<Integer> dataStack;
        static Stack<Integer> minNumStack;
        int curMin = Integer.MAX_VALUE;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            dataStack = new Stack<>();
            minNumStack = new Stack<>();
        }

        public void push(int x) {
            dataStack.push(x);
            if (x < curMin) {
                curMin = x;
            }
            minNumStack.push(curMin);
        }

        public void pop() {
            if (dataStack.isEmpty()) {
                return;
            }
            dataStack.pop();
            minNumStack.pop();
            if (!dataStack.isEmpty()) {
                curMin = minNumStack.peek();
            } else {
                curMin = Integer.MAX_VALUE;
            }
        }

        public int top() {
            return dataStack.peek();
        }

        public int min() {
            return curMin;
        }
    }

    private static class MinStack2 {
        Stack<Integer> dataStack;
        Stack<Integer> minNumStack;
        int curMin = Integer.MAX_VALUE;

        /**
         * initialize your data structure here.
         */
        public MinStack2() {
            dataStack = new Stack<>();
            minNumStack = new Stack<>();
        }

        public void push(int x) {
            dataStack.push(x);
            if (x <= curMin) {
                curMin = x;
                minNumStack.push(x);
            }
        }

        public void pop() {
            if (dataStack.isEmpty()) {
                return;
            }
            Integer pop = dataStack.pop();
            if (pop == curMin) {
                minNumStack.pop();
                curMin = minNumStack.isEmpty() ? Integer.MAX_VALUE : minNumStack.peek();
            }
        }

        public int top() {
            return dataStack.peek();
        }

        public int min() {
            return curMin;
        }
    }


}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
