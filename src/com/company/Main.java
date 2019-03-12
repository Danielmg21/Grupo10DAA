package com.company;



public class Main {
    //Pon ejn comentarios los main para que solo se ejecute el que quieras
    // Main del saltoCaballo
        /*public static void main(String[] args) {
            int [][]tablero = new int [5][5];
            tablero[1][1] = 1;
            saltoCaballo s = new saltoCaballo();
            boolean exito = s.BT (tablero,2,1,1);
            if (exito){
                s.imprimir (tablero);
            }
        }*/

    public static void main(String[] args) {
        // Main partir vector
        partirVector p = new partirVector();
        int v [];
        v = new int [] {4,2,6,1,1,2};
        p.partirenDos(v);
    }







}