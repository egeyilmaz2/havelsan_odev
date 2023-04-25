package org.havelsan.pairs;

import java.util.Objects;
import java.util.Scanner;

public class Pairs {

    public static int run(int actualLength,int intArray[]){
        int count=0;

        for(int i=0;i<actualLength;i+=1){
            int j = i+1;

            while(j<actualLength){
                int abs = Math.abs(intArray[i] - intArray[j]);
                if(abs == (((i+1)*(i+1))+((j+1)*(j+1)))){
                    count+=1;
                }
                j+=1;
            }
        }

        return count;
    }

}
