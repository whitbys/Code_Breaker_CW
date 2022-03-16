import javax.swing.*;


public class guess{
    
    private int numGuesses = 0;
    
    String playerGuess[] = new String[game.getGuessNum()];
    String gameAnswer[] = new String[game.getGuessNum()];
    
    
    public 
    
    
    public int colAndPlaceCheck(String array1[], String array2[]){
        int nColAndPlace = 0;
        
        for(int i = 0; i < game.getGuessNum(); i++){
            if(array1[i] == array2[i]){
                nColAndPlace++;
            }
        }
        return nColAndPlace;
        
    }

    public boolean colCheck(String array1[], String array2[]){
        int nCol  = 0;
        
        for(int i = 0; i < game.getGuessNum(); i++){
            for(int j = 0; j < game.getGuessNum(); j++){
                if(array1[i] == array2[j]){
                    nCol++;
                }
            }
        }
        return nCol;;
    }

    public void guessIncrement(){
        numGuesses++;

        if(numGuesses == game.getGuessNum() + 1){
            numGuesses = numGuesses - game.getGuessNum();
        }
    }

    public int getGuesses(){
        return numGuesses;
    }
}