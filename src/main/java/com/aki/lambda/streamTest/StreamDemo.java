package com.aki.lambda.streamTest;

import com.aki.lambda.UserTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<UserTest> users = new ArrayList<UserTest>();
        users.add(new UserTest("20", "张三"));
        users.add(new UserTest("22", "李四"));
        users.add(new UserTest("10", "王五"));


        Stream<UserTest> stream = users.stream();
        Stream<UserTest> userStream = stream.filter(p -> Integer.valueOf(p.getAge()) > 20);//过滤年龄大于20的
        userStream.forEach((UserTest user) -> System.out.println(user.toString()));
        List<UserTest> collect = userStream.collect(Collectors.toList());
        collect.forEach(System.out::println);
        test();
        test2();
    }


    public static void test() {
        List<UserTest> users = new ArrayList<UserTest>();
        users.add(new UserTest("20", "张三"));
        users.add(new UserTest("22", "李四"));
        users.add(new UserTest("10", "王五"));


        Stream<UserTest> stream = users.stream();
        //所有的年龄大于20岁的User对象，转换为字符串50对象。现在流中只有字符串对象了。
        Stream<UserTest> userTestStream = stream.filter((UserTest user) -> Integer.valueOf(user.getAge()) > 20);
        Stream<String> stringStream = userTestStream.map((UserTest user) -> {
            return user.getName();
        });
        stringStream.forEach((String str) -> System.out.println(str));
    }

    public static void test2() {
        List<UserTest> users = new ArrayList<UserTest>();
        users.add(new UserTest("20", "张三"));
        users.add(new UserTest("22", "李四"));
        users.add(new UserTest("10", "王五"));

        Stream<UserTest> stream = users.stream();
        Stream<UserTest> count = stream.filter((UserTest user) ->  Integer.valueOf(user.getAge()) >= 20);
        Stream<String> stringStream = count.map((UserTest user) -> {
            return "50";
        });
        long count1 = stringStream.count();//返回流中元素的个数。
        System.out.println(count);
    }
}
