package com.aki.lambda.NewInterface;

public class FunIFImpl implements FunIF,FunIF2 {
    @Override
    public void say() {
        System.out.println("say");
    }

    @Override
    public void add(int a, int b) {
        System.out.println(a-b);
    }
}
