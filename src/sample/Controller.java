package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    public List<Card> list1 = new ArrayList<>();
    public List<Card> list2 = new ArrayList<>();

    @FXML private ImageView img1;
    @FXML private ImageView img2;
    @FXML private ImageView img7;
    @FXML private ImageView img4;
    @FXML private ImageView img5;
    @FXML private ImageView img6;

    public void draw()
    {
        Image image = new Image("hmm.jpg");
        img1.setImage(image);
        img2.setImage(image);
        img7.setImage(image);
        img4.setImage(image);
        img5.setImage(image);
        img6.setImage(image);
    }

   public void runner()
   {
    final String[] RANKS =
            {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};


    final String[] SUITS =
            {"spades", "hearts", "diamonds", "clubs"};


    final int[] POINT_VALUES =
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

    Deck deck = new Deck(RANKS, SUITS, POINT_VALUES);
        deck.shuffle();

    //List<Card> list1 = new ArrayList<>();
    //List<Card> list2 = new ArrayList<>();

        for (int i=0;i<25;i++)
    {
        list1.add(deck.returncard(i));
    }
        for (int i=26;i<deck.size();i++)
    {
        list2.add(deck.returncard(i));
    }


        System.out.println(" ");
        System.out.println("list 1");
        for (Card num : list1) {
        System.out.println(num);
    }
        System.out.println("list 1");


        System.out.println(" ");
        System.out.println("list 2");
        for (Card num2 : list2) {
        System.out.println(num2);
    }
        System.out.println("List 2 ");
        System.out.println(" ");






}
    public String imageFileName(Card c, boolean isSelected) {
        String str = "cards/";
        if (c == null) {
            return "cards/back1.GIF";
        }
        str += c.rank() + c.suit();
        if (isSelected) {
            str += "S";
        }
        str += ".GIF";
        return str;
    }

    public  void deal()
    {

        Card temp1 = list1.get(0);
        Card temp2 = list2.get(0);

        String player1card = imageFileName(temp1,true);
        String player2card = imageFileName(temp2,true);
        Image image1 = new Image(player1card);
        Image image2 = new Image(player2card);

        img2.setImage(image1);
        img5.setImage(image2);
        list1.remove(0);
        list2.remove(0);

        List<Card> temp3 = new ArrayList<>();
        List<Card> temp4 = new ArrayList<>();

        if (temp1.pointValue() == temp2.pointValue()) {
            temp3.add(temp1);
            temp4.add(temp2);

            temp3.add(list1.get(0));
            temp4.add(list2.get(0));

            list1.remove(0);
            list2.remove(0);

            temp3.add(list1.get(0));
            temp4.add(list2.get(0));

            list1.remove(0);
            list2.remove(0);

            if (temp3.get(2).pointValue() == temp4.get(2).pointValue()) {
                list1.addAll(temp3);
                list2.addAll(temp4);
            }

            if (temp3.get(2).pointValue() > temp4.get(2).pointValue()) {
                list1.addAll(temp3);
                list1.addAll(temp4);
            }

            if (temp3.get(2).pointValue() < temp4.get(2).pointValue()) {
                list2.addAll(temp3);
                list2.addAll(temp4);
            }
        }
            if (temp1.pointValue() > temp2.pointValue()) {
                list1.add(temp2);
                list1.add(temp1);

                System.out.println("player 1 wins");
            }

            if (temp1.pointValue() < temp2.pointValue()) {
                list2.add(temp2);
                list2.add(temp1);

                System.out.println("player 2 wins");

            }


        if (list1.size()<=0)
        {
            System.out.println("Player 2 Wins the Game!");
        }
        if (list2.size()<=0)
        {
            System.out.println("Player 1 Wins the Game!");
        }

        /*for (Card num : list1) {
            System.out.println(num);
        }

        System.out.println("List 1 ");
        System.out.println(" ");

        for (Card num2 : list2) {
            System.out.println(num2);
        }
        */
    }
}







