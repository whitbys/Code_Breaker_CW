import javax.swing.*;

/**
 * class to record the users answers
 */
public class guess{

    private int numGuessesSoFar = 0;
    String myArray[] = new String[game.getGuessNum()];
    
    /**
     * create a new guess class
     */
    public guess(){
    }
    
    /**
     * assigns an array value with the filename of a picture
     * @param p picture 
     */
    public void inputMyArray(Picture p){
        myArray[numGuessesSoFar] = p.getFilename();
        System.out.println("myGUESS: "+myArray[numGuessesSoFar]);
        guessIncrement();
    }
    
    /**
     * Obtains number of guesses so far within a try
     * @return number of guesses
     */
    public int getGuessesSoFar(){
        return numGuessesSoFar;
    }
    
    /**
     * obtains the users answer for a certain try
     * @return String of button filenames
     */
    public String[] getMyArray(){
        return myArray;
    }

    /**
     * Sets specified array index to a filename
     * @param n array index
     * @param s String value of array index
     */
    public void setMyArrayElement(int n, String s){
        myArray[n] = s;
    }

    /**
     * Obtains specified filename within answer
     * @param n array index
     * @return filename
     */
    public String getMyArrayElement(int n){
        return myArray[n];
    }

    //private methods --------------------------------------------------
    //increments guess number until end of row is reached (resets)
    private void guessIncrement(){
        numGuessesSoFar++;
        if(numGuessesSoFar == game.getGuessNum()){
            numGuessesSoFar = numGuessesSoFar - game.getGuessNum();
        }
    }
} 