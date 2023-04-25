package org.havelsan.turtules_path;

import java.util.ArrayList;
import java.util.List;

public class TurtulesPath {
    private List<String> validPaths=new ArrayList<>();
    private int n;
    private int m;
    private int matrix[][];

    public TurtulesPath(int n,int m , List<int[]> inputs){
        matrix = new int[n][m];
        this.n=n;
        this.m=m;
        for(int i=0;i<n;i+=1){
            for(int j=0;j<m;j+=1){
                matrix[i][j]=inputs.get(i)[j];
            }
        }
        if( checkPrime(matrix[0][0])){
            pathFinder(0,0,"");
        }
        System.out.println();
    }
    public List<String> getValidPaths(){
       return this.validPaths;
    }

    private void pathFinder(int x,int y,String currentPath){
        currentPath+="|"+(x)+","+(y);
        if(x+1<m){
            int value = matrix[y][x + 1];
            if(checkPrime(value)){
                pathFinder(x+1,y,currentPath);
            }
        }
        if(y+1<n){
            int value = matrix[y+1][x];
            if(checkPrime(value)){
                pathFinder(x,y+1,currentPath);
            }
        }
        if(x+1<m && y+1<n){
            int value = matrix[y+1][x + 1];
            if(checkPrime(value)){
                pathFinder(x+1,y+1,currentPath);
            }
        }
        if(x+1==m && y+1 ==n){
            validPaths.add(currentPath);
        }
    }

    private boolean checkPrime(int n){
        if (n <= 1)
            return false;

        for (int i = 2; i < n; i+=1)
            if (n % i == 0)
                return false;

        return true;
    }
}
