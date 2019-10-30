package com.aki.lambda.siDaFunInterface;

import java.util.function.Supplier;

public class ShiLi {
    //用supplier 实例化对象
    public static void main(String[] args) {
        Supplier<test> testSupplier = test::new;
        test test = testSupplier.get();
    }
}
