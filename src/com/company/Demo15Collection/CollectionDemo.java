package com.company.Demo15Collection;
/*
    collection的各种方法，他是所有集合的根，是一个接口
        public interface Collection<E> extends Iterable<E>
    该集合中有7个方法
        1   public boolean add(E e)
        2   public boolean remove(E e)
        3   public boolean contains(E e)
        4   public boolean isEmpty(E e)
        5   public int size(E e)
        6   public Object[] toArray(E e)
        7   public void clear(E e)
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {
    public static void main(String[] args) {
        Collection<String> col = new ArrayList<String>();

        System.out.println(col);
        col.add("1");
        col.add("2");
        col.add("3");
        col.add("4");
        col.add("5");
        System.out.println(col);
        col.remove("2");
        col.remove("4");
        System.out.println(col);
        System.out.println(col.contains("1"));
        System.out.println(col.contains("2"));
        System.out.println(col.size());
        System.out.println(col.isEmpty());
        System.out.println(col.toArray().toString());
        col.clear();
        System.out.println(col);
        System.out.println(col.isEmpty());
    }
}
