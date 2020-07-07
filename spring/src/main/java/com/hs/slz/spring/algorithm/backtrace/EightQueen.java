package com.hs.slz.spring.algorithm.backtrace;

import java.util.ArrayList;
import java.util.List;

public class EightQueen {
    static int size = 8;
    static int n = 0;

    public static void main(String[] args) {
        backtrace(new ArrayList<>(), 0);
        System.out.println(n);
    }

    private static void backtrace(List<String> selects, int depth) {
        if (selects.size() == size) {
            n++;
            return;
        }

        for (int i = 0; i < size; i++) {
            String value = String.valueOf(i);
            if (!isValid(selects, depth, value))
                continue;
            selects.add(value);
            backtrace(selects, depth + 1);
            selects.remove(value);
        }
    }

    private static boolean isValid(List<String> selects, int depth, String value) {
        if (selects.contains(value))
            return false;
        for (int i = 0; i < selects.size(); i++) {
            if (Math.abs(i - depth) == Math.abs(Integer.valueOf(selects.get(i)) - Integer.valueOf(value)))
                return false;
        }
        return true;
    }
}
