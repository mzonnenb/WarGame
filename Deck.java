//Michael Zonnenberg CS110
//Representation of a Deck of cards

import java.util.Random;

public class Deck extends Card
{
   
   public final static int NUM_CARDS = 52; // number of cards in deck
   private Card [] deck;                   //collection of cards
   private int ct;                         //current number of cards in deck   
   
   //Constucts ordered deck of cards
   public Deck()
   {
      newDeck();
   }
   
   //creates a new collection of 52 cards, sorted
   public void newDeck()
   {
      deck = new Card[NUM_CARDS];
      for (int rank = Card.ACE; rank <= Card.KING; rank++)
      {
         for (int suit = Card.SPADES; suit <= Card.DIAMONDS; suit++)
         {
            deck[ct] = new Card(rank, suit);
            ct = ct + 1;
         }
      }
   }
   
   //shuffles the deck
   public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < ct; i++)
      {
         randNum = r.nextInt(ct);
         temp = deck[i];
         deck[i] = deck[randNum];
         deck[randNum] = temp;
      }
   }
   
   //Removes and returns the top card from the deck
   //@return a reference to a card that was top of the deck
   public Card dealCard()
   {
      ct--;
      return deck[ct];
   }
   
   // Return current number of cards in deck
   // @reurn number of cards in deck
   public int cardsRemaining()
   {
      return ct;
   }
   
   //determine if deck is empty
   //@reurn true if decck is empty
   public boolean isEmpty()
   {
      return (cardsRemaining() == 0);
   }
   
//    public static void main(String [] args) 
//    {
//       Deck deck = new Deck();
//       deck.shuffle();
//       int i = 0;
//       while (!(deck.isEmpty()))
//          System.out.println(i++ + " : " + deck.dealCard().toString());
//       deck.newDeck();
//       System.out.println("************");
//       i = 0;
//       while (!(deck.isEmpty()))
//          System.out.println(i++ + " : " + deck.dealCard().toString());
// 
//    }
}