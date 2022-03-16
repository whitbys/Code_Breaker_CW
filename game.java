
//put the tryNum and guess num here as static variables
//static reference them in GUI
//now able to make arrays


public class game{
    private static int guessNum = 4;
    private static int tryNum = 6;
    
    
    
    //includes logic for different levels
    //change gui contructor to be able to input diff amounts of tries and guesses
    

    //gui
    //guess (recording guesses)
    //ColourCode
    
    

    public static void main(String[] args){
        String level[] = new String[3];
        level[0] = "EASY";
        level[1] = "MEDIUM";
        level[2] = "HARD";

        GUI gui = new GUI(tryNum, guessNum);
        Guess guess = new Guess();
        ColourCode colourCode = new ColourCode();
        colourCode.initCode();
        
        while(gameOverFlag() != true){
            inputMyArray(Guess.getGuessNum(), gui.whichButtonPressed());
            
            if(newRowFlag()){
                GUI.updateResults(guess.colCheck(Guess.getMyArray(), ColourCode.getAnswerArray()));
                GUI.updateResults(guess.colAndPlaceCheck(Guess.getMyArray(), ColourCode.getAnswerArray()));


                colourCode.initCode();
            }
        }
        
//in update results have a parameter of how many times -> put into for loop





        //gui.getJFrame().dispose();
    }

    /* public void initCorrectArray(int gN){

    } */
    

    


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