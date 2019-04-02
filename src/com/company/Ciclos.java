package com.company;

public class Ciclos {
    public static boolean esFactible (boolean g[][], int k, int sol[], boolean visitados [], int intento) {
        int origen = sol[k-1];
        int destino = intento;

        if (g[origen][destino]==false)
            return false;

        if ((visitados[destino]) && (k<sol.length-1))
            return false;

        if ((k==sol.length-1) && (destino!=sol[0]))
            return false;

        return true;
    }

    public static void ciclos (boolean g[][], int k, int sol[], boolean visitados []) {
        for (int intento=0; intento<g.length; intento++) {
            boolean esFactible=true;
            int origen = sol[k-1];
            int destino = intento;

            if (g[origen][destino]==false)
                esFactible= false;

            if ((visitados[destino]) && (k<sol.length-1))
                esFactible= false;

            if ((k==sol.length-1) && (destino!=sol[0]))
                esFactible= false;

            if (esFactible) {
                sol[k]=intento;
                visitados[intento]=true;
                if (k==sol.length-1) {
                    imprimir (sol);
                }else {
                    ciclos (g,k+1,sol,visitados);
                }
                sol[k]=0;
                visitados[intento]=false;

            }
        }
    }


    public static void imprimir (int sol[]) {
        for (int i=0; i<sol.length; i++) {
            System.out.print ((sol[i]+1)+" ");
        }
        System.out.println ();
    }









    public static void main(String[] args) {
        boolean g[][] = new boolean [8][8];
        g[0][1]=true;
        g[0][6]=true;
        g[1][0]=true;
        g[6][0]=true;

        g[1][5]=true;
        g[5][1]=true;

        g[2][3]=true;
        g[2][4]=true;
        g[3][2]=true;
        g[4][2]=true;

        g[3][5]=true;
        g[5][3]=true;

        g[5][6]=true;
        g[6][5]=true;

        g[6][7]=true;
        g[7][6]=true;

        g[4][7]=true;
        g[7][4]=true;

        int sol[] = new int [9];
        boolean visitados[] = new boolean [9];
        sol[0]=0;
        visitados[0]=true;

        ciclos (g,1, sol, visitados);


    }

}
