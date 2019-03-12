package com.company;

public class hortelano {
    private static int N = 5;//Num huertas
    private static int K = 8;//maxima caducidad
    private static int Libre = -1;//marca de que no hay huerta asignada;


    private int seleccionCandidato (int h[][]){
        int j=0;
        for(int i=0;i<N;i++){
            if (h[1][i]>h[1][j])
                j=i;
        }
        return j;
    }

    private void quitarCandidato (int h[][],int c){
        h[1][c]=-1; //-1 marca de no hay candidato
    }

    public int []soluVoraz(int h[][]){
        int s[]= new int[K];
        int c,j;
        //inicializa solucion
        for (int i=0;i<K;i++){
            s[i]=Libre;
        }
        for(int i=0;i<N;i++){
            c=seleccionCandidato(h);
            j=h[0][c]-1;//el dia n se anota en la pòsicion n-1
            quitarCandidato(h,c);
            while ((j>0)&&(s[j]!=Libre)){
                j=j-1;
            }
            if ((j>=0)&&(s[j]!=Libre))
                s[j]=c;
        }
        return s;
    }


}
