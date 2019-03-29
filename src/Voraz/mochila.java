package Voraz;

import java.util.Scanner;

public class mochila {

    public static void Ordenar (int beneficios[], int peso[],String  ids[], double bp[]) {
        for (int veces=0; veces<bp.length; veces++) {
            for (int i=0; i<bp.length-1; i++) {
                if (bp[i]<bp[i+1]) {
                    double aux =bp [i];
                    bp[i]=bp[i+1];
                    bp[i+1]= aux;

                    String aux2 =ids [i];
                    ids[i]=ids[i+1];
                    ids[i+1]= aux2;

                    int aux3 =peso [i];
                    peso[i]=peso[i+1];
                    peso[i+1]= aux3;

                    int aux4 =beneficios [i];
                    beneficios[i]=beneficios[i+1];
                    beneficios[i+1]= aux4;

                }
            }
        }
    }
    public static void Voraz (int beneficios[], int peso[], String ids[], double bp[], double solucion[],
                              double peso_mochila) {
        for (int i=0; i<beneficios.length && peso_mochila!=0; i++) {
            if (peso[i]<=peso_mochila) {
                solucion[i]=1.0;
                peso_mochila=peso_mochila-peso[i];
            }else {
                solucion[i]= peso_mochila/peso[i];
                peso_mochila=0;
            }
        }
    }

    public static void imprimir (String ids[], double solucion[], int peso[], int beneficio[]) {
        double resultado = 0;
        for (int i=0; i<ids.length; i++) {
            if (solucion[i]>0)
                System.out.println("Objeto con id = "+ids[i]+" porcentaje del objeto: "+solucion[i]+ " con peso: "+peso [i] +
                        " y defensa: "+ solucion[i]*beneficio[i]);}
        for(int j = 0; j<ids.length; j++){
            if (solucion[j]>0)
                resultado = resultado + solucion[j]*beneficio[j];
        }
        System.out.println("Defensa total: " + resultado);
    }

    public static void main(String[] args) {
        int numPiezas;
        double pesototal;
        String modo;

        Scanner entrada = new Scanner(System.in);
        System.out.print("Introducir nº piezas: ");
        numPiezas = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Introducir peso: ");
        pesototal = entrada.nextDouble();
        entrada.nextLine();

        System.out.print("Introducir modo: ");
        modo = entrada.nextLine();

        int beneficios [] = new int[numPiezas];
        int peso [] = new int[numPiezas];
        String ids [] = new String[numPiezas];
        double bp[] = new double [numPiezas];

        for(int i=0; i<numPiezas; i++) {
            System.out.print("Introducir pieza(id peso beneficio): ");
            String strvector = entrada.nextLine();
            String[] splited = strvector.split(" ");
            ids[i] = splited[0];
            peso[i] = Integer.parseInt(splited[1]);
            beneficios[i] = Integer.parseInt(splited[2]);
        }
        //Calculamos array bp (beneficio/peso)
        for (int i=0; i< beneficios.length; i++) {
            bp [i] = beneficios[i]/(double)peso[i];
        }
        //Ordenar arrays en base al criterio de mayor beneficio/peso
        Ordenar (beneficios, peso, ids, bp);

        double solucion [] = new double [beneficios.length];
        switch (modo){
            case "ligero":
                pesototal = pesototal * 0.5;
                break;
            case "medio":
                pesototal = pesototal * 0.75;
                break;
            default:
                break;
        }
        Voraz (beneficios, peso, ids, bp, solucion, pesototal);

        imprimir (ids, solucion, peso, beneficios);

    }

}
