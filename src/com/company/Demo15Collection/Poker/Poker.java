package com.company.Demo15Collection.Poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/*
    这个程序模仿了斗地主发牌的过程
        1、  首先需要一副牌一共54张，两张王牌
        2、  52张拍分为花色♥，♦，♣，♠， 数字2A J, Q, K, 10,9,8,7,6,5,4,3
        3、  洗牌
        4、  给三位玩家发牌，并留下三张牌作为底牌
 */
public class Poker {
    public static void main(String[] args) {
        ArrayList<String> poker = new ArrayList<>();
        ArrayList<String> HuaSe = new ArrayList<>();
        HuaSe.add("♠");
        HuaSe.add("♥");
        HuaSe.add("♦");
        HuaSe.add("♣");
        ArrayList<String> ShuZi = new ArrayList<>();
        ShuZi.add("J");
        ShuZi.add("Q");
        ShuZi.add("K");
        ShuZi.add("A");
        for (int i = 2; i <=10; i++) {
            ShuZi.add(i+"");
        }


        for(int i=0; i<HuaSe.size();i++){
            for (int j = 0; j <ShuZi.size() ; j++) {
                //System.out.print(HuaSe.get(i)+ShuZi.get(j)+"    ");
                poker.add(HuaSe.get(i)+ShuZi.get(j));
            }
            //System.out.println();
        }
        poker.add("大王");
        poker.add("小王");
        Collections.shuffle(poker);
        System.out.println(poker);
        List<String> player1 = new ArrayList<>();
        List<String> player2 = new ArrayList<>();
        List<String> player3 = new ArrayList<>();
        List<String> dipai = new ArrayList<>();

        for (int i = 0; i <54 ; i++) {
            if(i>=51){
                dipai.add(poker.get(i));
            }else if(i%3==0){
                player1.add(poker.get(i));
            }else if(i%3==1){
                player2.add(poker.get(i));
            }else{
                player3.add(poker.get(i));
            }
        }
        System.out.println(player1);
        System.out.println(player2);
        System.out.println(player3);
        System.out.println(dipai);
    }

}
