import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.GridLayout;


public class GUI{
    JPanel p = new JPanel();
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


    




    public GUI(){

        f.setContentPane(p);
        p.setLayout(new GridLayout());

        p.add(redBut);
        
        
        
        
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(900, 900);
        f.setVisible(true);
    }
}