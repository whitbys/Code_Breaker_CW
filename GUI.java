import javax.swing.*;
import java.awt.*;

import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener{
    //constants
    private static final int numPanels = 4;
    private static final int numPics = 10;
    private static final int numButtons = 7;

    //instance variables
    private int guessNum = 4;
    private int tryNum = 6;
    private int numLabels = guessNum * tryNum;
    private int startPoint = 20;

    //frame + components
    private static JFrame frame = new JFrame("CODE BREAKER");
    private static JPanel pan[] = new JPanel[numPanels];
    private static Picture pic[] = new Picture[numPics];
    private static JButton but[] = new JButton[numButtons];
    private JPanel resultPanel[] = new JPanel[tryNum];
    private JLabel boardLabel[] = new JLabel[numLabels];
    private JLabel resultLabel[] = new JLabel[numLabels];

    guess guess = new guess();

    public GUI(){
        pan[0] = new JPanel(new BorderLayout());
        frame.setContentPane(pan[0]);

        initPictures();
        initButtons();
        initBoard(6);
        initResults(6, 4);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setVisible(true);
    }
    
    
    
    
    public GUI(int tN, int gN){
        pan[0] = new JPanel(new BorderLayout());
        frame.setContentPane(pan[0]);

        initPictures();
        initButtons();
        initBoard(tN);
        initResults(tN, gN);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        //change JLabel depending on button
        Picture piccy = null;
        for(int m = 0; m < numButtons; m++){
            if(e.getSource() == but[m]){
                piccy = pic[m];
            }
        }
        boardLabel[startPoint].setIcon(piccy);
        movePoint(startPoint);//move JLabel to be changed

    }

    private void movePoint(int s){
        startPoint++;
        if(startPoint == 4){
            System.exit(0);
        }
        else if((startPoint %4) == 0){
            startPoint = startPoint - (guessNum*2);
        }
    }
    
    //initializers--------------------------------------
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

    private void initButtons(){
        pan[1] = new JPanel(new GridLayout());
        pan[0].add(pan[1], BorderLayout.SOUTH);
        
        for(int i = 0; i < numButtons; i++){
            but[i] = new JButton(pic[i]);
            but[i].addActionListener(this);
            pan[1].add(but[i]);
        }
    }

    public void initBoard(int tN){
        tN = tN * guessNum;

        System.out.println(" " + tN);

        pan[2] = new JPanel(new GridLayout(tryNum, guessNum));
        pan[0].add(pan[2], BorderLayout.CENTER);
        
        for(int j = 0; j < tN; j++){
            boardLabel[j] = new JLabel(pic[7]);
            pan[2].add(boardLabel[j]);
        }
    }

    public void initResults(int tN, int gN){
        pan[3] = new JPanel(new GridLayout(tryNum, 1));
        pan[0].add(pan[3], BorderLayout.EAST);
        
        for(int k = 0; k < tN; k++){
            resultPanel[k] = new JPanel(new GridLayout(2,2));
            pan[3].add(resultPanel[k]);

            for(int l = 0; l < gN; l++){
                resultLabel[l] = new JLabel(pic[7]);
                resultPanel[k].add(resultLabel[l]);
            }
        }
    }

    //getters--------------------------------------------

    public int getGuessNum(){
        return guessNum;
    }

    public int getTryNum(){
        return tryNum;
    }

    public int getnumLabels(){
        return numLabels;
    }

    public static JButton getBut(int b){
        return but[b];
    }
    //setters--------------------------------------------

    public void setGuessNum(int x){
        guessNum = x;
    }

    public void setTryNum(int y){
        tryNum = y;
    }

    public void setnumLabels(int z){
        numLabels = z;
    }

}