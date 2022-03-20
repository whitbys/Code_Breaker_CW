import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
*Models a settings menu.
*A GUI displayed before and after games which lets users 
choose a difficulty level and see if they won or lost
*@author Steven Whitby
*/
public class game implements ActionListener{
    //constants
    private static final int numButtons = 3;
    private static final int numLabels = 2;
    
    //difficulty level parameters
    private static int guessNum;
    private static int tryNum;
    
    //window frame + components
    private JFrame frame = new JFrame("MENU");
    private JPanel panel = new JPanel(new BorderLayout());
    private JPanel butPanel = new JPanel(new GridLayout(1,numButtons));
    private JButton butt[] = new JButton[numButtons];
    private JLabel label[] = new JLabel[numLabels];

    /**
     * creates settings menu
     * @param w The win status
     */
    public game(int w){
        frame.setContentPane(panel);
        initButtons();
        initTextLabels(w);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(750, 250);
        
        frame.setVisible(true);
    }

    //public methods --------------------------------------------------------------
    
    //creates a new game based on difficulty button chosen
    public void actionPerformed(ActionEvent e){
        frame.dispose();

        //EASY
        if(e.getSource() == butt[0]){
            setTryNum(8);
            setGuessNum(2);
            GUI easyGUI = new GUI(tryNum, guessNum, 325, 925);
        }
        //MEDIUM
        else if(e.getSource() == butt[1]){
            setTryNum(6);
            setGuessNum(4);
            GUI mediumGUI = new GUI(tryNum, guessNum, 645, 750);
        }
        //HARD
        else if(e.getSource() == butt[2]){
            setTryNum(4);
            setGuessNum(6);
            GUI hardGUI = new GUI(tryNum, guessNum, 901, 575);
        }
    }
    
    /**
     * instantiates a settings window with no win status
     * @param args The command line arguments
     */
    public static void main(String[] args){
        game game = new game(0);
    }

    /**
     * Obtains no. of guesses per try given to user
     * @return number of guesses 
     */
    public static int getGuessNum(){
        return guessNum;
    }

    /**
     * Obtains total tries given to user
     * @return nuber of tries
     */
    public static int getTryNum(){
        return tryNum;
    }

    //private methods ----------------------------------------------------------------

    //create difficulty buttons
    private void initButtons(){
        panel.add(butPanel, BorderLayout.CENTER);
        
        //button characteristics
        butt[0] = new JButton("EASY");
        butt[0].setBackground(new Color(0, 255 , 0));
        
        butt[1] = new JButton("MEDIUM");
        butt[1].setBackground(new Color(255, 153 , 51));
        
        butt[2] = new JButton("HARD");
        butt[2].setBackground(new Color(255, 0 , 0));

        for(int i = 0; i < numButtons; i++){
            butt[i].addActionListener(this);
            butPanel.add(butt[i]);
        }
        
    }

    //create top and bottom text labels for menu
    private void initTextLabels(int w){
        //top message
        label[0] = new JLabel("Welcome to Code Breaker, Please select a difficulty level:");
        label[0].setFont(new Font("serif", Font.PLAIN, 25));
        label[0].setForeground(Color.BLACK);
        panel.add(label[0], BorderLayout.NORTH);
        
        //bottom message
        label[1] = new JLabel();
        label[1].setOpaque(true);
        label[1].setBackground(Color.BLACK);
        label[1].setFont(new Font("serif", Font.PLAIN, 30));
        //win characteristics
        if(w == 1){
            label[1].setText("Win Status: YOU WON!");
            label[1].setForeground(Color.GREEN);
            panel.add(label[1], BorderLayout.SOUTH);
            
        }
        //lose characteristics
        else if(w == -1){
            label[1].setText("Win Status: you lost...");
            label[1].setForeground(Color.RED);
            panel.add(label[1], BorderLayout.SOUTH);
        }
        
    }
    
    private void setGuessNum(int x){
        guessNum = x;
    }

    private void setTryNum(int y){
        tryNum = y;
    }
}
