package com.aki.lambda.siDaFunInterface;


import com.aki.lambda.DoSomething;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class test {

    public static void sss(Supplier<Integer> aaa){
        System.out.println(aaa.get() * 10);
    }

    public static void main(String[] args) {
        //函数是接口的作用就是将 需要用到的方法 参数 或 判断 剥离出来在外头做
        sss(() -> 2);
        System.out.println("-----------");
        System.out.println("-----------");

        // Supplier<T> : 供给型接口 T get();
        Supplier<Integer> su = () -> 666 * 2;
        Integer integer = su.get();
        System.out.println(integer);

        // Function<T, R> : 函数型接口 R apply(T t);
        Function<Integer, List<Integer>> fun = (x) -> {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < x; i++) {
                list.add((int) (Math.random() * 100));
            }
            return list;
        };
        List<Integer> apply = fun.apply(6);
        System.out.println(apply.toString());

        // Consumer<T> : 消费型接口 void accept(T t);
        Consumer<DoSomething> con = x -> x.dothing();
        con.accept(new DoSomething());

        // Predicate<T> : 断言型接口  boolean test(T t);
        Predicate<String> s = (x) -> {
            String y = "y";
            return x.contains(y);
        };
        List<String> list = Arrays.asList("23456", "wqew", "sfsd", "yfhfg");
        list.forEach(x -> System.out.println(x));
        List<String> afterList = new ArrayList<>();
        list.forEach(x -> {
            if (s.test(x)) {
                afterList.add(x);
            }
        });
        afterList.forEach(System.out::println);
    }

}
