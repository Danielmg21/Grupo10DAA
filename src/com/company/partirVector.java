package com.company;

public class partirVector {
    public static void partirenDos ( int v[]){
        int sol [] = new int [v.length];
        BTtodas (v,sol,0);
    }

    public static void BTtodas (int v[],int sol [], int etapa){
        for (int intento = 1;intento<=2;intento++){
            if (esFactible(v,sol,etapa,intento)){
                sol [etapa] = intento;
                if (etapa == v.length-1){
                    imprimir (v,sol);
                }else{
                    BTtodas(v,sol,etapa+1);
                }
                sol[etapa]=0;
            }
        }
    }

    public static boolean esFactible (int v [],int sol[],int etapa,int intento){
        int sumaTotal=0;
        for (int i = 0; i<v.length;i++){
            sumaTotal += v[i];
        }
        int sumaA = 0;
        int sumaB = 0;
        for(int i =0; i<etapa;i++){
            if(sol[i]==1){
                sumaA+=v[i];
            }else{
                sumaB+=v[i];
            }
        }
        if(intento==1){
            if(sumaA+v[etapa]>sumaTotal/2){
                return false;
            }
            if((etapa==v.length)&&(sumaA+v[etapa]!=sumaTotal/2)){
                return false;
            }
        }
        if(intento==2){
            if(sumaB+v[etapa]>sumaTotal/2){
                return false;
            }
            if((etapa==v.length)&&(sumaB+v[etapa]!=sumaTotal/2)){
                return false;
            }
        }
        return true;
    }

    public static void imprimir (int v[],int sol[]){
        System.out.println("Equipo1");
        for (int i = 0;i<v.length;i++){
            if(sol[i]==1){
                System.out.print(v[i]+" ");
            }
        }
        System.out.println();
        System.out.println("Equipo2");
        for (int i = 0;i<v.length;i++){
            if(sol[i]==2){
                System.out.print(v[i]+" ");
            }
        }
        System.out.println();
        System.out.println("");
    }

    public static void main(String[] args) {
        // Main partir vector
        partirVector p = new partirVector();
        int v [];
        v = new int [] {4,2,6,1,1,2};
        p.partirenDos(v);
    }
}


