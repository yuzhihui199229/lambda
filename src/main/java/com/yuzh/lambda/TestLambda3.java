package com.yuzh.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class TestLambda3 {
    private void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    @Test
    public void test() {
        happy(1993,money-> System.out.println("我们消费了kkkk"+money));
    }
}
