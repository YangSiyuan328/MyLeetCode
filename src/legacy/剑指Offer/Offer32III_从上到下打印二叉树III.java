package 剑指Offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Offer32III_从上到下打印二叉树III {

    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        helper(root,0);
        return res;
    }

    private void helper(TreeNode root,int level){
        if(root==null)
            return;
        if(res.size()==level){
            res.add(new ArrayList<>());
        }
        if(level%2==0){
            res.get(level).add(root.val);

        }else{
            res.get(level).add(0,root.val);
        }
        helper(root.left,level+1);
        helper(root.right,level+1);
    }

    ArrayList<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> levelOrder1(TreeNode head) {
        dfs(0, head);
        for (int i = 1; i < lists.size(); i+=2) {
            Collections.reverse(lists.get(i));
        }
        return lists;
    }

    private void dfs(int deep, TreeNode node) {
        if (node == null) return;
        if (deep == lists.size()) {
            lists.add(new ArrayList<>());
        }
        lists.get(deep).add(node.val);
        dfs(deep + 1, node.left);
        dfs(deep + 1, node.right);
    }
}
