//match col and position, increment counter
//add matches to yeeted array
//match col (if col && if not in yeeted array, increment counter)



import java.util.Random;

public class colourCode{

    Random rand = new Random();
    String codeArray[] = new String[game.getGuessNum()];
    
    public colourCode(){
        
    }
    
    public String[] initCode(int n){
        for(int i = 0; i < n; i++){
            codeArray[i] = GUI.getPic(rand.nextInt(7)).getFilename();
        }
        for(int b = 0; b < n; b++){
            System.out.println(""+codeArray[b]);
        }
        return codeArray;
    }

    public int colAndPlaceCount(String _myArray[], String _codeArray[]){
        int nColAndPlace = 0;
        int colourCount[] = new int[GUI.getNumButtons()];

        
        for(int i = 0; i < game.getGuessNum(); i++){
            if(_myArray[i] == _codeArray[i]){
                nColAndPlace++;
                //add to array and if in 
            }
        }
        return nColAndPlace;
    }



    public int colCount(String _MyArray[], String _codeArray[]){
        
        //find out how many are in the whole thing == nCol(double loop)
        //then take away how many are in the correct position == neither

        
        return nCol;
    }

    public String[] getCodeArray(){
        return codeArray;
    }

    
}