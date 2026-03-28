package 剑指Offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Offer31_栈的压入弹出序列 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque();
        int i = 0;
        for (int elem : pushed) {
            stack.push(elem);
            while (i < popped.length && !stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return i == popped.length;
    }
}
