package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        for(int i=6;  i>0 ; i--){
            for(int j=1; j<=12; j++){
                if(i==j ||j==12-i){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for(int i=2;i<=6;i++){
            for(int j=1; j<=12; j++){
                if(i==j ||j==12-i){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
