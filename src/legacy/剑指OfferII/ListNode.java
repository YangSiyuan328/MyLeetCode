package 剑指OfferII;


public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     *
     * @param arr 构造链表的数组
     * @param length 数组的长度 & 链表的长度
     * @param i 数组的开始索引
     */
    ListNode(int[] arr, int length, int i) {
        this.val = arr[i];
        if (i < length - 1) {
            this.next = new ListNode(arr, length, i + 1);
        } else {
            this.next = null;
        }
    }


    // 遍历方法
    public static void show(ListNode l) {
        while (l != null) {
            System.out.print(l.val + " ");
            l = l.next;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        show(this);
        return "";
    }
}