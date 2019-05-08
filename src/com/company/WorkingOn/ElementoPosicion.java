package com.company.WorkingOn;

import java.util.Scanner;

public class ElementoPosicion {
    public static void main (String []args){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introducir Array: ");
        String strvector = entrada.nextLine();
        String[] splited = strvector.split(" ");
        int[] intvector = new int[splited.length];
        for (int i = 0; i< splited.length; i++){
            intvector[i] = Integer.parseInt(splited[i]);
        }
        System.out.print("Introducir elemento buscado: ");
        int elementoP = entrada.nextInt();
        imprimir(intvector);
        System.out.println("Elemento buscado: "+ elementoP);

    }
    public static void imprimir (int[] salida){
        System.out.print("Array: (");
        for(int i = 0; i<salida.length-1; i++){
            System.out.print(salida[i]+ ", ");
        }
        System.out.println(salida[salida.length-1]+")");
    }
}
