package com.company;

public class StaticBlock {
    public static  void main (String[] args){
        Person p = new Person();
        Person p1 = new Person(23);
    }
}

class Person {
    private String name;
    private int age;

    static {
        System.out.println("静态代码块被执行了");
    }

    {
        System.out.println("构造代码块被执行了");
    }

    Person(){
        System.out.println("Person的无参构造函数执行");
    }

    Person(int age){
        this.age = age;
        System.out.println("Person（age)带参数的构造函数被调用");
    }

}
