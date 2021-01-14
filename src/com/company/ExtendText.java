package com.company;

public class ExtendText {
    public static void main(String[] args)
    {
        new Student("小明",23).study();
        new Worker("小李",45).work();
    }
}
class Person1{
    private int age;
    private String name;

    Person1(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
class Student extends Person1 {
    // Student类的构造函数
    Student(String name, int age) {
        // 使用super关键字调用父类构造函数，进行相应的初始化动作
        super(name, age);
    }
    public void study() {// Studnet中特有的方法
        System.out.println(this.getName() + "同学在学习");
    }
}
class Worker extends Person1 {
    Worker(String name, int age) {
        // 使用super关键字调用父类构造函数，进行相应的初始化动作
        super(name, age);
    }
    public void work() {// Worker 中特有的方法
        System.out.println(this.getName() + "工人在工作");
    }
}