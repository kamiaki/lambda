package com.aki.lambda.forEach;

import com.aki.lambda.UserTest;
import java.util.ArrayList;
import java.util.List;

public class Demo3 {
    //    迭代器
    public static void main(String[] args) {
        List<UserTest> list = new ArrayList<>();
        list.add(new UserTest("aaa", "11"));
        list.add(new UserTest("bb", "22"));
        list.add(new UserTest("cccc", "33"));
        list.add(new UserTest("d", "44"));
        list.forEach((user) -> System.out.println(user.getName()));
    }
}