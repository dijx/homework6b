package com.isa.jjdd6.homework6b;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

     protected List<Integer> count(int word) {

        List<Integer> fibOut = new ArrayList<>();

        int t1 = 0, t2 = 1;

        for (int i = 1; i <= word; ++i) {

            int sum = t1 + t2;
            fibOut.add(sum);
            t1 = t2;
            t2 = sum;
        }
        return fibOut;
    }
}