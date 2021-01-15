package com.company.Demo15Collection.generic;

import sun.net.www.content.text.Generic;

public class GenericTest {
    public static void main(String[] args) {
        //自定义泛型类的实例化，随着创建对象确定泛型
        Mygeneric<String> ge =new Mygeneric<>();
        ge.show("hello");

        Mygeneric<Integer> ge2 = new Mygeneric<>();
        ge2.show(1);

        //自定义泛型方法，随着方法的调用确定泛型
        MyGeneric2 ge3 = new MyGeneric2();
        ge3.show("hello");

        MyGeneric2 ge4 = new MyGeneric2();
        ge4.show(1);

        //自定义泛型接口,第一种使用方法
        Generic1 ge5 = new Generic1();
        ge5.show("hello");

        //自定义泛型接口，第二种使用方法
        Generoc2<String> ge6=new Generoc2<>();
        ge6.show("hello");
        Generoc2<Integer> ge7=new Generoc2<>();
        ge7.show(3);



    }
}
