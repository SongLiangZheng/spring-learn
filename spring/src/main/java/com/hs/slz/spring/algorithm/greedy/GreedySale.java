package com.hs.slz.spring.algorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class GreedySale {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 1, 2, 2, 1);
        deleteProducts(list, 3);
    }

    public static int deleteProducts(List<Integer> ids, int m) {
        // Write your code here
        List<Integer> uniIds = new ArrayList<>(new HashSet<>(ids));
        Map<Integer, Node> map = new HashMap<>();


        for (int i = 0; i < ids.size(); i++) {
            Integer id = ids.get(i);
            if (!map.containsKey(id)) {
                Node value = new Node();
                value.setNum(id);
                map.put(id, value);
            }
            Node node = map.get(id);
            node.setCount(node.getCount()+ 1);
        }
        List<Node> nodes = new ArrayList<>(map.values());
        Collections.sort(nodes);
        System.out.println(nodes);
        int left=m;
        List<Node> leftNodes=new ArrayList<>();
        for (Node node : nodes) {
            if(left>=node.getCount()){
                left-=node.getCount();
            }else {
                leftNodes.add(node);
            }
        }
        System.out.println(leftNodes.size());
        return leftNodes.size();
    }

    static class Node implements Comparable<Node> {
        int num;
        int count;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.count, o.count);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "num=" + num +
                    ", count=" + count +
                    '}';
        }
    }
}
