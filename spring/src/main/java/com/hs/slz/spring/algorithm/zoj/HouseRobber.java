package com.hs.slz.spring.algorithm.zoj;

/**
 * @author zhengsl26931
 */
public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        HouseRobber houseRobber = new HouseRobber();
        int rob = houseRobber.rob(nums);
        System.out.println(rob);

        System.out.println(houseRobber.dp(nums));

    }

    public int rob(int[] nums) {
        int[] max = new int[]{0};
        backtrace(nums, new int[nums.length], 0, max);
        return max[0];
    }

    public int dp(int[] a) {
        int[] dp = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if(i==0){
                dp[i]=a[i];
            }else if(i==1){
                dp[i]=Math.max(a[i],a[i-1]);
            }else{
                dp[i]=Math.max(dp[i-1],dp[i-2]+a[0]);
            }
        }
        return dp[a.length - 1];
    }

    public void backtrace(int[] nums, int[] selectFlags, int depth, int[] max) {
        int sum = 0;
        for (int i = 0; i < selectFlags.length; i++) {
            if (selectFlags[i] == 1) {
                sum += nums[i];
            }
        }

        max[0] = Math.max(sum, max[0]);
        if (depth == selectFlags.length) {
            return;
        }

        for (int i = depth; i < nums.length; i++) {
            if (i - 1 >= 0 && selectFlags[i - 1] == 1) {
                continue;
            }
            selectFlags[i] = 1;
            backtrace(nums, selectFlags, i + 1, max);
            selectFlags[i] = 0;
        }
    }

}
