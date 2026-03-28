package MiddleQuestion;

import java.security.PrivateKey;
import java.util.Iterator;

public class Q284_窥探迭代器 {

    class PeekingIterator implements Iterator<Integer> {


        private Iterator<Integer> iterator;
        private Integer cache;


        public PeekingIterator(Iterator<Integer> iter) {
            // initialize any member here.
            iterator = iter;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (cache == null) cache = iterator.next();
            return cache;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (cache == null) return iterator.next();
            Integer temp = cache;
            cache = null;
            return temp;
        }

        @Override
        public boolean hasNext() {
            return cache != null || iterator.hasNext();
        }
    }
}
