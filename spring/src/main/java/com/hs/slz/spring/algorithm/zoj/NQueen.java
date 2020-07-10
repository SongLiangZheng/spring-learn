package com.hs.slz.spring.algorithm.zoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author zhengsl26931
 */
public class NQueen {

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        List<List<String>> lists = nQueen.solveNQueens(8);
        System.out.println(lists.size());
    }

    public List<List<String>> solveNQueens(int n) {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(".");
        }
        List<List<String>> lists = new ArrayList<>();
        int[] positions = new int[n];
        for (int i = 0; i < positions.length; i++) {
            positions[i]=-1;
        }
        backtrace(positions, 0, n, lists, sb.toString());

        return lists;
    }

    public void backtrace(int[] positions, int depth, int n, List<List<String>> lists, final String dots) {
        if (depth == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < positions.length; i++) {
                StringBuilder sb = new StringBuilder(dots);
                sb.setCharAt(positions[i],'Q');
                list.add(sb.toString());
//                System.out.println(sb.toString());
            }
            lists.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(positions, depth, i)) {
                continue;
            }
            positions[depth] = i;
            backtrace(positions, depth + 1, n, lists, dots);
            positions[depth] = -1;
        }
    }

    private boolean isValid(int[] positions, int depth, int i) {
        for (int position : positions) {
            if(position==i)
                return false;
        }
        for (int index = 0; index < depth; index++) {
            if (Math.abs(index - depth) == Math.abs(positions[index] - i)) {
                return false;
            }
        }
        return true;
    }
}
