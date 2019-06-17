package examen;

import java.util.Scanner;

public class Pacto {
    public static void main (String []args){
        Scanner lector = new Scanner(System.in);
        String linea = lector.nextLine();
        int partidos = Integer.parseInt(linea);
        String nombre [] = new String [5];
        int diputados [] = new int [5];
        int beneficio [] = new int [5];
        int mayoria = 0;
        for (int i =0;i<partidos;i++){
            linea = lector.nextLine();
            String trozos [] = linea.split(" ");
            nombre [i] = trozos[0];
            diputados[i]= Integer.parseInt(trozos[1]);
            beneficio[i]= Integer.parseInt(trozos[2]);
            mayoria = mayoria + diputados[i];
        }
        mayoria= (mayoria/2)+1;
        double [] benDip  = new double [partidos];
        for (int i =0;i<partidos;i++){
            benDip [i] = beneficio[i]/diputados[i];
        }
        benDip[ganador(diputados)]=0;
        String solucion [] = new String [partidos];
        voraz(nombre,diputados,beneficio,benDip,solucion,mayoria);
        for (int i=0;i<partidos;i++){
            System.out.println(solucion[i]);
        }
    }

    public static void ordenar (String[] nombre,int[]diputados,int[]beneficios,double[]benDip){
        for (int i=0;i<nombre.length;i++){
            for(int j=0;j<nombre.length-1;j++){
                if(benDip[j]<benDip[j+1]){

                    String aux = nombre[j];
                    nombre[j]=nombre[j+1];
                    nombre[j]=aux;

                    int aux1 = diputados [j];
                    diputados[j]=diputados[j+1];
                    diputados[j+1]=aux1;

                    int aux2 = beneficios[j];
                    beneficios[j]=beneficios[j+1];
                    beneficios[j+1]=aux2;

                    double aux3 = benDip[j];
                    benDip[j]= benDip[j+1];
                    benDip[j+1]=aux3;
                }
            }
        }

    }
    public static int ganador (int diputados[]){
        int relativo=0;
        int posicion=0;
        for(int i=0;i<diputados.length;i++){
            if(relativo<diputados[i]){
                relativo=diputados[i];
                posicion=i;
            }
        }
        return posicion;
    }

    public static void voraz (String []nombre,int[]diputados,int[]beneficio,double[]benDip,String[]solucion,double mayoria){
        ordenar(nombre,diputados,beneficio,benDip);
        int gobierno = 0;
        for (int i=0;i<nombre.length;i++){
            gobierno = diputados[i] + gobierno;
            if(gobierno<=mayoria){
                solucion[i]=nombre[i];
            }
        }
    }
}
