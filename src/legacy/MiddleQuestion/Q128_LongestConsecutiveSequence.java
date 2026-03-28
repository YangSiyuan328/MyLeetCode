package MiddleQuestion;

import java.util.*;

public class Q128_LongestConsecutiveSequence {

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6}));
        //System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int res = 0;
        for (int n : nums) {
            if (set.contains(n - 1)) {
                continue;
            }
            int cur = n + 1, tmp = 1;
            while (set.remove(cur)) {
                tmp++;
                cur++;
            }
            res = Math.max(res, tmp);
        }
        return res;
    }

    public static int longestConsecutive1(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int res = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        UnionSet<Integer> unionSet = new UnionSet<>(list);
        for (int num : nums) {
            if (unionSet.isExist(num - 1) && !unionSet.isSameSet(num, num - 1)) {
                unionSet.union(num, num - 1);
            }
            if (unionSet.isExist(num + 1) && !unionSet.isSameSet(num, num + 1)) {
                unionSet.union(num, num + 1);
            }
            res = Math.max(res, unionSet.getSize(num));
        }
        return res;
    }


    public static class Node<V> {
        V value;

        public Node(V value) {
            this.value = value;
        }
    }

    public static class UnionSet<V> {
        public HashMap<V, Node<V>> nodes = new HashMap<>();
        public HashMap<Node<V>, Node<V>> parents = new HashMap<>();
        public HashMap<Node<V>, Integer> sizeMap = new HashMap<>();

        public UnionSet(List<V> values) {
            for (V cur : values) {
                Node<V> node = new Node<>(cur);
                nodes.put(cur, node);
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        // 从点cur开始，一直往上找，找到不能再往上的代表点，返回
        public Node<V> findFather(Node<V> cur) {
            Stack<Node<V>> path = new Stack<>();
            while (cur != parents.get(cur)) {
                path.push(cur);
                cur = parents.get(cur);
            }
            // cur头节点
            while (!path.isEmpty()) {
                parents.put(path.pop(), cur);
            }
            return cur;
        }

        public boolean isExist(V v) {
            return nodes.containsKey(v);
        }

        public int getSize(V v) {
            return sizeMap.get(findFather(nodes.get(v)));
        }

        public boolean isSameSet(V a, V b) {
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return false;
            }
            return findFather(nodes.get(a)) == findFather(nodes.get(b));
        }

        public void union(V a, V b) {
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return;
            }
            Node<V> aHead = findFather(nodes.get(a));
            Node<V> bHead = findFather(nodes.get(b));
            if (aHead != bHead) {
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                Node<V> big = aSetSize > bSetSize ? aHead : bHead;
                Node<V> small = big == aHead ? bHead : aHead;
                parents.put(small, big);
                sizeMap.put(big, aSetSize + bSetSize);
                sizeMap.remove(small);
            }

        }
    }
}
