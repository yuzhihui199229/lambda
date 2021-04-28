package com.yuzh.lambda;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 一、Stream三个操作步骤
 * 1.创建stream
 * 2.中间操作
 * 3.终止操作
 */
public class TestStreamApi3 {

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

    /*
    查找与匹配
     allMatch检查是否匹配所有元素
     anyMatch—检查是否至少匹配一个元素
     noneMatch—检查是否没有匹配所有元素
     findFirst返回第一个元素
     findAny—返回当前流中的任意元素
     count—返回流中元素的总个数
    max返回流中最大值
    min—返回流中最小值
    */
    @Test
    public void test1() {
        boolean b = employees.stream().allMatch(e -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b);

        boolean b1 = employees.stream().anyMatch(e -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b1);

        boolean b2 = employees.stream().noneMatch(employee -> employee.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b2);

        Optional<Employee> op = employees.stream().sorted((e1, e2) -> Double.compare(e1.getAccount(), e2.getAccount())).findFirst();
        System.out.println(op.get());

        Optional<Employee> op2 = employees.parallelStream()
                .filter(e -> e.getStatus().equals(Employee.Status.FREE)).findAny();
        System.out.println(op2.get());
    }

    @Test
    public void test2() {
        Long count = employees.stream().count();
        System.out.println(count);

        Optional<Employee> op1 = employees.stream().max((e1, e2) ->
                Double.compare(e1.getAccount(), e2.getAccount())
        );
        System.out.println(op1.get());

        Optional<Double> op2 = employees.stream().map(Employee::getAccount).min(Double::compare);
        System.out.println(op2.get());

    }

    @Test
    public void test3(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);

        Optional<Double> op = employees.stream().map(Employee::getAccount).reduce(Double::sum);
        System.out.println(op.get());
    }

    @Test
    public void test4(){
        employees.stream().map(Employee::getName).collect(Collectors.toList()).forEach(System.out::println);

        employees.stream().map(Employee::getName).collect(Collectors.toSet()).forEach(System.out::println);

        employees.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new)).forEach(System.out::println);
    }

    @Test
    public void test5(){
        Long count = employees.stream().collect(Collectors.counting());
        System.out.println(count);

        Double avg = employees.stream().collect(Collectors.averagingDouble(Employee::getAccount));
        System.out.println(avg);

        //总和
        Double sum = employees.stream().collect(Collectors.summingDouble(Employee::getAccount));
        System.out.println(sum);

        //最大值
        Optional<Employee> max = employees.stream().collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getAccount(), e2.getAccount())));
        System.out.println(max.get());

        //最小值
        Optional<Double> min = employees.stream().map(Employee::getAccount).collect(Collectors.minBy(Double::compare));
        System.out.println(min.get());
    }

    /*分组*/
    @Test
    public void test6(){
        Map<Employee.Status, List<Employee>> map = employees.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);
    }

    //多级分组
    @Test
    public void test7(){
        Map<Employee.Status, Map<Object, List<Employee>>> map = employees.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(e -> {
            if (e.getAge() > 46) {
                return "中年";
            } else {
                return "老年";
            }
        })));
        System.out.println(map);
    }

    @Test
    public void test8(){
        Map<Boolean, List<Employee>> map = employees.stream().collect(Collectors.partitioningBy(e -> e.getAccount() > 6000));
        System.out.println(map);
    }

    @Test
    public void test9(){
        DoubleSummaryStatistics dss = employees.stream().collect(Collectors.summarizingDouble(Employee::getAccount));
        System.out.println(dss.getSum());
        System.out.println(dss.getAverage());
        System.out.println(dss.getCount());
    }

    @Test
    public void test10(){
        String collect = employees.stream().map(Employee::getName).collect(Collectors.joining(","));
        System.out.println(collect);
    }
}
