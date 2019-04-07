package com.company;
import java.util.Scanner;

public class vectoresIgualesHastaN {

    public static void main (String [] args){
        Scanner lector = new Scanner (System.in);
        System.out.println("Escriba el primer vector");
        String v1 = lector.nextLine();
        String [] A = v1.split(" ");
        int [] vA = new int [v1.length()];
        for (int i=0;i<v1.length();i++){
            vA [i] = Integer.parseInt(A[i]);
        }
       System.out.println("Escriba el segundo vector");
        String v2 =lector.nextLine();
        String [] B = v2.split(" ");
        int vB [] = new int [v2.length()];
        for (int i =0;i<v2.length();i++) {
            vB [i] = Integer.parseInt(B[i]);
        }
        int distinto = primerDistinto(vA,vB,0,vA.length-1);
    }

    public static int primerDistinto (int vA[] , int vB [],int ini,int fin){
        if(ini==fin){
            if(vA[ini]==vB[ini]){
                return -1;
            }else{
                return ini;
            }
        }else{
            int medio = (ini+fin)/2;
            int m1 = primerDistinto (vA,vB,ini,medio);
            int m2 = primerDistinto (vA,vB,medio+1,fin);
            if (m1==-1){

            }
        }


    }



}

