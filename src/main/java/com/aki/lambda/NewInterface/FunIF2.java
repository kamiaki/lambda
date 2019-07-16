package com.aki.lambda.NewInterface;

public interface FunIF2 {
    default void add(int a, int b) {
        System.out.println("我是接口的默认方法1中的代码 *");
        System.out.println(a * b);
    }
}
