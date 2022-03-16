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
    private int startPoint = game.getTryNum()*game.getGuessNum() 
                           - game.getGuessNum();
    private String butPressed = null;

    //frame + components
    private static JFrame frame = new JFrame("CODE BREAKER");
    private static JPanel pan[] = new JPanel[numPanels];
    private static Picture pic[] = new Picture[numPics];
    private static JButton but[] = new JButton[numButtons];
    private JPanel resultPanel[] = new JPanel[game.getTryNum()*200];
    private JLabel boardLabel[] = new JLabel[game.getTryNum()*game.getGuessNum() *200];
    private JLabel resultLabel[] = new JLabel[game.getTryNum()*game.getGuessNum() *200];
 
    
    public GUI(int tN, int gN){
        pan[0] = new JPanel(new BorderLayout());
        frame.setContentPane(pan[0]);
        
        initPictures();
        initButtons();
        initBoard(tN, gN);
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
        whichButPressed(piccy);
        startPoint++;
        
        if(startPoint == game.getGuessNum()){
            System.exit(0);
            //settings class : win status panel,high score, etc  + 3 difficulty levels
            //if win -> win screen + setting
            //if lose -> lose screen + setting
        }
        
        
        if((startPoint % game.getGuessNum()) == 0){
            newRowFlag();
            
            startPoint = startPoint - (game.getGuessNum()*2);
        }
        
    }

    /* public String whichButPressed(Picture p){
        switch(p.getFilename()){
            case "Colour_0.png":
                return "red";
            case "Colour_1.png":
                return "orange";
            case "Colour_2.png":
                return "yellow";
            case "Colour_3.png":
                return "green";
            case "Colour_4.png":
                return "blue";
            case "Colour_5.png":
                return "indigo";
            case "Colour_6.png":
                return "violet";
        }
        return "x";
    } */

    public Boolean newRowFlag(){
        return true;
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

    public void initBoard(int tN, int gN){
        if(pan[2] != null){
            frame.remove(pan[2]);
        }
        
        pan[2] = new JPanel(new GridLayout(tN, gN));
        pan[0].add(pan[2], BorderLayout.CENTER);
        tN = tN * gN;
        for(int j = 0; j < tN; j++){
            boardLabel[j] = new JLabel(pic[7]);
            pan[2].add(boardLabel[j]);
        }
    }

    public void initResults(int tN, int gN){
        if(pan[3] != null){
            frame.remove(pan[3]);
        }

        pan[3] = new JPanel(new GridLayout(tN, 1));
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

    public static JButton getBut(int b){
        return but[b];
    }

    public JFrame getJFrame(){
        return frame;
    }

    public JButton getButPressed(){
        return e.getSource();
    }

    public static Picture getPic(int c){
        return pic[c];
    }
    //setters--------------------------------------------

    

}