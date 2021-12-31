package kh1230;

import java.util.ArrayList;
import java.util.Collections;

public class CardGame {
    public static void main(String[] args) {
        //Deck 객체를 생성하고
        //Deck 기본 생성자를 실행하면, for문을 활용해 카드 정보들이 저장됨
        Deck deck = new Deck();
        //객체를 활용해 suffle 메소드를 실행함, 랜덤으로 저장된 값 중 하나를 획득함
        deck.shuffle();
        //카드를 획득하는 Player 객체 생성
        Player p1 = new Player(); Player p2 = new Player();
        //getCard 메소드를 실행해 덱에서 카드 정보를 ArrayList 객체에 저장함
        //저장 후에 deal 메소드를 실행해 획득한 카드 데이터를 제거하여 중복을 피하는 것 같다
        p1.getCard(deck.deal()); p2.getCard(deck.deal());
        //저장된 데이터를 출력함
        p1.showCard(); p2.showCard();
    }
}

class Card {
    String suit;
    String number;
    public Card(String suit, String number){
        this.suit = suit;
        this.number = number;
    }
    //Card 객체에 저장된 데이터를 표현하기 위해 toString 메소드를 활용
    @Override
    public String toString(){
        return "(" + suit + " " + number + ")";
    }
}

class Deck {
    ArrayList<Card> deck = new ArrayList<Card>();
    String[] suit = {"CLUB", "DIAMOND", "HEART", "SPACE"};
    String[] number = {"1","2","3","4","5","6","7","8","9","10","J","Q","K","A"};

    public Deck() {
        for (int i=0; i< suit.length;i++)
            for (int j =0; j< number.length;j++)
                deck.add(new Card(suit[i], number[j]));
    }
    public void shuffle(){
        //Collections.shuffle : 저장된 데이터들을 랜덤으로 출력함
        Collections.shuffle(deck);
    }
    public Card deal(){
        return deck.remove(0);
    }//remove : 해당 인덱스의 값을 삭제하고 반환
}

class Player {
    ArrayList<Card> list = new ArrayList<Card>();

    public void getCard(Card suffle) {
        list.add(suffle);
    }

    public void showCard() {
        System.out.println(list.get(0));
    }
}