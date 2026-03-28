package SimpleQuestion;

import java.util.ArrayList;

public class Q101_SymmetricTree {

    public boolean isSymmetric(TreeNode head) {
        if (head == null) return true;
        ArrayList<TreeNode> arr1 = new ArrayList<>();
        in(head, arr1);
        ArrayList<TreeNode> arr2 = new ArrayList<>();
        on(head, arr2);
        for (int i = 0; i < arr1.size(); i++) {
            if (arr1.get(i) != null && arr2.get(i) != null) {
                if (arr1.get(i).val != arr1.get(i).val) return false;
            }
            if (arr1.get(i) != null && arr2.get(i) == null) {
                return false;
            }
            if (arr1.get(i) == null && arr2.get(i) != null) {
                return false;
            }
        }
        return true;
    }

    public static void in(TreeNode head, ArrayList<TreeNode> arr) {
        if (head == null) return;
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
    }

    public static void on(TreeNode head, ArrayList<TreeNode> arr) {
        if (head == null) return;
        on(head.left, arr);
        arr.add(head);
        on(head.right, arr);
    }


}
