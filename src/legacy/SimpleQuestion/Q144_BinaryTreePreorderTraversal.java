package SimpleQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q144_BinaryTreePreorderTraversal {

    List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode head) {
        if (head == null) return list;
        list.add(head.val);
        preorderTraversal(head.left);
        preorderTraversal(head.right);
        return list;
    }

    public List<Integer> preorderTraversal2(TreeNode head) {
        if (head == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if (cur.right!=null){
                stack.push(cur.right);
            }
            if (cur.left!=null){
                stack.push(cur.left);
            }
        }
        return list;
    }

}

