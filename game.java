//in update results have a parameter of how many times -> put into for loop

        //gui.getJFrame().dispose();



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class game{
    private static int guessNum = 4;
    private static int tryNum = 6;
    
    private static final int numButtons = 3;
    private static final int numLabels = 2;

    JFrame frame = new JFrame("MENU");
    JPanel panel = new JPanel(new BorderLayout());
    JButton butt[] = new JButton[numButtons];
    JLabel label[] = new JLabel[numLabels];
    
    //contructor without, call in main function
    public game(){
        frame.setContentPane(panel);
        initButtons();
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setVisible(true);
    }

    //contructor with win or lose parameter, call in action listener if statements
    public game(Boolean win){
        frame.setContentPane(panel);
        initButtons();
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setVisible(true);
    }
    
    
    public static void main(String[] args){
        
        

        GUI gui = new GUI(tryNum, guessNum);
        }
    
    
    //initialisers----------------------------------------------------------

    private void initButtons(){
        butt[0] = new JButton("EASY");
        butt[0].setFont(new Font("Tahoma", font.BOLD, 12));
        butt[0].setBackground(new Color(0, 255 , 0));
        butt[0].setBorder(new RoundedBorder(10));
        
        butt[1] = new JButton("MEDIUM");
        butt[0].setFont(new Font("Tahoma", font.BOLD, 12));
        butt[0].setBackground(new Color(255, 153 , 51));
        butt[0].setBorder(new RoundedBorder(10));
        
        butt[2] = new JButton("HARD");
        butt[0].setFont(new Font("Tahoma", font.BOLD, 12));
        butt[0].setBackground(new Color(255, 0 , 0));
        butt[0].setBorder(new RoundedBorder(10));

        panel.add(butt[0], BorderLayout.WEST);
        panel.add(butt[1], BorderLayout.CENTER);
        panel.add(butt[2], BorderLayout.EAST);
    }

    public void initTextLabels(Boolean b){
        label[0] = new JLabel("Select difficulty level");
        
        if(b == true){
            label[0] = new JLabel("Win Status: YOU WON!");
        }
        else if(b==false){
            label[0] = new JLabel("Win Status: you lost...");
        }
        
    }
    


    //getters --------------------------------------------------------------
    public static int getGuessNum(){
        return guessNum;
    }

    public static int getTryNum(){
        return tryNum;
    }


    //setters ----------------------------------------------------------------

    public static void setGuessNum(int x){
        guessNum = x;
    }

    public static void setTryNum(int y){
        tryNum = y;
    }


}


/* if(startPoint == game.getGuessNum()){
    System.exit(0);
    //set startpoint to 1(arbitrary value in range)
    //display success window for 10 seconds 
    //back to settings
    
    
    //settings class : win status panel,high score, etc  + 3 difficulty levels
    //if win -> win screen + setting
    //if lose -> lose screen + setting
} */