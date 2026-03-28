package SimpleQuestion;

import java.util.ArrayList;
import java.util.List;

public class Q412_FizzBuzz {

    ArrayList<String> list = new ArrayList<>();

    public List<String> fizzBuzz1(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) list.add("FizzBuzz");
            else if (i % 3 == 0) list.add("Fizz");
            else if (i % 5 == 0) list.add("Buzz");
            else list.add(String.valueOf(i));
        }
        return list;
    }

    public List<String> fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) fuc(i);
        return list;
    }

    void fuc(int i) {
        if (i % 3 == 0 && i % 5 == 0) list.add("FizzBuzz");
        else if (i % 3 == 0) list.add("Fizz");
        else if (i % 5 == 0) list.add("Buzz");
        else list.add(String.valueOf(i));
    }
}

