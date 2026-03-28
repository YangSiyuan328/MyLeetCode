package MiddleQuestion;

public class Q470_用Rand7实现Rand10 {

    class Solution extends SolBase {


        // 10 -> 110
        public int rand10() {
            int ans = rand2();
            for (int i = 0; i < 3; i++) {
                ans <<= 1;
                ans ^= rand2();
            }
            return (ans <= 10 && ans > 0) ? ans : rand10();
        }

        public int rand2() {
            int ans = rand7();
            return ans == 7 ? rand2() : ans % 2;
        }

        // [0,49] % 10 + 1
        public int rand101() {
            int rand49 = 0;
            do {
                rand49 = (rand7() - 1) * 7 + rand7();
            } while (rand49 > 40);
            return rand49 % 10 + 1;
        }

        // [0,1] * 5 + [1,5]
        public int rand102() {
            int help1 = rand7();
            while (help1 == 7) {
                help1 = rand7();
            }
            help1 = (help1 & 1) * 5;
            int help2 = rand7();
            while (help2 > 5) {
                help2 = rand7();
            }
            return help1 + help2;
        }
    }


    static class SolBase {
        public int rand7() {
            return (int) (Math.random() * 7 + 1);
        }

    }


}
