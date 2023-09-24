package Programes;

import java.util.*;

public class practicePage {
        public static void main(String [] args){
         int ar [][]= {{1,2,4},{9999,4,2},{4,88,9}};
            commonELement(ar);
        }

    private static void commonELement(int[][] ar) {
            int min = ar[0][0];
            int max = ar[0][0];

            for(int i=0;i<ar.length;i++){
                for(int j=1;j<=i;j++){
                  if(ar[i][j]>max){
                      max = ar[i][j];
                  }  else if(ar[i][j]<min){
                      min=ar[i][j];
                  }

                }
            }
            System.out.println(min);
        System.out.println(max);

    }




}