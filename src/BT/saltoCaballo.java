package BT;

public class saltoCaballo {
    public static int movRealX [] = {2,1,-1,-2,-2,-1,1,2};
    public static int movRealY [] = {1,2,2,1,-1,-2,-2,-1};


    public static void imprimir (int tablero[][]){
        for (int i = 0; i < tablero.length;i++){
            for ( int j = 0; j< tablero.length;j++){
                System.out.print(tablero[i][j]+" ");
            }
            System.out.println("");
        }
    }


    public static boolean BT (int [][]tablero,int etapa,int pos_actualX,int pos_actualY) {
        boolean exito = false;
        for (int intento = 0; intento <= 7 && !exito; intento++) {
            int pos_nuevaX = pos_actualX + movRealX[intento];
            int pos_nuevaY = pos_actualY + movRealY[intento];
            if (esFactible(tablero, etapa, pos_nuevaX, pos_nuevaY)) {
                tablero[pos_nuevaX][pos_nuevaY] = etapa;
                if (etapa == 25) {
                    exito = true;
                } else {
                    exito = BT(tablero, etapa + 1, pos_nuevaX, pos_nuevaY);
                }
                if (!exito) {
                    tablero[pos_nuevaX][pos_nuevaY] = 0;
                }
            }
        }return exito;
    }

    public static void BTTodas (int [][]tablero,int etapa,int pos_actualX,int pos_actualY){
        for (int intento = 0;intento<=7;intento++){
            int pos_nuevaX = pos_actualX + movRealX[intento];
            int pos_nuevaY = pos_actualY + movRealY[intento];
            if(esFactible(tablero,etapa,pos_nuevaX,pos_nuevaY)){
                tablero[pos_nuevaX][pos_nuevaY] = etapa;
                if (etapa == 25){
                    imprimir(tablero);
                }else{
                    BT(tablero,etapa+1,pos_nuevaX,pos_nuevaY);
                }
                tablero[pos_nuevaX][pos_nuevaY]=0;
            }
        }
    }

    public static boolean esFactible (int tablero[][],int etapa,int pos_nuevaX,int pos_nuevaY){
        if ((pos_nuevaX>4)||(pos_nuevaX<0)){
            return false;
        }
        if ((pos_nuevaY>4)||(pos_nuevaY<0)){
            return false;
        }
        if (tablero[pos_nuevaX][pos_nuevaY]!=0){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        /*int [][]tablero = new int [5][5];
        tablero[1][1] = 1;
        boolean exito = BT (tablero,2,1,1);
        if (exito){
            imprimir (tablero);
        }
        */

        int [][]tablero2 = new int [5][5];
        tablero2[1][1]=1;
        BTTodas(tablero2,2,1,1);
    }
}

