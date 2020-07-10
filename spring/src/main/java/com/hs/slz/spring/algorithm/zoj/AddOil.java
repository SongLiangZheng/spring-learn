package com.hs.slz.spring.algorithm.zoj;

/**
 * @author zhengsl26931
 */
public class AddOil {//trace

    public static void main(String[] args) {
        int[] gas  =new int[]{3,3,4};
        int[] cost = new int[]{3,4,4};
        System.out.println(canCompleteCircuit(gas,cost));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        for (int i = 0; i < n; i++) {
            int temp=gas.length;
            int current=i;
            int own=gas[i];
            while(temp-->=1){
                if(own<cost[current])
                    break;
                own-=cost[current];
                current++;
                current%=n;
                own+=gas[current];
            }
            if(temp==-1)
                return i;
        }
        return -1;
    }

}
