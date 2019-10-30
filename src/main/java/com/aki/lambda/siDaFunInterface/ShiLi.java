package com.aki.lambda.siDaFunInterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ShiLi {
    public static void main(String[] args) {
        consumerTest();
    }

    //Consumer
    public static void consumerTest(){
        //accept
        Consumer<Integer> square = x -> System.out.println("print square : " + x * x);
        square.accept(2);
        square.accept(3);

        //andThen
        Consumer<Integer> consumer1 = x -> System.out.println("first x : " + x);
        Consumer<Integer> consumer2 = x -> {
            System.out.println("second x : " + x);
         };
        Consumer<Integer> consumer3 = x -> System.out.println("third x : " + x);
        consumer1.andThen(consumer2).andThen(consumer3).accept(1);
    }

    //用supplier 实例化对象
    public static void shiliObject(){
        Supplier<test> testSupplier = test::new;
        test test = testSupplier.get();
    }

    //func
    public static void funtest(){
        Function<Integer, Integer> name = e -> e * 2;
        Function<Integer, Integer> square = e -> e * e;
        int value = name.andThen(square).apply(3);
        System.out.println("andThen value=" + value);
        int value2 = name.compose(square).apply(3);
        System.out.println("compose value2=" + value2);
        //返回一个执行了apply()方法之后只会返回输入参数的函数对象
        Object identity = Function.identity().apply("huohuo");
        System.out.println(identity);
    }

    //断言
    public static void test(){
        Predicate<Integer> predicate0 = x -> {
            if(x == 0){
                return true;
            }else {
                return false;
            }
        };
        Predicate<Integer> predicate1 = x -> {
            if(x == 1){
                return true;
            }else {
                return false;
            }
        };

        boolean test = predicate0.test(0);
        System.out.println(test);

        Predicate<Integer> negate = predicate0.negate();
        boolean test1 = negate.test(0);
        System.out.println(test1);

        boolean test2 = predicate0.and(predicate1).test(0);
        System.out.println(test2);
        boolean test3 = predicate0.or(predicate1).test(0);
        System.out.println(test3);

    }
}
