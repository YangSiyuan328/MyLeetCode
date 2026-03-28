package SimpleQuestion;

import java.util.ArrayList;

public class Q572_另一棵树的子树 {

    // O(m*n)
    public boolean isSubtree1(TreeNode head1, TreeNode head2) {
        if (head2 == null) return true;
        if (head1 == null) return false;
        if (isSubVal(head1, head2)) return true;
        return isSubtree(head1.left, head2) || isSubtree(head1.right, head2);
    }

    private boolean isSubVal(TreeNode head1, TreeNode head2) {
        if (head1 == null && head2 == null) return true;
        if (head1 == null || head2 == null) return false;
        if (head1.val != head2.val) return false;
        return isSubVal(head1.left, head2.left) && isSubVal(head1.right, head2.right);
    }

    public boolean isSubtree(TreeNode big, TreeNode small) {
        if (small == null) return true;
        if (big == null) return false;
        ArrayList<String> b = preSerial(big);
        ArrayList<String> s = preSerial(small);
        String[] str = new String[b.size()];
        for (int i = 0; i < str.length; i++) {
            str[i] = b.get(i);
        }
        String[] match = new String[s.size()];
        for (int i = 0; i < match.length; i++) {
            str[i] = s.get(i);
        }
        return getIndexOf(str, match) != -1;
    }

    private ArrayList<String> preSerial(TreeNode head) {
        ArrayList<String> ans = new ArrayList<>();
        pres(head, ans);
        return ans;
    }

    private void pres(TreeNode head, ArrayList<String> ans) {
        if (head == null) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(head.val));
            pres(head.left, ans);
            pres(head.right, ans);
        }
    }

    public int getIndexOf(String[] str1, String[] str2) {
        if (str1 == null || str2 == null || str2.length < 1 || str1.length < str2.length) return -1;
        int[] next = getNextArray(str2);
        int x = 0, y = 0;
        while (x < str1.length && y < str2.length) {
            if (isEqual(str1[x],str2[y])) {
                x++;
                y++;
            } else if (next[y] != -1) { // y != 0
                y = next[y];
            } else { // y == 0
                x++;
            }
        }
        return y == str2.length ? x - y : -1;
    }

    public int[] getNextArray(String[] match) {
        if (match.length == 1) return new int[]{-1};
        int[] next = new int[match.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < next.length) {
            if (isEqual(match[i - 1],match[cn])) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

    private boolean isEqual(String a, String b) {
        if (a == null && b == null) {
            return true;
        } else {
            if (a == null || b == null) {
                return false;
            } else {
                return a.equals(b);
            }
        }
    }


}
