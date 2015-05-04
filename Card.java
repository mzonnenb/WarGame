// Michael Zonnenberg
// CS110 Assignment5 problem 3

//Card class that creates card with suit and rank   


public class Card
{
   //field
   public static int SPADES = 1;
   public static int CLUBS = 2;
   public static int HEARTS = 3;
   public static int DIAMONDS = 4;
   
   public static int ACE = 1;
   public static int JACK = 11;
   public static int QUEEN = 12;
   public static int KING = 13;
   
   private int rank;
   private int suit;
   
   public Card()
   {
      suit = 0;
      rank = 0;
   }
   // constructor that makes card rank and suit
   public Card(int RANK, int SUIT)
   {
      suit = SUIT;
      rank = RANK; 
   }
   
   //copy constructor
   public Card(Card c)
   {
      this(c.getSuit(),c.getRank());
   }
   
   //returns suit
   public int getSuit()
   {
      return suit;
   }
   
   //returns rank
   public int getRank()
   {
      return rank;
   }
   
   //dtermine if card is equal to another card
   public boolean equals(Card othercard2)
   {
      boolean status;
      if (othercard2.getRank() == rank)
         status = true;
      else
         status = false;
      return status;   
   }

   // determines if higher than other card   
   public boolean higherThan(Card othercard2)
   {
      boolean status;
      if (othercard2.getRank() < rank)
         status = true;
      else
         status = false;
      return status;
   }
   
   public String getSuitName()
   {
     String s;
     switch(suit)
     {
      case 1: s = "Spades";
      break;
      case 2: s = "Clubs"; 
      break; 
      case 3: s = "Hearts"; 
      break; 
      case 4: s = "Diamonds"; 
      break;
      default: s ="unkown";
      break;
     }
     return s;
     }
     
    public String getCardID()
    {
      String s;
     switch(suit)
     {
      case 1: s = "s";
      break;
      case 2: s = "c"; 
      break; 
      case 3: s = "h"; 
      break; 
      case 4: s = "d"; 
      break;
      default: s ="unkown";
      break;
     }
     
     String r;
     switch(rank)
     {
      case 1: r = "ace";
      break;
      case 2: r = "2";
      break;
      case 3: r = "3";
      break;
      case 4: r = "4";
      break;
      case 5: r = "5";
      break;
      case 6: r = "6";
      break;
      case 7: r = "7";
      break;
      case 8: r = "8";
      break;
      case 9: r = "9";
      break;
      case 10: r = "10";
      break;
      case 11: r = "jack";
      break;
      case 12: r = "queen";
      break;
      case 13: r = "king";
      break;
      default: r = "Unknown";
      break;
     }
     return r+s+".jpg";
    } 
     
    public String getRankName()
    {
     String r;
     switch(rank)
     {
      case 1: r = "Ace";
      break;
      case 2: r = "Two";
      break;
      case 3: r = "Three";
      break;
      case 4: r = "Four";
      break;
      case 5: r = "Five";
      break;
      case 6: r = "Six";
      break;
      case 7: r = "Seven";
      break;
      case 8: r = "Eight";
      break;
      case 9: r = "Nine";
      break;
      case 10: r = "Ten";
      break;
      case 11: r = "Jack";
      break;
      case 12: r = "Queen";
      break;
      case 13: r = "King";
      break;
      default: r = "Unknown";
      break;
     }
     return r;
   }

   
   public String toString()
   {
      
      return (getRankName()+" of "+getSuitName());
   }
   
   
   
}