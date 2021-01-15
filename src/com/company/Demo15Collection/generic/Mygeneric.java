package com.company.Demo15Collection.generic;

public class Mygeneric<E> {
    public void show(E e){
        System.out.println(e);
    }
}

class MyGeneric2{
    public <E> void show(E e){
        System.out.println(e);
    }
}

interface MyGeneric3<E>{
   public void show(E e);
}

class Generic1 implements MyGeneric3<String>{
    @Override
    public void show(String s) {
        System.out.println(s);
    }
}

class Generoc2<E> implements MyGeneric3<E>{

    @Override
    public void show(E e) {
        System.out.println(e);
    }
}