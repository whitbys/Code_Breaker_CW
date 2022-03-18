//match col and position, increment counter
//add matches to yeeted array
//match col (if col && if not in yeeted array, increment counter)



import java.util.Random;

public class colourCode{
    Random rand = new Random();
    String codeArray[] = new String[game.getGuessNum()];
    
    
    //constructor
    public colourCode(){
    }
    
    //initialisers-----------------------------------------------------
    public String[] initCode(int n){
        for(int i = 0; i < n; i++){
            codeArray[i] = GUI.getPic(rand.nextInt(7)).getFilename();
        }
        for(int b = 0; b < n; b++){
            System.out.println(""+codeArray[b]);
        }
        return codeArray;
    }

    //getters----------------------------------------------------------
    public String[] getCodeArray(){
        return codeArray;
    }

    
}