package Voraz;

import java.util.Scanner;

public class Activities {
    public static void main(String[] args){
        int numCasos;

        Scanner entrada = new Scanner(System.in);
        System.out.print("Introducir numero de casos: ");
        numCasos = entrada.nextInt();
        int[] numActividades = new int[numCasos];
        entrada.nextLine();
        for(int i = 0; i < numCasos; i++){
            System.out.print("Introducir numero de actividades del caso "+ (i+1) +": ");
            numActividades[i] = entrada.nextInt();
            entrada.nextLine();
            for(int j=0; j<numActividades[i];j++){
                System.out.print("Introducir horario de caso" + (i+1) + ": ");

            }
        }
        imprimir(numCasos);
        imprimir(numActividades);

    }
    public static void imprimir(int[] salida){
        System.out.print("Array: (");
        for (int i = 0; i<salida.length; i++){
            System.out.print(salida[i]+" ");
        }
        System.out.print(")");
    }
    public static void imprimir(int salida){
        System.out.println("Salida: "+ salida);
    }
}
