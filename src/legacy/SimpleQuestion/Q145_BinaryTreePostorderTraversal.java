package SimpleQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q145_BinaryTreePostorderTraversal {
    List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode head) {
        if (head == null) return list;
        postorderTraversal(head.left);
        postorderTraversal(head.right);
        list.add(head.val);
        return list;
    }

    public List<Integer> postorderTraversal2(TreeNode head) {
        if (head == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> help = new Stack<>();
        stack.push(head);while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            help.push(cur);
            if (cur.left!=null){
                stack.push(cur.left);
            }
            if (cur.right!=null){
                stack.push(cur.right);
            }
        }

        while (!help.isEmpty()){
            TreeNode cur = stack.pop();
            list.add(cur.val);
        }
        return list;
    }

}
