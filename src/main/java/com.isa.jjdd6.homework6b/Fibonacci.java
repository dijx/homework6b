package com.isa.jjdd6.homework6b;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
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