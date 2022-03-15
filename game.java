
//put the tryNum and guess num here as static variables
//static reference them in GUI


public class game{
    //includes logic for different levels
    //change gui contructor to be able to input diff amounts of tries and guesses
    

    //gui
    //guess (recording guesses)
    //ColourCode
    

    public static void main(String[] args){
        GUI gui = new GUI();
        
        

        int tN = gui.getTryNum();
        int gN = gui.getGuessNum();

        gui = new GUI(tN, gN);
        
    

    }

    /* public void initCorrectArray(int gN){

    } */
}