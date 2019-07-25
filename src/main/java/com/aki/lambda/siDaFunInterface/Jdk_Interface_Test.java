package com.aki.lambda.siDaFunInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Jdk_Interface_Test {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    //Consumer<T> 消费型接口：void accept(T t);
    public static void test1() {
        happy(1000, (m) -> System.out.println("喜欢大宝剑，消费：" + m + "元"));
    }

    public static void happy(double money, Consumer<Double> con) {
        con.accept(money);//传入一个money，没有返回值，直接消费
    }

    //Supplier<T> 供给型接口: 需求：产生指定个数的整数，并放入集合中：   T get();
    private static void test2() {
        List<Integer> numList = getNumList(3, () -> (int) (Math.random() * 100));
        for (Integer num : numList) {
            System.out.println(num);
        }
    }

    private static List<Integer> getNumList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = sup.get();//n为返回值，返回一个整数，以上来说，就是返回一个随机数，添加到list，然后遍历list
            list.add(n);
        }
        return list;
    }

    //Function<T,R> 函数型接口:R apply(T t);
    private static void test3() {
        String newStr = strHandler("\t\t\t 啦啦啦德玛西亚  ", (str) -> str.trim());
        System.out.println(newStr);

        String subStr = strHandler("无与伦比，为杰沉沦", (str) -> str.substring(5, 9));
        System.out.println(subStr);
    }

    private static String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);//传入一个字符串，有返回值。
    }

    //Predicate<T> 断言型接口： boolean test(T t);
    private static void test4() {
        List<String> list = Arrays.asList("Hello", "jj", "Lambda", "www", "ok");
        List<String> strList = filterStr(list, s -> s.startsWith("L"));
        List<String> list2 = filterStr(list, new Predicate<String>() {
            @Override
            public boolean test(String t) {
                // TODO 自动生成的方法存根
                return t.length() > 3;//((String)t).length()>3;
            }
        });
        for (String string : strList) {
            System.out.println(string);
        }
    }

    //需求：将满足条件的字符串，放入集合中
    private static List<String> filterStr(List<String> list, Predicate<String> pre) {
        List<String> strList = new ArrayList<>();
        for (String str : list) {
            if (pre.test(str)) {
                strList.add(str);
            }
        }
        return strList;
    }
}