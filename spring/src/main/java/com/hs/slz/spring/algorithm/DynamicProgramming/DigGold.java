package com.hs.slz.spring.algorithm.DynamicProgramming;

/**
 * @author zhengsl26931
 */
public class DigGold {

    public static final int C = 10;
    public static final int[] V = new int[]{400, 500, 200, 300, 350};
    public static final int[] W = new int[]{5, 5, 3, 4, 3};

    static int[][] dp = new int[V.length][C + 1];

    public static void main(String[] args) {

        System.out.println(dynamicProgramming());
        backtrace(new int[W.length], 0);
        System.out.println(max);
    }

    private static int dynamicProgramming() {
        for (int i = 0; i < V.length; i++) {
            for (int j = 1; j <= C; j++) {
                if (i == 0) {
                    if (j >= W[i]) {
                        dp[i][j] = V[i];
                    }
                } else {
                    if (j >= W[i]) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[W.length - 1][C];
    }

    private static int max = 0;

    private static void backtrace(int[] selectFlags, int depth) {
        int sum = 0;
        int leftCapacity = C;
        for (int i = 0; i < selectFlags.length; i++) {
            if (selectFlags[i] == 1) {
                sum += V[i];
                leftCapacity -= W[i];
            }
        }
        if (sum > max) {
            max = sum;
        }
        if (depth >= W.length) {
            return;
        }

        for (int i = depth; i < W.length; i++) {
            if (leftCapacity < W[i]) {
                continue;
            }
            selectFlags[i] = 1;
            backtrace(selectFlags, i+1);
            selectFlags[i] = 0;
        }
    }

}
