package MiddleQuestion;

public class Q1265_PrintImmutableLinkedListInReverse {
    public static void main(String[] args) {

    }

    public void printLinkedListInReverse(ImmutableListNode head) {
        if (head == null) return;
        printLinkedListInReverse(head.getNext());
        head.printValue();
    }
}

interface ImmutableListNode {
    public void printValue(); // print the value of this node.

    public ImmutableListNode getNext(); // return the next node.
};