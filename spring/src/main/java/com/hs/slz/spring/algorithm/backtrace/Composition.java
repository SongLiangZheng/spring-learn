package com.hs.slz.spring.algorithm.backtrace;

import java.util.ArrayList;
import java.util.List;

public class Composition {
    static Integer[] arr = new Integer[]{1, 2, 3};
    static List<String> lists = new ArrayList<>();
    //求出arr的所有排列组合
    public static void main(String[] args) {
        backtrace(new ArrayList<>(), 0);
        for (Object list : lists) {
            System.out.println(list);
        }
    }

    private static void backtrace(List<Integer> nums, int depth) {
        if (depth == arr.length) {
            lists.add(nums.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (nums.contains(arr[i]))
                continue;

            nums.add(arr[i]);
            backtrace(nums, depth+1);
            nums.remove(arr[i]);
        }
    }
}
