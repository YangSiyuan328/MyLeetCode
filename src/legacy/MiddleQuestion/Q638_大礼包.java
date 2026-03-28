package MiddleQuestion;

import java.util.List;

public class Q638_大礼包 {

    int res = Integer.MAX_VALUE;
    int now = 0;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        dfs(price, special, needs);
        return res;
    }

    public void dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs){
        int sum = 0;
        for (Integer need : needs) sum += need;
        if (sum == 0){
            res = Math.min(res, now);
            return;
        }
        for (List<Integer> s : special) {
            boolean check = true;
            for (int i = 0; i < needs.size(); i++) {
                if (s.get(i) > needs.get(i)){
                    check = false;
                    break;
                }
            }
            if (!check) continue;
            for (int i = 0; i < needs.size(); i++) needs.set(i, needs.get(i)-s.get(i));
            now += s.get(s.size()-1);
            dfs(price, special, needs);
            now -= s.get(s.size()-1);
            for (int i = 0; i < needs.size(); i++) needs.set(i, needs.get(i)+s.get(i));
        }
        for (int i = 0; i < needs.size(); i++) if (needs.get(i) > 0) now += needs.get(i) * price.get(i);
        res = Math.min(now, res);
        for (int i = 0; i < needs.size(); i++) if (needs.get(i) > 0) now -= needs.get(i) * price.get(i);
    }

}
