package com.aki.lambda.shuangMaoHao;

import com.aki.lambda.DoSomething;

import java.util.ArrayList;
import java.util.function.Consumer;

public class TestMain {
    public static void main(String[] args) {
        TestFunIF testFunIF = i -> System.out.println(i);
        testFunIF.aaaaa("123");
        TestFunIF testFunIF2 = aaa::outSay;
        testFunIF2.aaaaa("333");
        TestFunIF testFunIF3 = new bbb()::outSay;
        testFunIF3.aaaaa("4444");

        testtest(x -> x.outSay("aaaaaa"));
    }

    public static void testtest(Consumer<bbb> con){
        con.accept(new bbb());
    }
}

class aaa{
    public static void outSay(String msg){
        System.out.println(msg);
    }
}
class bbb{
    public  void outSay(String msg){
        System.out.println(msg);
    }
}
