//clean up stuff:
//change variable names
//add coments
//make functions out of chunks of code
//fix newline mechanic
//fix GUI array size declaration

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
    
    //things to ask:
    //private static, getters and setters for everything
    //change filename


    public static void main(String[] args){
        String level[] = new String[3];
        level[0] = "EASY";
        level[1] = "MEDIUM";
        level[2] = "HARD";

        GUI gui = new GUI(tryNum, guessNum);
        //guess guess = new guess();

        

        
//in update results have a parameter of how many times -> put into for loop





        //gui.getJFrame().dispose();
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


/* if(startPoint == game.getGuessNum()){
    System.exit(0);
    //set startpoint to 1(arbitrary value in range)
    //display success window for 10 seconds 
    //back to settings
    
    
    //settings class : win status panel,high score, etc  + 3 difficulty levels
    //if win -> win screen + setting
    //if lose -> lose screen + setting
} */