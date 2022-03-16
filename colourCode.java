import java.util.Random;

public class colourCode{

    Random rand = new Random();

    
    Public ColourCode(){

    }
    
    
    public String[] initCode(){
        String s[] = new String[game.getGuessNum()];
        
        for(int i = 0; i < game.getGuessNum(); i++){
            s[i] = GUI.getPic(rand.nextInt(7)).getFilename();
        }
        return s;
    }

    

    //yyet
}