package org.havelsan.hut_star_pattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.lang.Object.*;

public class HutStarPattern {

    public static String run(Integer n){
        List<String> strPattern = new ArrayList<>();

        if(n<5){
            return null;
        }

        else{
            int spacesCount = n*2-2;
            for(int i = 0; i<n;i+=1){

                String line = "";
                if(spacesCount>0){
                 line = String.join("", Collections.nCopies(spacesCount, String.valueOf(' ')));
                }

                for(int j = 0;j<i*2;j+=1){

                    line+="* ";
                }
                if(spacesCount>0){
                    line+="*"+String.join("", Collections.nCopies(spacesCount, String.valueOf(' ')));
                }
                spacesCount-=2;
                if(i == n-1){
                    line+="*";
                }

                strPattern.add(line);
            }
            int totalLength = strPattern.get(0).length();
            for(int i=0;i<3;i+=1){
                strPattern.add("* * *"+String.join("", Collections.nCopies(totalLength-10, String.valueOf(' ')))+"* * *");

            }
        }

        return String.join("\n", strPattern);
    }
}
