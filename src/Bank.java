import java.util.Map;
import java.util.TreeMap;

public class Bank{
    
    TreeMap<String, Integer[][]> pokeStorage = new TreeMap<>();

    public Bank() {
        pokeStorage.put("pika", Pokemon.pika);
        pokeStorage.put("dratini", Pokemon.dratini);
    }

    public String checkBankStorage(){
        if(pokeStorage.size() == 0){
            return "Your do not have any POK'eMON in your bank";
        }else{
            String output = "";
            for(Map.Entry<String, Integer[][]> entry : pokeStorage.entrySet()){
                output += "\n - " + entry.getKey().toUpperCase();
            }
            return output;   
        }
    }
}