package com.hs.slz.spring.algorithm.zoj;

/**
 * @author zhengsl26931
 */
public class JumpToTheEnd {//greedy

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public static boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i>max)
                break;
            max = Math.max(i + nums[i], max);
            if (max >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }
}
