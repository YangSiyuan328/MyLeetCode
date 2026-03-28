package MiddleQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Q17_LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        Q17_LetterCombinationsOfAPhoneNumber Q = new Q17_LetterCombinationsOfAPhoneNumber();
        System.out.println(Q.letterCombinations("23"));
    }

    HashMap<Character, String> map = new HashMap<>();
    ArrayList<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return list;
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        char[] chars = digits.toCharArray();
        dfs(chars, 0, "", list);
        return list;
    }

    public void dfs(char[] str, int i, String word, ArrayList<String> list) {
        if (i == str.length) {
            list.add(word);
            return;
        }
        String s = map.get(str[i]);
        for (int k = 0; k < s.length(); k++) {
            dfs(str, i + 1, word + s.charAt(k), list);
        }
    }
}

class Solution {
    String[] letter_map = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {

        if(digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        iterStr(digits,new StringBuilder(),0);
        return res;
    }
    List<String> res = new ArrayList<>();
    //原来的str   做拼接的stringbuilder   给的str的下标  带代表一个字母
    void iterStr(String str,StringBuilder letter,int index){
        if(index == str.length()){
            res.add(letter.toString());
            return;
        }
        //c取到该字符
        char c = str.charAt(index);
        int pos = c - '0';
        String map_string = letter_map[pos];
        for(int i = 0;i < map_string.length(); i++){
            letter.append(map_string.charAt(i));
            iterStr(str,letter,index + 1);
            letter.deleteCharAt(letter.length() - 1);
        }
    }
}