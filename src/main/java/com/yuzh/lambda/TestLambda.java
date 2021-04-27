package com.yuzh.lambda;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestLambda {
    List<Employee> list = Arrays.asList(
            new Employee(1, "zhangsan", 12, 4331.99),
            new Employee(2,"lisi",74,4938.99),
            new Employee(3,"wangwu",53,4643.11),
            new Employee(4,"zhaoliu",45,7873.43));
    @Test
    public void test1() {

        Collections.sort(list,(e1,e2)->{
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return -Integer.compare(e1.getAge(),e2.getAge());
            }
        });

        for (Employee employee : list) {
            System.out.println(employee.toString());
        }
    }

    private String strHandler(String str, MyFunction mf) {
        return mf.getValue(str);
    }

    @Test
    public void test2() {
        String orig="fdsfd fdsf fdserw";
        String s = strHandler(orig, str -> str.toUpperCase());
        System.out.println(s);
        String s1 = strHandler(orig, str -> str.trim());
        System.out.println(s1);
    }
}
