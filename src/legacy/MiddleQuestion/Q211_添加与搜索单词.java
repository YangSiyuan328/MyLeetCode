package MiddleQuestion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q211_添加与搜索单词 {

class WordDictionary {

    // 树节点定义
    private class TrieNode {
        TrieNode[] path;
        boolean end; // 是否存在以当前字符结尾的word

        public TrieNode() {
            path = new TrieNode[26]; // word中只含有26个小写字符，所以准备26条路
        }
    }


    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        // 把word挂到前缀树上
        TrieNode cur = root;
        for (char c: word.toCharArray()) {
            // 五路建路，无路上路
            if (cur.path[c - 'a'] == null) {
                cur.path[c - 'a'] = new TrieNode();
            }
            cur = cur.path[c - 'a']; // 进入下一层
        }
        cur.end = true; // 最后一个word的字符，记得给整个树的这个点给一个end标志
    }

    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        return search(word.toCharArray(), 0, root);
    }

    // DFS递归，当前字符：char[i], 当前来到的前缀树节点：cur
    // 返回：[i,...]能否匹配上
    private boolean search(char[] chars, int i, TrieNode cur) {
        if (cur == null) {
            return false;
        }
        char curChar = chars[i];
        // 当前已经是要查找的最后一个字符了
        if (i == chars.length - 1) {
            if (curChar != '.') { // 最后一个字符不是点，需要在前缀树上严格匹配 （有对应的路，并且这条路上有end）
                return cur.path[curChar - 'a'] != null && cur.path[curChar - 'a'].end; //！！！！！！！！！！
            } else { // 最后一个字符不是点，只要存在一条有end的路即可匹配成功
                for (TrieNode node: cur.path) {
                    if (node != null && node.end) {
                        return true;
                    }
                }
                return false; // 说明for找完当前cur的path所有节点，没找到就end，就说明不存在
            }
        }

        // 当前不是最后一个字符，还有不止一个字符需要匹配
        if (curChar != '.') { // 不是点，需要在前缀树上严格匹配 （对所对应的路，并且后续也能匹配上）DFS 递归
            return cur.path[curChar - 'a'] != null && search(chars, i + 1, cur.path[curChar - 'a']);
        }
        // curChar == '.'的情况，只要存在一条路，使得后续可以匹配上即可
        for (TrieNode node: cur.path) { // 所有路都去DFS一下，比较费时，不像上面是明确到 cur.path[curChar - 'a'] 这条路去
            if (search(chars, i + 1, node)) {
                return true;
            }
        }

        return false; // 没找到
    }

}

    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */
}
