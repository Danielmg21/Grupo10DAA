package BT;

public class cuboMágico {
    public static int DameNuevaX(int x,int y,int tablero){
        if(y<8){
            return x;
        }else{
            return x+1;
        }
    }
    public static int DameNuevaY(int x,int y,int tablero ){
        if (y<8){
            return y+1;
        }else{
            return 0;
        }
    }

    public static boolean esFactible (int tablero [][],int etapax, int etapay, int intento){
        for (int i=0;i<tablero.length;i++){
            for(int j=0;j<tablero.length;j++){
                if(tablero[i][j]==intento)
                    return false;
            }
        }
        int sumaFila = 0;
        for(int columna =0;columna<tablero.length;columna++){
            sumaFila=sumaFila+tablero[etapax][columna];
        }
        int sumaColumna =0;
        for(int fila =0;fila<tablero.length;fila++){
            sumaColumna=sumaColumna+tablero[fila][etapay];
        }
        sumaFila=sumaFila+intento;
        sumaColumna=sumaColumna+intento;

        if((sumaFila<15)&&(etapay==tablero.length-1))
            return false;
        if (sumaFila>15)
            return false;
        if((sumaColumna<15)&&(etapax==tablero.length-1))
            return false;
        if (sumaColumna>15)
            return false;
        return true;
    }

    public static boolean BTuna (int tablero [][],int etapax,int etapay){
        boolean exito = false;
        for(int intento=1;intento<=tablero.length*tablero.length && !exito;intento++){
            if(esFactible(tablero,etapax,etapay,intento)){
                tablero[etapax][etapay]=intento;
                if((etapax==tablero.length-1)&&(etapay==tablero.length-1)){
                    exito=true;
                }else{
                    int nuevax = DameNuevaX(etapax,etapay,tablero.length-1);
                    int nuevay = DameNuevaY(etapax,etapay,tablero.length-1);
                    exito=BTuna (tablero,nuevax,nuevay);
                }
            }
            if(!exito){
                tablero[etapax][etapay]=0;
            }
        }
        return exito;
    }
    public static void imprimir (int tablero[][]){
        System.out.println();
        for(int i =0;i<tablero.length;i++){
            for(int j =0;j<tablero.length;j++){
                System.out.print(tablero[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main (String []args){
        int tablero [][]= new int [3][3];
        boolean exito = BTuna(tablero,0,0);
        if (exito){
            imprimir(tablero);
        }else{
            System.out.println("No hay solucion");
        }
    }
}
