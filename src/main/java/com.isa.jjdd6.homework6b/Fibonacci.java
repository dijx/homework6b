package com.isa.jjdd6.homework6b;

import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class Fibonacci {

    protected List<Long> count(int word) {

        List<Long> fibOut = new ArrayList<>();
        Long t0 = 0L, t1 = 1L;
        fibOut.add(t0);

        if (word == 0) {
            return fibOut;
        }

        fibOut.add(t1);

        if (word == 1) {
            return fibOut;
        }

        for (int i = 2; i <= word; ++i) {

            Long sum = t0 + t1;
            fibOut.add(sum);
            t0 = t1;
            t1 = sum;
        }
        return fibOut;
    }
}