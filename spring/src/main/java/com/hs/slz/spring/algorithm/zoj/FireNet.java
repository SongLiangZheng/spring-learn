package com.hs.slz.spring.algorithm.zoj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhengsl26931
 */
public class FireNet {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int dim = scanner.nextInt();
            if (dim == 0) {
                break;
            }
            int[][] map = new int[dim][dim];
            int[][] selects = new int[dim][dim];
            for (int i = 0; i < dim; i++) {
                for (int j = 0; j < dim; j++) {
                    if (!scanner.next().equals(".")) {
                        map[i][j] = -1;
                        selects[i][j] = -1;
                    }
                }
            }
            Integer max = 0;
            backtrace(map, selects, 0,0, max);
            System.out.println(max);
        }

    }

    private static void backtrace(int[][] map, int[][] selects, int x,int y, Integer max) {
        int dim = selects.length;
        int num = 0;
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (selects[i][j] == 1) {
                    num++;
                }
            }
        }
        max = Math.max(num, max);
        for (int i = x; i < dim; i++) {
            for (int j = y; j < dim; j++) {

            }
        }
    }
}
