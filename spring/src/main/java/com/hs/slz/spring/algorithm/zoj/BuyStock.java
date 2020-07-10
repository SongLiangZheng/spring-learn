package com.hs.slz.spring.algorithm.zoj;

import java.util.Arrays;

/**
 * @author zhengsl26931
 */
public class BuyStock {//dp

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 0, 2};
        prices = new int[]{2,1,4};
        System.out.println(maxProfit(prices));


    }

    public static int maxProfit(int[] a) {
        int len = a.length;
        if (len <= 1) {
            return 0;
        }

        int[] dp = new int[len];
        for (int n = 0; n < len; n++) {
            if(n==0){
                dp[0] = 0;
            }else if(n==1){
                dp[1] = a[1] > a[0] ? a[1] - a[0] : 0;
            }else{
                int max = 0;
                max = Math.max(max, dp[n - 1]);
                for (int i = 3; n - i >= 0; i++) {
                    max = Math.max(max, dp[n - i] + (a[n] - a[n - i + 2]));
                }
                max=Math.max(max,a[n]-a[0]);
                max=Math.max(max,a[n]-a[1]);
                dp[n] = max;
            }

        }
        return dp[len - 1];
    }
}