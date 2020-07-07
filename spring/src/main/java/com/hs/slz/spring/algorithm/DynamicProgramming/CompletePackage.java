package com.hs.slz.spring.algorithm.DynamicProgramming;

import java.util.Arrays;

public class CompletePackage {
    //    public static final int N = 5;
//    public static final int W = 10;
//    public static final int[] G = new int[]{400, 500, 200, 300, 350};
//    public static final int[] P = new int[]{5, 5, 3, 4, 3};
//    public static final int N = 3;//10
//    public static final int W = 4;
//    public static final int[] G = new int[]{2,5,7};
//    public static final int[] P = new int[]{1,2,3};

//    public static final int N = 3;//7
//    public static final int W = 5;
//    public static final int[] G = new int[]{3,4,5};
//    public static final int[] P = new int[]{2,3,4};


    public static final int N = 2;//10
    public static final int W = 10;
    public static final int[] G = new int[]{5,8};
    public static final int[] P = new int[]{5,7};

    public static void main(String[] args) {
        System.out.println(recursion(N, W, 0));
        System.out.println(backup());
    }

    public static int backup() {
        int[] former = new int[W + 1];
        int[] current = new int[W + 1];
        for (int n = 1; n <= N; n++) {
            for (int w = 1; w <= W; w++) {
                int max = 0;
                int k = 0;
                if (n == 1) {
                    while (k * P[n - 1] >= 0 && k * P[n - 1] <= w) {
                        int value = G[n - 1] * k;
                        if (value > max)
                            max = value;
                        k++;
                    }
                    former[w] = max;
                } else {
                    while (k * P[n - 1] >= 0 && k * P[n - 1] <= w) {
                        int value = former[w - P[n - 1] * k] + G[n - 1] * k;
                        if (value > max)
                            max = value;
                        k++;
                    }
                    current[w] = max;
                }
            }
            if(n>1)
                former = Arrays.copyOf(current,W+1);

        }
        return current[W];
    }

    public static int recursion(int n, int w, int valueCounter) {
        if (n == 0 || w == 0)
            return valueCounter;
        int max = 0;
        int k = 0;
        while (k * P[n - 1] >= 0 && k * P[n - 1] <= w) {
            int value = recursion(n - 1, w - P[n - 1] * k, valueCounter + G[n - 1] * k);
            if (value > max)
                max = value;
            k++;
        }
        return max;
    }
}
