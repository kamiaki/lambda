package com.aki.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Unit test for simple App.
 */
public class AppTest {
    //    Consumer<T> : 消费型接口 void accept(T t);
    @Test
    public void test01() {
        cons(new Consumer<DoSomething>() {
            @Override
            public void accept(DoSomething doSomething) {
                doSomething.dothing();
                System.out.println("我又开始摇滚了");
            }
        });

        cons(x -> {
            System.out.println("我开始摇滚了");
            x.dothing();
        });
    }

    public void cons(Consumer<DoSomething> con) {
        DoSomething doSomething = new DoSomething();
        con.accept(doSomething);
    }


    //    Supplier<T> : 供给型接口 T get();
    @Test
    public void test02() {
        Integer supp = supp(() -> 666 * 2);
        System.out.println(supp);
    }

    public Integer supp(Supplier<Integer> su) {
        System.out.println(su.get());
        return su.get();
    }


    //    Function<T, R> : 函数型接口 R apply(T t);
    @Test
    public void test03() {
        List<Integer> fun = fun(6, (x) -> {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < x; i++) {
                Double random = Math.random() * 100;
                list.add(random.intValue());
            }
            return list;
        });
        //打印
        for (Integer integer : fun) {
            System.out.println(integer);
        }
    }

    public List<Integer> fun(Integer num, Function<Integer, List<Integer>> fun) {
        return fun.apply(num);
    }


//    Predicate<T> : 断言型接口  boolean test(T t);

    @Test
    public void test04() {
        List<String> list = Arrays.asList("23456", "wqew", "sfsd", "yfhfg");
        List<String> pre = pre(list, (x) -> {
            String y = "y";
            return x.contains(y);
        });
        for (String string : pre) {
            System.out.println(string);
        }

        /**
         * 注意:这个地方我使用了上次练习中多个语句和一个语句,这里提醒下,当使用一条语句的时候不可以包含{}和return,而多条语句必须要语法规范,哪怕后面的;也不可以少
         * 否则eclipise会认为语法有错误（我的版本是4.5.1）
         */
        pre(list, (x) -> x.contains("y"));
    }

    public List<String> pre(List<String> list, Predicate<String> s) {
        List<String> list1 = new ArrayList<>();
        for (String string : list) {
            if (s.test(string)) {
                list1.add(string);
            }
        }
        return list1;
    }

    ;
}
