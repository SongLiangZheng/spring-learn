package com.hs.slz.spring.algorithm.backtrace;

import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SumOfXYLessThanK {
    static int counter = 0;
    static int k = 4;

    static int X = 3;
    static int Y = 3;

    //在坐标系第一象限，设定边界(X,Y)，问总共有存在多少个坐标满足sum(x,y)<=k
    public static void main(String[] args) {
        backtrace(new ArrayList<>(), new Position(0, 0));
        System.out.println(counter);
    }

    public static void backtrace(List<Position> list, Position position) {
        if (position.x == X && position.y == Y)
            return;
        if (position.sum() <= k) {
            counter++;
            list.add(position);
        }
        List<Position> positions = Arrays.asList(
                new Position(position.x + 1, position.y),
                new Position(position.x, position.y + 1));
        for (Position pos : positions) {
            if (!isValid(pos) || list.contains(pos))
                continue;
            backtrace(list, pos);
        }

    }

    public static boolean isValid(Position position) {
        if (position.x <= X && position.y <= Y && position.x >= 0 && position.y >= 0)
            return true;
        return false;
    }

    private static class Position {
        public int x;
        public int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int sum() {
            return x + y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x &&
                    y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
