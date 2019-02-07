package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WarRunner {

    public static void main(String[] args) {




          final String[] RANKS =
                {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};


          final String[] SUITS =
                {"spades", "hearts", "diamonds", "clubs"};


          final int[] POINT_VALUES =
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0};

        Deck deck = new Deck(RANKS, SUITS, POINT_VALUES);
        System.out.println(deck);
        deck.shuffle();

        List<Card> list1 = new ArrayList<>();
        List<Card> list2 = new ArrayList<>();

        for (int i=0;i<25;i++)
        {
            list1.add(deck.returncard(i));
            System.out.println(deck.returncard(i));
        }
        System.out.println("zzzzzzzzz");
        for (int i=26;i<deck.size();i++)
        {
            list1.add(deck.returncard(i));
            System.out.println(deck.returncard(i));
        }

        System.out.println(Arrays.toString(list1.toArray()));
        System.out.println(Arrays.toString(list2.toArray()));
        deal(list1, list2);
        System.out.println(Arrays.toString(list1.toArray()));
        System.out.println(Arrays.toString(list2.toArray()));

    }
    public static void deal(List<Card> a, List<Card> b)
    {
        Card temp1 = a.get(0);
        Card temp2 = b.get(0);

        List<Card> temp3 = new ArrayList<>();
        List<Card> temp4 = new ArrayList<>();

        if (temp1.pointValue()==temp2.pointValue())
        {
            temp3.add(temp1);
            temp4.add(temp2);

            a.remove(0);
            b.remove(0);

            temp3.add(a.get(0));
            temp4.add(b.get(0));

            a.remove(0);
            b.remove(0);

            temp3.add(a.get(0));
            temp4.add(a.get(0));

            a.remove(0);
            b.remove(0);

            if (temp3.get(2).pointValue()==temp4.get(2).pointValue())
            {
                a.addAll(temp3);
                b.addAll(temp4);
            }

            if (temp3.get(2).pointValue()>temp4.get(2).pointValue())
            {
                a.addAll(temp3);
                a.addAll(temp4);
            }

            if (temp3.get(2).pointValue()<temp4.get(2).pointValue())
            {
                b.addAll(temp3);
                b.addAll(temp4);
            }

        if (temp1.pointValue()>temp2.pointValue())
        {
            a.add(temp2);
            a.add(temp1);
            b.remove(0);
        }

        if (temp1.pointValue()<temp2.pointValue())
        {
            b.add(temp2);
            b.add(temp1);
            a.remove(0);
        }

    }

}}
