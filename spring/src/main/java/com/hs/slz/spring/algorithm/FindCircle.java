package com.hs.slz.spring.algorithm;

import java.util.HashSet;
import java.util.Set;

public class FindCircle {
    static class Entry {
        Integer num;
        Entry next;

        public Entry(Integer num) {
            this.num = num;
        }
    }

    public static void main(String[] args) {
        Entry entry1 = new Entry(5);
        Entry entry2 = new Entry(3);
        Entry entry3 = new Entry(7);
        Entry entry4 = new Entry(2);
        Entry entry5 = new Entry(6);
        Entry entry6 = new Entry(8);
        Entry entry7 = new Entry(1);
        entry1.next = entry2;
        entry2.next = entry3;
        entry3.next = entry4;
        entry4.next = entry5;
        entry5.next = entry6;
        entry6.next = entry7;
        entry7.next = entry4;

        System.out.println(hasCircle1(entry1));
        System.out.println(hasCircleBest(entry1));
    }

    public static boolean hasCircleBest(Entry head) {
        //time n space 1
        Entry x = head;
        Entry y = head;
        while (x != null && y != null) {
            x = x.next;
            y = y.next;
            if (y!=null)
                y = y.next;
            if (x == y) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasCircle1(Entry head) {
        //time n  space n
        Set<Integer> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head.num))
                return true;
            set.add(head.num);
            head = head.next;
        }
        return false;
    }
}
