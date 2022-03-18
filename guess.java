 import javax.swing.*;


public class guess{

    private int numGuessesSoFar = 0;
    String myArray[] = new String[game.getGuessNum()];
    
    
    public guess(){

    }
    
    public int colAndPlaceCount(String _myArray[], String _codeArray[]){
        int nColAndPlace = 0;

        for(int i = 0; i < game.getGuessNum(); i++){
            if(_myArray[i] == _codeArray[i]){
                nColAndPlace++;
                myArray[i] = null;
            }
        }

        return nColAndPlace;
    }

    public int colCount(String _MyArray[], String _codeArray[]){
        int nCol = 0;
        
        for(int i = 0; i < game.getGuessNum(); i++){
            for(int j = 0; j < game.getGuessNum(); j++){
                if(_MyArray[i] == _codeArray[j]){
                    nCol++;
                    myArray[i] = null;
                }
            }
        }
        return nCol;
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