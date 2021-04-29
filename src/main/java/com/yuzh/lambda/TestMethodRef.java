package com.yuzh.lambda;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 * 访求引用：若lambda体中的内容有方法已经实现了，我们可以使用方法引用
 * （可以理解为，方法引用是lambda表达式的另外一种表达形式）
 *
 * 主要有三种语法格式：
 * (注意：
 * 1、lambda体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致)
 * 2、若lambda参数列表中的第一个参数是实例养一方人调用者，而第二个参数是实例方法的参数时，可以使用ClassName::method
 *
 * 二、构造器引用
 * ClassName::new
 *
 * 注意：需要调用的构造器的参数列表要与接口的函数式列表保持一致
 *
 * 对象::实例方法名
 * 类::静态方法名
 * 类::实例方法名
 */
public class TestMethodRef {
    /*数组引用*/
    @Test
    public void test7(){
        Function<Integer, String[]> fun = (x) -> new String[x];
        String[] strs = fun.apply(10);
        System.out.println(strs.length);
        Function<Integer,String[]> fun2=String[]::new;
        String[] strs2 = fun2.apply(20);
        System.out.println(strs2.length);
    }

    /*构造器引用*/
    @Test
    public void test5(){
        Supplier<Employee> sup=()->new Employee();
        //Employee employee = sup.get();
        //构造器引用方式
        Supplier<Employee> sup2=Employee::new;//自动匹配对应的构造器
        Employee employee = sup2.get();
        System.out.println(employee);
    }

    @Test
    public void test6(){
        Function<Integer,Employee> fun=(x)->new Employee(x);
        Function<Integer,Employee> fun2=Employee::new;
        Employee employee = fun2.apply(101);
        System.out.println(employee);
        BiFunction<Integer,Integer,Employee> bf=Employee::new;
    }

    /*类::实例方法名*/
    @Test
    public void test4(){
        BiPredicate<String,String> bp=(x,y)->x.equals(y);//x为调用者，y为方法的参数值

        BiPredicate<String,String> bp2= String::equals;
    }

    /*类::静态方法名*/
    @Test
    public void test3() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        Comparator<Integer> com1= Integer::compare;
    }

    /*对象::实例方法名*/
    @Test
    public void test1(){
        Consumer<String> con=(x)-> System.out.println(x);
        PrintStream ps =System.out;
        Consumer<String> con1=ps::println;
        Consumer<String > con2=System.out::println;
        con2.accept("abcdef");
    }

    @Test
    public void test2(){
        Employee emp = new Employee();
        Supplier<String> sup=()->emp.getName();
        String str=sup.get();
        System.out.println(str);

        Supplier<Integer> sup2=emp::getAge;
        Integer num = sup2.get();
        System.out.println(num);
    }
}
