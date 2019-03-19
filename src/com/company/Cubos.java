package com.company;

import java.util.ArrayList;

public class Cubos {
    public static int N=4;
    public static String palabra = "hola";
    public static String cubos[]= new String[N];


    public static void imprimir (int sol[]) {
        for (int i=0; i<sol.length; i++) {
            System.out.print (sol[i]+" ");
        }
        System.out.println ("");
    }
    public static boolean buscaCadena (int sol[], int k, ArrayList<Integer> cubosLibres) {
        //sol[k]=intento?? intento es un cubo determinado

        char letra_a_buscar = palabra.charAt(k);

        return true;
    }
    public static void main(String[] args) {
        int sol [] = new int [N];
        ArrayList<Integer> cubosLibres = new ArrayList<Integer>();
        for (int i = 0; i<N; i++) {
            cubosLibres.add (i);
        }
        cubos[0]="abcdef";
        cubos[1]="ghijkl";
        cubos[2]="mnopqr";
        cubos[3]="lxyvwz";



        boolean exito = buscaCadena (sol, 0, cubosLibres);
        if (exito) {
            imprimir (sol);
        }else {
            System.out.println ("No hay solucion");
        }

        for (int i=0; i<palabra.length(); i++) {
            System.out.println (palabra.charAt(i));
        }
    }

}
