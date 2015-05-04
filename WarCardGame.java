// the guts of the game 
// user interface independent

import java.util.*;

public class WarCardGame
{
   private Deck deck;
   private ArrayList<Card> hand1;
   private ArrayList<Card> hand2;
   private ArrayList<Card> pile; 
   
   private String winner; //null until someone wins
   private String lastWinner; //the person who won the last round
   
   // Constructor
   public WarCardGame()
   {
      deck = new Deck(); //deck of cards
      hand1 = new ArrayList<Card>(); //player 1 hand
      hand2 = new ArrayList<Card>(); //player 2 hand
      pile = new ArrayList<Card>();  //pile   
      winner = null;
      newGame();  
   }
   
   // shuffles deck 7 times
   public void newGame()
   {
      //Shuffle cards 7 times
      for (int i = 0; i < 7; i++)
         deck.shuffle();
      
      //Deal cards into hand1 and hand2
      while (!(deck.isEmpty()))
      {  
          hand1.add(deck.dealCard());
          hand2.add(deck.dealCard());
      }
   }
   
   //one "battle" in the "war
   //one round for the game
   public void battle()
   {
      if ( hand1.get(0).getRank() == hand2.get(0).getRank() )//its a Tie! War happens
         war();
      else
      {
         if ( hand1.get(0).getRank() > hand2.get(0).getRank() )//player 1 wins battle
         {
            lastWinner = "Player";
            pile.add(hand1.remove(0)); //both cards are removed from hand 
            pile.add(hand2.remove(0)); //and into pile
            Collections.shuffle(pile); //shuffle pile
            hand1.addAll(pile); //Player 1 wins the pile
            pile.clear(); //pile is cleared
         }
         else//player two wins battle
         {
            lastWinner = "Computer";
            pile.add(hand1.remove(0)); //both cards are removed from hann
            pile.add(hand2.remove(0)); //and into pile
            Collections.shuffle(pile); //shuffle pile
            hand2.addAll(pile); //Player 2 wins the pile
            pile.clear(); //pile is cleared
         }
      }
      
      // check if someone wins
      if ( hand1.isEmpty() ) 
         winner = "Computer"; //player two wins
      else if ( hand2.isEmpty() )
         winner = "Player"; //player one wins
   }
   
   
   //if player and omputer tie
   //war happens
   public void war()
   {
      //if unable to play war determine who wins
      if ( hand1.size() < 3 )
         winner = "Player 2"; //player 2 wins
      else if ( hand2.size() < 3)
         winner = "Player 1"; //player 1 wins
      else
      {
         //remove first two cards from each hand
         //and add to the pile in list to pile
         pile.add(hand1.remove(0));
         pile.add(hand1.remove(1));
         pile.add(hand2.remove(0));
         pile.add(hand2.remove(1));
         Collections.shuffle(pile); //shuffle pile
         //battle again
         battle();
      }
   }
   
   //returns the number of cards in player's hand
   public int getPlayer()
   {
      return hand1.size();
   }
   
   //returns the number of cards in computer's hand
   public int getComputer()
   {
      return hand2.size();
   }
   
   //@return the winner of the game
   public String getWinner()
   {
      return winner;
   }
   
   //@return the jpg filename of player's card
   public String getPlayerCardjpg()
   {
      return hand1.get(0).getCardID();
   }
   
   //@return the jpg filename of computer's card
   public String getComputerCardjpg()
   {
      return hand2.get(0).getCardID();
   }
   
   //@return the last winner of the round
   public String getLastWinner()
   {
      return lastWinner;
   }
}