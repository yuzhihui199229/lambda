package com.yuzh.lambda;

import org.junit.Test;

import java.time.Year;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * lambada
 * 基础语法，->
 * 将lambda表达式拆分为两个部分
 * 左侧：参数列表
 * 右侧：所需要执行的功能
 */
public class LambdaTest {
    int num = 0;

    @Test
    public void test1() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world" + num);
            }
        };

        Runnable r1 = () -> System.out.println("hello world" + num);
        r1.run();
    }

    @Test
    public void test2() {
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("lambda");
    }

    public void test3() {
        Comparator<Integer> com = (x, y) -> {
            return Integer.compare(x, y);
        };
    }

    @Test
    public void test4() {
        Comparator<Integer> com = (x, y) ->Integer.compare(x, y);
    }

    @Test
    public void test5() {
        List<String> list = new ArrayList<>();
    }

    @Test
    public void test6() {
        Integer num = oper(100, x -> x * x);
        System.out.println(num);
    }

    private Integer oper(Integer num, MyFun myFun) {
        return myFun.getValue(num);
    }
}
