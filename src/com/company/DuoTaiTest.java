package com.company;

public class DuoTaiTest {
    public static void main (String[] args){
        Mouse m=new Mouse();
        KeyBoard k = new KeyBoard();
        NoteBook n = new NoteBook();
        n.run();
        n.UseUSB(m);
        n.UseUSB(k);

        Zi f=new Zi();
        f.show();
        System.out.println(f.num);

        int i=4;
        Super d = new Demo1("A");
        System.out.println(d.i);
    }
}

interface USB{
    public abstract void open();
    public abstract void close();
}

class Mouse implements USB{
    public void open(){
        System.out.println("open mouse ");
    }

    public  void close(){
        System.out.println("close mouse");
    }
}

class KeyBoard implements  USB{
    public void open(){
        System.out.println("open KeyBoard");
    }

    public  void close(){
        System.out.println("close KeyBoard");
    }
}

class NoteBook{
    public void run(){
        System.out.println("the notebook is running");
    }

    public void UseUSB(USB u){
        if(u!=null){
            u.open();
            u.close();
        }
    }

}


class Fu{
    int num = 5;
    void show(){
        System.out.println("Fu show "+num);// this.num
    }
}
class Zi extends Fu{
    int num = 6;
}

class Super
{
    int i=0;
    public Super(String a)
    {
        System.out.println("A");
        i=1;
    }
    public Super()
    {
        System.out.println("B");
        i+=2;
    }
}
class Demo1 extends Super {
    public Demo1(String a) {
        System.out.println("C");
        i += 5;
    }
}