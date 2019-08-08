package com.aki.lambda.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test4da {

    public static void main(String[] args) {
        panduan(x -> {
           x.add("aas");
           x.add("fewfew");
           x.add("fdswe");
           return true;
        });

        String gongji = gongji(2, () -> {
            return "3";
        });
        System.out.println(gongji);

        List hanshu = hanshu(5, x -> {
            List list = new ArrayList();
            for (int i = 0; i < x; i++) {
                list.add(String.valueOf(Math.random() * 100));
            }
            return list;
        });
        System.out.println(hanshu);


        xiaofei(hanshu,x ->{
            x.forEach(System.out::println);
        });


        List<Student> l = new ArrayList<>();

        l.add(new Student(1,12,"12 1"));
        l.add(new Student(2,18,"18 2"));
        l.add(new Student(3,22,"22 3"));
        Stream <Student> stream = l.stream();
        Stream<Student> stream1 = stream.filter(student -> student.getAge() >= 18);

//        如果用完这个方法 stream1 里面的值就没了
//        List<Student> collect = stream1.collect(Collectors.toList());
//        System.out.println("list");
//        collect.forEach(System.out::println);

//        如果用完这个方法 stream1 里面的值就没了
//        Stream<String> stringStream = stream1.map(stu -> {
//            return stu.getName();
//        });
//        System.out.println("map");
//        stringStream.forEach(x -> System.out.println(x));

        Stream<Student> stream2 = stream1.filter(student -> student.getId() > 2);
        System.out.println("count");
        System.out.println(stream2.count());

    }

    public static void panduan( Predicate<List> predicate){
        List str= new ArrayList();
         if(predicate.test(str)){
            System.out.println(str);
        }
    }

    public static String gongji(Integer i,Supplier<String> supplier){
        return String.valueOf(i * Integer.valueOf(supplier.get()));
    }
    public static List hanshu(int a, Function<Integer,List<String>> function){
        return function.apply(a);
    }

    public static void xiaofei(List list,Consumer<List> consumer){
        consumer.accept(list);
    }


}
class Student{
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Student(Integer id, Integer age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Integer id;
    private Integer age;
    private String name;
}