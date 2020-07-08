package com.hs.slz.spring.algorithm.DynamicProgramming;

/**
 * @author zhengsl26931
 */
public class FindMaxComposition {
    public static void main(String[] args) {
//        Given an array all of whose elements are positive numbers,
//        find the maximum sum of a subsequence with the constraint that no 2 numbers in the sequence should be adjacent in the array.
//        So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7 should return 15 (sum of 3, 5 and 7)
        System.out.println(backtrace(new int[]{3,2,7,10}));
        System.out.println(backtrace(new int[]{3,2,5,10,7}));

    }

    private static int backtrace(int[] arr) {
        int[] dp=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if(i==0){
                dp[i]=arr[i];
            }else if(i==1){
                dp[i]=Math.max(arr[i],arr[i-1]);
            }else{
                dp[i]=Math.max(arr[i]+dp[i-2],dp[i-1]);
            }
        }
        return dp[arr.length-1];

    }

}
