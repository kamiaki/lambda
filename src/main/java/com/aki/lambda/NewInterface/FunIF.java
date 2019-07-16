package com.aki.lambda.NewInterface;//形同点：
//1.都是抽象类型；
//2.都可以有实现方法（以前接口不行）；
//3.都可以不需要实现类或者继承者去实现所有方法，（以前不行，现在接口中默认方法不需要实现者实现）++
//不同点
//++1.抽象类不可以多重继承，接口可以（无论是多重类型继承还是多重行为继承）；
//2.抽象类和接口所反映出的设计理念不同。其实抽象类表示的是"is-a"关系，接口表示的是"like-a"关系；
//3.接口中定义的变量默认是public static final 型，且必须给其初值，所以实现类中不能重新定义，也不能改变其值；抽象类中的变量默认是 default 型，其值可以在子类中重新定义，也可以重新赋值。++


@FunctionalInterface
public interface FunIF {
    void say();

    default void add(int a, int b) {
        System.out.println("我是接口的默认方法1中的代码");
        System.out.println(a + b);
    }
}
