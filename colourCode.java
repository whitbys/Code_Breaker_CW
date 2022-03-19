import java.util.Random;

public class colourCode{

    Random rand = new Random();
    String codeArray[] = new String[game.getGuessNum()];
    String OGcodeArray[] = new String[game.getGuessNum()];
    
    //constructor
    public colourCode(){
    }
    
    
    
    
    
    
    
    //initialisers-----------------------------------------------------
    public void initCode(int n){
        for(int i = 0; i < n; i++){
            codeArray[i] = GUI.getPic(rand.nextInt(7)).getFilename();
            
            
            
            OGcodeArray[i] = GUI.getPic(rand.nextInt(7)).getFilename();
            System.out.println(""+codeArray[i]);

        }
        for(int j = 0; j < n; j++){
            OGcodeArray[j] = codeArray[j];
        }
        
    }

    //getters----------------------------------------------------------
    public String[] getCodeArray(){
        return codeArray;
    }

    public String[] getOGCodeArray(){
        return OGcodeArray;
    }

    public void setCodeArrayElement(int n, String s){
        codeArray[n] = s;
    }

    public String getCodeArrayElement(int n){
        return codeArray[n];
    }

    public String getOGCodeArrayElement(int n){
        return OGcodeArray[n];
    }
} 

  
