// GUI for War Card Game
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class WarCardGameGUI extends JFrame
{
   private JPanel p1; //Holds the "computerCard"
   private JPanel p2; //Holds the command lines 
   private JPanel p3; //Holds the "playerCard"
   private JPanel p4; //Holds the buttons and score
   
   private JButton battle; //Button to play cards 
   private JButton quit; //Button to quit game
   
   private JLabel playerHand; //Holds number of cards in player's hand
   private JLabel computerHand; //Holds number of cards in computer's hand
   private JLabel player; //label for player's current card
   private JLabel playerCardLabel; //label to hold ICON
   private JLabel computer; //label for computer's current card
   private JLabel computerCardLabel; //label to hold icon
   private JLabel command; //label to say various game stuff.
   
   private WarCardGame game; //Backbones of the game
   
   private ImageIcon playerCardjpg; // Holds path to the current card being played by the player
   private ImageIcon computerCardjpg; //Holds path to the current card being played by the computer
   
   
   public WarCardGameGUI()
   {
      //bacbones
      game = new WarCardGame();
        
      //set layout for the frame
      setLayout(new GridLayout(2,2));
      ////////////////// PANEL 1 //////////////////////
      p1 = new JPanel();
      p1.setLayout(new BorderLayout());
      //computer label
      computer = new JLabel("Computer");
      p1.add(computer,BorderLayout.NORTH);
      //create card image, default to back of card
      computerCardjpg = new ImageIcon("back.jpg");
      computerCardLabel = new JLabel();
      computerCardLabel.setIcon(computerCardjpg);
      p1.add(computerCardLabel);
      
      ///////////////// PANEL 2 /////////////////////// 
      p2 = new JPanel();
      p2.setLayout(new BorderLayout());
      command = new JLabel("Welcome to the Game of War!!!");
      p2.add(command,BorderLayout.CENTER);

      ///////////////// PANEL 3 //////////////////////// 
      p3 = new JPanel();
      p3.setLayout(new BorderLayout());
      //player label
      player = new JLabel("Player");
      p3.add(player,BorderLayout.NORTH);
      //create card image, default to back of card
      playerCardjpg = new ImageIcon("back.jpg");
      playerCardLabel = new JLabel();
      playerCardLabel.setIcon(computerCardjpg);
      p3.add(playerCardLabel);

      //////////////// PANEL 4 /////////////////////// 
      p4 = new JPanel();
      p4.setLayout(new GridLayout(2,2));
      //Label to keep track of player cards
      playerHand = new JLabel("Player: 26");
      p4.add(playerHand);
      //Label to keep track of computers hand
      computerHand = new JLabel("Computer: 26");
      p4.add(computerHand);
      //battle button
      battle = new JButton("Battle");
      p4.add(battle);
      battle.addActionListener(new PlayCardListener());
      // Quit game Button
      quit = new JButton("Quit Game");
      p4.add(quit);
      quit.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            System.exit(0);
         }
      });
       
        
      // add panels to JFrame              
      add(p1);
      add(p2);
      add(p3);
      add(p4);
   }
   
   private class PlayCardListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (game.getWinner() != null)
         {
            command.setText(game.getWinner()+ " wins the war!!!!!");
            battle.setEnabled(false);  
         }
         else
         {
            //change player's card image
            playerCardjpg = new ImageIcon(game.getPlayerCardjpg());  
            playerCardLabel.setIcon(playerCardjpg);
            //change player's card image
            computerCardjpg = new ImageIcon(game.getComputerCardjpg());  
            computerCardLabel.setIcon(computerCardjpg);
            //battle
            game.battle();
            //display hands' totals
            playerHand.setText("Player: "+ game.getPlayer());
            computerHand.setText("Computer: " + game.getComputer());
            
            /////////PANEL 2//////////
            command.setText(game.getLastWinner()+" wins the battle");
         }
            
      }
   }
   
   public static void main(String[] args) 
   {   
        WarCardGameGUI frame = new WarCardGameGUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.pack();
        frame.setVisible(true);
    }
   
}