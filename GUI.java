import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener{
    //constants
    private static final int numPanels = 4;
    private static final int numPics = 10;
    private static final int numButtons = 7;
    private static final int numMiniPanels = 2;
    private static final int numTextLabels = 2;
    


    //instance variables
    private int startPoint = 0;
    private String butPressed = null;
    

    //frame + components
    private static JFrame frame = new JFrame("CODE BREAKER");
    private static JPanel pan[] = new JPanel[numPanels];
    private static Picture pic[] = new Picture[numPics];
    private static JButton but[] = new JButton[numButtons];
    private JPanel miniPanel[] = new JPanel[numMiniPanels];
    private JLabel boardLabel[] = new JLabel[200];
    private JLabel resultLabel[] = new JLabel[200];
    private JLabel textLabel[] = new JLabel[numTextLabels];


    guess guess = new guess();
    colourCode colourCode = new colourCode();

    Color brownBackground = new Color(155, 98, 10);
 
    public GUI(int tN, int gN, int w, int h){
        pan[0] = new JPanel(new BorderLayout());
        frame.setContentPane(pan[0]);
        
        initPictures();
        initButtons();
        initBoard(tN, gN);
        initResults(tN, gN);
        colourCode.initCode(gN);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        //frame.setMinimumSize(arg0);
        
        frame.setSize(w, h);
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
        startPoint++;
        guess.inputMyArray(piccy); 
        
        if(startPoint % game.getGuessNum() == 0){ 
            int cp = colAndPlaceCount(guess.getMyArray(), colourCode.getCodeArray());
            int c = colCount(guess.getMyArray(), colourCode.getCodeArray());
            
            updateResults(cp,c, startPoint);

            

            if(cp == game.getGuessNum()){
                //wait 5 seconds
                
                frame.dispose();
                game newgame = new game(1);
            }
        }
 
        if(startPoint == game.getGuessNum()*game.getTryNum()){
            //wait 10 seconds
            
            frame.dispose();
            game newgame = new game(-1);
        } 
    }

    private int colAndPlaceCount(String _myArray[], String _codeArray[]){
        int nColAndPlace = 0;

        for(int i = 0; i < game.getGuessNum(); i++){
            if(_myArray[i] == _codeArray[i]){
                nColAndPlace++;
                guess.setMyArrayElement(i, "apples");
                colourCode.setCodeArrayElement(i, "oranges");
            }
        }
        
        
        
        return nColAndPlace;
    }
    
    private int colCount(String _myArray[], String _codeArray[]){
        int nCol = 0;
        
        for(int i = 0; i < game.getGuessNum(); i++){
            for(int j = 0; j < game.getGuessNum(); j++){
                if(_myArray[i] == _codeArray[j]){
                    nCol++;
                }
            }
        }
        for(int j = 0; j < game.getGuessNum(); j++){
            colourCode.setCodeArrayElement(j, colourCode.getOGCodeArrayElement(j));
        }
        return nCol;
    } 
    
    public void updateResults(int colAndPlace, int col, int sP){
            int p;
            sP = sP - game.getGuessNum();
            System.out.println("colPlace: "+colAndPlace);
            for(p = sP; p < sP + colAndPlace; p++){
                resultLabel[p].setIcon(pic[8]);
            }
            System.out.println("col: "+ col);
            for(p = sP + colAndPlace; p < sP + colAndPlace + col; p++){
                resultLabel[p].setIcon(pic[9]);
            }
            System.out.println("neither col or place: "+(game.getGuessNum() - colAndPlace - col));
            for(p = sP + colAndPlace + col; p < sP + game.getGuessNum(); p++){
                resultLabel[p].setIcon(pic[7]);
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
            but[i].setBackground(brownBackground);
        }
    }

    private void initBoard(int tN, int gN){
        pan[2] = new JPanel(new BorderLayout());
        pan[0].add(pan[2], BorderLayout.CENTER);

        miniPanel[0] = new JPanel(new GridLayout(tN, gN));
        pan[2].add(miniPanel[0], BorderLayout.SOUTH);

        for(int j = 0; j < tN*gN; j++){
            boardLabel[j] = new JLabel(pic[7]);
            miniPanel[0].add(boardLabel[j]);
        }

        pan[2].setBackground(brownBackground);

        textLabel[0] = new JLabel("Guesses Allowed:"+ tN);
        pan[2].add(textLabel[0], BorderLayout.NORTH);
    }

    public void initResults(int tN, int gN){
        pan[3] = new JPanel(new BorderLayout());
        pan[0].add(pan[3], BorderLayout.EAST);

        miniPanel[1] = new JPanel(new GridLayout(tN, gN));
        pan[3].add(miniPanel[1], BorderLayout.SOUTH);

        

            for(int l = 0; l < tN * gN; l++){
                resultLabel[l] = new JLabel(pic[7]);
                miniPanel[1].add(resultLabel[l]);
        }
        pan[3].setBackground(brownBackground);
        
        textLabel[1] = new JLabel("Results:");
        pan[3].add(textLabel[1], BorderLayout.NORTH);
    }

    //getters--------------------------------------------

    public static JButton getBut(int b){
        return but[b];
    }

    public JFrame getJFrame(){
        return frame;
    }

    public static Picture getPic(int c){
        return pic[c];
    }

    public static int getNumButtons(){
        return numButtons;
    }
    //setters--------------------------------------------

    

}