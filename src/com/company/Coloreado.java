package com.company;

public class Coloreado {

    public static void imprimir (int solucion_colores[]) {
        for (int i=0; i<solucion_colores.length; i++) {
            System.out.print (solucion_colores[i]+" ");
        }
        System.out.println ("");
    }

    public static boolean esFactible (boolean g[][], int m,
                                      int solucion_colores[], int etapa, int intento) {

        for (int nodo=0; nodo<g.length; nodo++) {
            if ((g[nodo][etapa]) && (solucion_colores[nodo]==intento))
                return false;
        }

        return true;

    }
    public static boolean BT (boolean g[][], int m, int solucion_colores[], int etapa) {
        boolean exito = false;
        for (int intento=1; intento<=m && !exito; intento++) {
            if (esFactible (g,m,solucion_colores, etapa, intento)) {
                solucion_colores[etapa]=intento;
                if (etapa==solucion_colores.length-1) {
                    exito=true;
                }else {
                    exito=BT (g, m, solucion_colores, etapa+1);
                }

                if (!exito) {
                    solucion_colores[etapa]=0;
                }
            }
        }

        return exito;
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

        int m=2;

        int solucion_colores[] = new int [8];

        boolean exito = BT (g, m, solucion_colores, 0);
        if (exito) {
            imprimir (solucion_colores);
        }else {
            System.out.println ("No hay solucion para "+m+" colores");
        }
    }

}
