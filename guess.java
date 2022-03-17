 import javax.swing.*;


public class guess{

    private int numGuessesSoFar = 0;
    String myArray[] = new String[game.getGuessNum()];
    
    
    public guess(){

    }
    
    
    public void inputMyArray(Picture p){
        myArray[numGuessesSoFar] = p.getFilename();
        System.out.println("myGUESS: "+myArray[numGuessesSoFar]);
        guessIncrement();
    }
    
    public void guessIncrement(){
        numGuessesSoFar++;
        if(numGuessesSoFar == game.getGuessNum()){
            numGuessesSoFar = numGuessesSoFar - game.getGuessNum();
            //triesSoFar++;
        }
    }

    public String[] getMyArray(){
        return myArray;
    }

    public int getGuessesSoFar(){
        return numGuessesSoFar;
    }


    

} 