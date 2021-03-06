package com.hs.slz.spring.algorithm.DynamicProgramming;

import java.util.Arrays;

public class MultiPackage {
    public static final int N = 3;
    public static final int W = 15;
    public static final int[] G = new int[]{2, 3, 4};
    public static final int[] P = new int[]{3, 4, 5};
    public static final int[] M = new int[]{4, 3, 2};


//    public static final int N = 2;
//    public static final int W = 8;
//    public static final int[] G = new int[]{100,100};
//    public static final int[] P = new int[]{2,4};
//    public static final int[] M = new int[]{4,2};


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
                    while (k * P[n - 1] >= 0 && k * P[n - 1] <= w && k <= M[n - 1]) {
                        int value = G[n - 1] * k;
                        if (value > max)
                            max = value;
                        k++;
                    }
                    former[w] = max;
                } else {
                    while (k * P[n - 1] >= 0 && k * P[n - 1] <= w && k <= M[n - 1]) {
                        int value = former[w - P[n - 1] * k] + G[n - 1] * k;
                        if (value > max)
                            max = value;
                        k++;
                    }
                    current[w] = max;
                }
            }
            if (n > 1){
                former = Arrays.copyOf(current,W+1);
            }

            for (int i = 0; i < former.length; i++) {
                System.out.print(former[i]+" ");
            }
            System.out.println();

        }
        return current[W];
    }

    public static int recursion(int n, int w, int valueCounter) {
        if (n == 0 || w == 0)
            return valueCounter;
        int max = 0;
        int k = 0;
        while (k * P[n - 1] >= 0 && k * P[n - 1] <= w && k <= M[n - 1]) {
            int value = recursion(n - 1, w - P[n - 1] * k, valueCounter + G[n - 1] * k);
            if (value > max)
                max = value;
            k++;
        }
        return max;
    }

}
