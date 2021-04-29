package com.yuzh.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * 一、Stream三个操作步骤
 * 1.创建stream
 * 2.中间操作
 * 3.终止操作
 */
public class TestStreamApi2 {

    List<Employee> employees = Arrays.asList(
            new Employee(1, "zhangsan", 12, 4331.99, Employee.Status.FREE),
            new Employee(2,"lisi",74,4938.99),
            new Employee(3,"wangwu",53,4643.11),
            new Employee(3,"wangwu",53,4643.11),
            new Employee(3,"wangwu",53,4643.11),
            new Employee(3,"wangwu",53,4643.11),
            new Employee(3,"wangwu",53,4643.11),
            new Employee(3,"wangwu",53,4643.11),
            new Employee(4,"zhaoliu",45,7873.43));

    @Test
    public void test7(){
        List<String> list = Arrays.asList("aaa", "bbbb", "cccc", "dddd", "eeee");
        list.stream().sorted().forEach(System.out::println);

        employees.stream().sorted((e1,e2)->{
            if (e1.getAge().equals(e1.getAge())) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return -e1.getName().compareTo(e2.getName());
            }
        }).forEach(System.out::println);
    }

    //中间操作
    @Test
    public void test6(){
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        List list2=new ArrayList();
        list2.add(11);
        list2.add(22);
        list2.add(list);
        System.out.println(list2);
    }

    @Test
    public void test5(){
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        list.stream().map(str->str.toUpperCase())
                .forEach(System.out::println);
        employees.stream().map(Employee::getName)
                .forEach(System.out::println);

        Stream<Stream<Character>> stream = list.stream().map(TestStreamApi2::filterCahracter);
        stream.forEach(s->{
            s.forEach(System.out::println);
        });

        list.stream().flatMap(TestStreamApi2::filterCahracter)
                .forEach(System.out::println);
    }

    public static Stream<Character> filterCahracter(String str) {
        List<Character> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
        }
        return  list.stream();
    }

    @Test
    public void test4(){
        employees.stream().filter(e->e.getAccount()>4500).skip(2)//跳过
                .distinct()//去重
                .forEach(System.out::println);
    }

    @Test
    public void test3() {
        employees.stream().filter(e->e.getAccount()>4500)
                .limit(2).forEach(System.out::println);
    }

    //内部迭代，迭代操作由Stream API完成
    @Test
    public void test1(){
        //中间操作 不会执行任何操作
        Stream<Employee> stream = employees.stream().filter((e) -> e.getAge() > 35);
        //终止操作 一次性执行全部内容，即“惰性求值”
        stream.forEach(System.out::println);
    }

    //外部迭代
    public void test2() {
        Iterator<Employee> it=employees.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

}
