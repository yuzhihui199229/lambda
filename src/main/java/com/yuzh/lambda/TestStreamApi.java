package com.yuzh.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 一、Stream三个操作步骤
 * 1.创建stream
 * 2.中间操作
 * 3.终止操作
 */
public class TestStreamApi {
    //创建Stream
    @Test
    public void test1(){
        //1.可以通过Collection系列集合提供的stream()或parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        //2.通过arrays中的静态方法stream()获取数组流
        Employee[] emps=new Employee[10];
        Stream<Employee> stream2= Arrays.stream(emps);
        //3.通过Stream类中的静态方法of()
        Stream<String> stream3 = Stream.of("aa", "bb", "cc", "dd");
        //4.创建无限流
        //迭代
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.limit(10).forEach(System.out::println);
        //生成
        Stream.generate(()->Math.random())
                .limit(5)
                .forEach(System.out::println);
    }
}
