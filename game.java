import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


//JTBD
//javadoc + genreal comments
//general comments +




public class game implements ActionListener{
    private static int guessNum;
    private static int tryNum;
    
    private static final int numButtons = 3;
    private static final int numLabels = 2;

    JFrame frame = new JFrame("MENU");
    JPanel panel = new JPanel(new BorderLayout());
    JPanel butPanel = new JPanel(new GridLayout(1,numButtons));
    JButton butt[] = new JButton[numButtons];
    JLabel label[] = new JLabel[numLabels];

    
    public game(int w){
        frame.setContentPane(panel);
        initButtons();
        initTextLabels(w);
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 150);
        
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        frame.dispose();

        if(e.getSource() == butt[0]){
            setTryNum(8);
            setGuessNum(2);
            GUI easyGUI = new GUI(tryNum, guessNum, 325, 875);
        }
        else if(e.getSource() == butt[1]){
            setTryNum(6);
            setGuessNum(4);
            GUI mediumGUI = new GUI(tryNum, guessNum, 645, 700);
        }
        else if(e.getSource() == butt[2]){
            setTryNum(4);
            setGuessNum(6);
            GUI hardGUI = new GUI(tryNum, guessNum, 901, 525);
        }
    }
    
    public static void main(String[] args){
        game game = new game(0);
        }
    
    //initialisers----------------------------------------------------------

    private void initButtons(){
        panel.add(butPanel, BorderLayout.CENTER);
        
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

    public void initTextLabels(int w){
        label[0] = new JLabel("Welcome to Code Breaker, Please select a difficulty level:");
        panel.add(label[0], BorderLayout.NORTH);
        
        if(w == 1){
            label[1] = new JLabel("Win Status: YOU WON!");
            panel.add(label[1], BorderLayout.SOUTH);
            
        }
        else if(w == -1){
            label[1] = new JLabel("Win Status: you lost...");
            panel.add(label[1], BorderLayout.SOUTH);
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
