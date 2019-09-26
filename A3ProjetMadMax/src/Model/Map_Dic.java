package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Map_Dic {
    public boolean findWord(String message) {
        String dic[] = {"ceci", "test", "encore", "autre"};
        String split[] = message.split(" ");
        boolean isGood = false;
        int i = 0;
        int goodWord = 0;

        while (!isGood && i < split.length) {
            for(int j = 0; j < dic.length; j++) {
                if(split[i].equals(dic[j])) {
                    goodWord++;
                }
            }
            i++;
        }
        if(goodWord == split.length){
            isGood = true;
        }
        return isGood;
    }
}
