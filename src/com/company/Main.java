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

   /* public static void main(String[] args) {
        // Main partir vector
        partirVector p = new partirVector();
        int v [];
        v = new int [] {4,2,6,1,1,2};
        p.partirenDos(v);
    }
 */

    /*public static void main(String[] args){
        laberinto l = new laberinto();
        char tablero [][] = new char[10][10];
        tablero[0][0] = 'E'; //Entrada al laberito
        tablero[9][9] = 'S'; //Salida del laberinto

        tablero[1][1] = 'M';
        tablero[1][2] = 'M';
        tablero[1][3] = 'M';
        tablero[1][4] = 'M';
        tablero[1][5] = 'M';

        boolean exito = l.BT (tablero,0,0,1);
        if(exito){
            l.imprimir (tablero);
        }else{
            System.out.println("No hay solucion");
        }
    }*/
    /*public static void main(String[] args){
        int huertas [][]={{3,8,2,3,1},{1,2,5,6,4}};//huertas[0]= fechas caducidad; huertas[1]=beneficios
        int solucion[];

        hortelano horte = new hortelano();
        //imprimir datos
        System.out.println(" h: ");
        for ( int i=0;i<N;i++){
            System.out.println(i+", ");
        }
        System.out.print("/nfc: ");
        for(int i=0;i<N;i++){
            System.out.print(huertas[1][i]+", ");
        }
        System.out.print("/n");
        //solucion
        solucion = horte.soluVoraz(huertas);
        for(int i=0;i<K;i++){
            System.out.print(solucion[i]+", ");
        }
    }
*/


}