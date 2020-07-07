package com.hs.slz.spring.algorithm;

import java.util.*;

public class CountNum {
    public static final int MAX = 24;
    private static int COUNT = 0;
    public static int COUNT_MINE_METHOD = 0;

    public static Set<String> set = new HashSet<>();
    public static Integer[] arr = new Integer[]{1, 1, 2, 23, 22};


    public static String[] strs = new String[]{"1", "1", "2", "23", "22"};

    public static void main(String[] args) {
        backTrace(arr, 0, 0);
        System.out.println(COUNT_MINE_METHOD);

        backtrace(Arrays.asList(0, 0, 0, 0, 0), 0);
        System.out.println(COUNT);


        List<Integer> nums = new ArrayList<>();
        nums.add(Integer.valueOf("1"));
        nums.add(Integer.valueOf("1"));
        nums.remove(Integer.valueOf("1"));
        System.out.println(nums);


    }

    public static void backtrace(List<Integer> flagArr, int depth) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (flagArr.get(i) == 1)
                sum += arr[i];
        }
        if (sum == MAX) {
            COUNT++;
            System.out.println(flagArr);
            return;
        }
        if (depth == arr.length || sum > MAX) {
            return;
        }
        for (int i = depth; i < arr.length; i++) {
            flagArr.set(i, 1);
            backtrace(flagArr, depth + 1);
            flagArr.set(i, 0);
        }
    }

    private static boolean isValid(List<Integer> selects) {
        return false;
    }

    public static void backTrace(Integer[] arr, int depth, int sum) {
        if (sum > MAX)
            return;
        if (depth >= arr.length) {
            if (sum == MAX) {
                COUNT_MINE_METHOD++;
            }
            return;
        }
        backTrace(arr, depth + 1, sum + arr[depth]);
        backTrace(arr, depth + 1, sum);
    }
}
