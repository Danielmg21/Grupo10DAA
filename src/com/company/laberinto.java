package com.company;

public class laberinto {
    public static int [] mov_rel_x = {-1,0,0,1};
    public static int [] mov_rel_y = {0,1,-1,0};

    public static void imprimir (char tablero[][]){
        System.out.println();
        for(int i =0;i<tablero.length;i++){
            for(int j =0;j<tablero.length;j++){
                System.out.print(tablero[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static boolean esFactible (char tablero[][],int etapax,int etapay,int numPaso,int nuevax,int nuevay,int intento){
        if((nuevax<0)||(nuevax>=tablero.length)||(nuevay<0)||(nuevay>=tablero.length))
            return false;
        if((tablero[nuevax][nuevay]=='M')||(tablero[nuevax][nuevay]=='E')||(tablero[nuevax][nuevay]=='X'))
            return false;
        return true;
    }

    public static boolean BT (char tablero[][],int etapax,int etapay,int numPaso){
        boolean exito = false;
        for (int intento=0;intento<mov_rel_x.length&&!exito;intento++){
            int nuevax = etapax+mov_rel_x[intento];
            int nuevay = etapay+mov_rel_y[intento];
            if (esFactible(tablero,etapax,etapay,numPaso,nuevax,nuevay,intento)){
                if(tablero[nuevax][nuevay]=='S'){
                    exito=true;
                }else{
                    tablero[nuevax][nuevay]='X';
                    exito = BT(tablero,nuevax,nuevay,numPaso+1);
                }
                if(!exito){
                    tablero[nuevax][nuevay]=' ';
                }
            }
        }
        return exito;
    }

}
