import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

//result mini grids
//background colour so gaps aren't visible
public class GUI{
    private int comboNum = 4;
    private int guessNum = 6;
    private int boardNum = comboNum * guessNum;
    
    
    JPanel pMain = new JPanel(new BorderLayout());
    JPanel pBut = new JPanel(new GridLayout());
    JPanel pBoard = new JPanel(new GridLayout(guessNum, comboNum));
    JPanel pResult = new JPanel(new GridLayout(guessNum, 1));



    JFrame f = new JFrame("CODE BREAKER");

    GridLayout gl = new GridLayout();

    Picture red = new Picture("Colour_0.png");
    Picture orange = new Picture("Colour_1.png");
    Picture yellow = new Picture("Colour_2.png");
    Picture green = new Picture("Colour_3.png");
    Picture blue = new Picture("Colour_4.png");
    Picture indigo = new Picture("Colour_5.png");
    Picture violet = new Picture("Colour_6.png");
    Picture empty = new Picture("Empty.png");
    Picture correct2 = new Picture("Score_0.png");
    Picture correct1 = new Picture("Score_1.png");

    JButton redBut = new JButton(red);
    JButton orangeBut = new JButton(orange);
    JButton yellowBut = new JButton(yellow);
    JButton greenBut = new JButton(green);
    JButton blueBut = new JButton(blue);
    JButton indigoBut = new JButton(indigo);
    JButton violetBut = new JButton(violet);

    JLabel[] boardLabel = new JLabel[boardNum];
    JLabel[] resultLabel = new JLabel[boardNum];

    JPanel[] pRowResult = new JPanel[guessNum];
    
    public GUI(){
        f.setContentPane(pMain);
        
        pMain.add(pBut, BorderLayout.SOUTH);
        pMain.add(pBoard, BorderLayout.CENTER);
        pMain.add(pResult, BorderLayout.EAST);

        for(int i = 0; i < guessNum; i++){
            pRowResult[i] = new JPanel(new GridLayout(2,2));
            pResult.add(pRowResult[i]);

            for(int j = 0; j < comboNum; j++){
                resultLabel[j] = new JLabel(empty);
                pRowResult[i].add(resultLabel[j]);
            }
        }
        
        
        
 
        pBut.add(redBut);
        pBut.add(orangeBut);
        pBut.add(yellowBut);
        pBut.add(greenBut);
        pBut.add(blueBut);
        pBut.add(indigoBut);
        pBut.add(violetBut);
        
        for(int k = 0; k < boardNum; k++){
            boardLabel[k] = new JLabel(empty);
            pBoard.add(boardLabel[k]);
        }
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(900, 900);
        f.setVisible(true);
    }
}