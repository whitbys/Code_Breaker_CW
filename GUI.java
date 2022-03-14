import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//classes,contrusctors,encapsulation,composition

//do i need to make everything private and have getters and necessary setters
//do i need to make arrays private
//background colour so gaps aren't visible
public class GUI implements ActionListener{
    //define number of tries and guesses per try
    private static int guessNum = 4;
    private static int tryNum = 6;
    private static final int boardNum = guessNum * tryNum;
    private static final int numOfButtons = 7;
    private int labelFill = 0;
    private int labelLoc = boardNum - labelFill;
    
    //create window compenents
    JFrame f = new JFrame("CODE BREAKER");
    JPanel pan[] = new JPanel[4];

    //create picture objects from files to be used on buttons and labels
    private static Picture[] pic = new Picture[10];
    
    //create buttons/label for each panel
    private static JButton[] but = new JButton[numOfButtons];
    
    static JLabel[] boardLabel = new JLabel[boardNum];
    JLabel[] resultLabel = new JLabel[boardNum];
    JPanel[] miniPanel = new JPanel[tryNum];
    
    public GUI(){
        initMainPanels();
        initPictures();
        
        //add 3 major panes to the window
        f.setContentPane(pan[0]);
        pan[0].add(pan[1], BorderLayout.SOUTH);//bottom row buttons
        pan[0].add(pan[2], BorderLayout.CENTER);//right hand result labels
        pan[0].add(pan[3], BorderLayout.EAST);//left hand guess display labels
        
        //bottom row buttons
        for(int i = 0; i < numOfButtons; i++){
            but[i] = new JButton(pic[i]);
            but[i].addActionListener(this);
            pan[1].add(but[i]);
        }

        //left hand result labels
        for(int j = 0; j < boardNum; j++){
            boardLabel[j] = new JLabel(pic[7]);
            pan[2].add(boardLabel[j]);
        }
        
        //right hand result labels
        for(int k = 0; k < tryNum; k++){
            miniPanel[k] = new JPanel(new GridLayout(2,2));
            pan[3].add(miniPanel[k]);

            for(int l = 0; l < guessNum; l++){
                resultLabel[l] = new JLabel(pic[7]);
                miniPanel[k].add(resultLabel[l]);
            }
        }
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 600);
        f.setVisible(true);
    }

    //for loop boardnum - m++
    //
    int p = 20;

    public void actionPerformed(ActionEvent e){
        Picture piccy = null;
        for(int m = 0; m < numOfButtons; m++){
            if(e.getSource() == but[m]){
                piccy = pic[m];
            }
        }

        boardLabel[p].setIcon(piccy);
        p++;
        if(p==4){
            System.exit(0);
        }
        if((p %4) == 0){
            p = p - (guessNum*2);
        }
    }   


    private void initPictures(){
        pic[0] = new Picture("Colour_0.png");
        pic[1] = new Picture("Colour_1.png");
        pic[2] = new Picture("Colour_2.png");
        pic[3] = new Picture("Colour_3.png");
        pic[4] = new Picture("Colour_4.png");
        pic[5] = new Picture("Colour_5.png");
        pic[6] = new Picture("Colour_6.png");
        pic[7] = new Picture("Empty.png");
        pic[8] = new Picture("Score_0.png");
        pic[9] = new Picture("Score_1.png");
    }

    private void initMainPanels(){
        pan[0] = new JPanel(new BorderLayout());
        pan[1] = new JPanel(new GridLayout());
        pan[2] = new JPanel(new GridLayout(tryNum, guessNum));
        pan[3] = new JPanel(new GridLayout(tryNum, 1));
    }

    //setters-------------------------------------------------------------
    public void setGuessNum(int a){
        guessNum = a;
    }

    public void setTryNum(int b){
        tryNum = b; 
    }

    public static void setBoardLabel(Picture pict, int pp){
        boardLabel[pp].setIcon(pict);
    }
   //getters---------------------------------------------------------------
    
    public static int getNumOfButtons(){
        return numOfButtons;
    }

    public static JButton getBut(int n){
        return but[n];
    }

    public static Picture getPic(int o){
        return pic[0];
    }

    public static int getGuessNum(){
        return guessNum;
    }

    public int getTryNum(){
        return tryNum; 
    }

    






}