package com.hs.slz.spring.algorithm.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhengsl26931
 */
public class DigGold_01package {

    public static final int N = 5;
    public static final int W = 10;
    public static final int[] G = new int[]{0, 400, 500, 200, 300, 350};
    public static final int[] P = new int[]{0, 5, 5, 3, 4, 3};

    public static void main(String[] args) {
        System.out.println(recursion(N, W));
        System.out.println(memorandum());
        System.out.println(dynamicSchedule());

        int[] arr1={1,2,3};
        int[] arr2=arr1;
        int[] arr3=Arrays.copyOf(arr1,arr1.length);
        arr2[1]=100;
        arr3[1]=200;
        System.out.println();
    }

    public static int dynamicSchedule() {
        int temp[] = new int[W + 1];
        int current[] = new int[W + 1];
        for (int n = 1; n <= N; n++) {
            for (int w = 1; w <= W; w++) {
                if (n == 1) {
                    if (w < P[n]) {
                        temp[w] = 0;
                    } else {
                        temp[w] = G[n];
                    }
                } else {
                    if (w < P[n]) {
                        current[w] = temp[w];
                    } else {
                        current[w] = Math.max(temp[w], temp[w - P[n]] + G[n]);
                    }
                }
            }
            if(n>1)
                temp= Arrays.copyOf(current,current.length);
        }
        return current[W];
    }

    public static int memorandum() {
        int temp[][] = new int[N + 1][W + 1];
        for (int n = 1; n <= N; n++) {
            for (int w = 1; w <= W; w++) {
                if (n == 1) {
                    if (w < P[n]) {
                        temp[n][w] = 0;
                    } else {
                        temp[n][w] = G[n];
                    }
                } else {
                    if (w < P[n]) {
                        temp[n][w] = temp[n - 1][w];
                    } else {
                        temp[n][w] = Math.max(temp[n - 1][w], temp[n - 1][w - P[n]] + G[n]);
                    }
                }
            }
        }
        return temp[N][W];
    }

    public static int recursion(int n, int w) {
        if (n == 1) {
            if (w < P[n]) {
                return 0;
            } else {
                return G[n];
            }
        } else {
            if (w < P[n]) {
                return recursion(n - 1, w);
            } else {
                int max = Math.max(recursion(n - 1, w), recursion(n - 1, w - P[n]) + G[n]);
                return max;
            }
        }

    }

}
