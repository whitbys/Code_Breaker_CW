import java.util.Random;

/**
 * Class to provide the computers code
 * (which is to be "cracked" by the user in-game)
 */
public class colourCode{

    Random rand = new Random();
    String codeArray[] = new String[game.getGuessNum()];
    String OGcodeArray[] = new String[game.getGuessNum()];
    
    /**
     * Create new ColourCode class
     */
    public colourCode(){
    }
    
    //public Methods-----------------------------------------------------
    
    /**
     * initiates 2 arrays of the same random colour button filenames
     * @param n number of filenames to put in array
     */
    public void initCode(int n){
        for(int i = 0; i < n; i++){
            codeArray[i] = GUI.getPic(rand.nextInt(7)).getFilename();

        }
        for(int j = 0; j < n; j++){
            OGcodeArray[j] = codeArray[j];
        }
        
    }
    
    /**
     * Obtains touched array of filenames
     * @return array of filenames
     */
    public String[] getCodeArray(){
        return codeArray;
    }

    /**
     * Obtains untouched array of filenames
     * @return array of filenames
     */
    public String[] getOGCodeArray(){
        return OGcodeArray;
    }

    /**
     * sets a specified array element to a specified string
     * @param n array index
     * @param s String value of array element
     */
    public void setCodeArrayElement(int n, String s){
        codeArray[n] = s;
    }

    /**
     * obtains specified array element of touched array
     * @param n array index
     * @return String value of array element
     */
    public String getCodeArrayElement(int n){
        return codeArray[n];
    }

    /**
     * obtains specified array element of untouched array
     * @param n array index
     * @return String value of array element
     */
    public String getOGCodeArrayElement(int n){
        return OGcodeArray[n];
    }
} 

  
