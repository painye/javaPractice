package com.company;

public class Lazyman {
    public static  void main(String[] args){
        Single s1 = Single.getInstance();
        Single s2 = Single.getInstance();
        System.out.println(s1==s2);

    }
}
/*hugryman
class Single{
    private Single(){
        System.out.println("Single hungry man");
    };
    private static Single instance= new Single();

    public  static Single getInstance () {
        return instance;
    }
}
*/

//lazyMan
class Single{
    private Single(){
        System.out.println("LazyMan SIngle");
    }

    private static Single instance = null;

    public static Single getInstance(){
        if(instance == null)    instance = new Single();
        return instance;
    }
}