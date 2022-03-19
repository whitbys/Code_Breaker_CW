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

    private void guessIncrement(){
        numGuessesSoFar++;
        if(numGuessesSoFar == game.getGuessNum()){
            numGuessesSoFar = numGuessesSoFar - game.getGuessNum();
            //triesSoFar++;
        }
    }
    
    public int getGuessesSoFar(){
        return numGuessesSoFar;
    }
    
    public String[] getMyArray(){
        return myArray;
    }

    public void setMyArrayElement(int n, String s){
        myArray[n] = s;
    }

    public String getMyArrayElement(int n){
        return myArray[n];
    }

} 