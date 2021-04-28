package com.yuzh.lambda;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 一、Stream三个操作步骤
 * 1.创建stream
 * 2.中间操作
 * 3.终止操作
 */
public class TestStreamApi4 {
    @Test
    public void test1(){
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5};
        Arrays.stream(nums).map(x->x*x).forEach(System.out::println);
    }

    List<Employee> employees = Arrays.asList(
            new Employee(1, "zhangsan", 12, 4331.99, Employee.Status.FREE),
            new Employee(2, "lisi", 74, 4938.99, Employee.Status.BUSY),
            new Employee(3, "wangwu", 53, 4643.11, Employee.Status.VOCATION),
            new Employee(3, "wangwu", 53, 4643.11, Employee.Status.VOCATION),
            new Employee(3, "wangwu", 53, 4643.11, Employee.Status.FREE),
            new Employee(3, "wangwu", 53, 4643.11, Employee.Status.FREE),
            new Employee(3, "wangwu", 53, 4643.11, Employee.Status.BUSY),
            new Employee(3, "wangwu", 53, 4643.11, Employee.Status.FREE),
            new Employee(4, "zhaoliu", 45, 7873.43, Employee.Status.VOCATION));

    @Test
    public void test2(){
        Optional<Integer> count = employees.stream().map(e -> 1).reduce(Integer::sum);
        System.out.println(count.get());
    }
}
