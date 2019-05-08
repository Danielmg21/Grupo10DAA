package BT;

public class laberinto {
    public static int [] mov_rel_x = {-1,0,0,1};
    public static int [] mov_rel_y = {0,-1,1,0};

    public static void imprimir (char tablero[][]){
        System.out.println();
        for(int i =0;i<tablero.length;i++){
            for(int j =0;j<tablero.length;j++){
                System.out.print(tablero[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void copiar (char tablero[][],char mejorTablero[][]){
            int contX=0;
            for(int i=0;i<mejorTablero.length;i++){
                for(int j=0;j<mejorTablero.length;j++){
                    mejorTablero[i][j]=tablero[i][j];
                    if(mejorTablero[i][j]=='X'){
                        contX++;
                    }
                }
            }
            System.out.println("Nueva solucion con "+contX+" pasos");
    }

    public static boolean esMejor (char tablero[][],char mejorTablero[][]){
        int contx1=0;
        for(int i=0;i<tablero.length;i++){
            for(int j=0;j<tablero.length;j++){
                if(tablero[i][j]=='X'){
                    contx1++;
                }
            }
        }
        int contx2=0;
        for(int i=0;i<mejorTablero.length;i++){
            for(int j=0;j<mejorTablero.length;j++){
                if(mejorTablero[i][j]=='X'){
                    contx2++;
                }
            }
        }

        return (contx1<contx2);


    }
    public static boolean esFactibleMejor (char tablero[][],int nuevax,int nuevay,char mejorTablero[][]){
        if((nuevax<0)||(nuevax >= tablero.length)||(nuevay<0)||(nuevay >= tablero.length))
            return false;
        if((tablero[nuevax][nuevay]=='M')||(tablero[nuevax][nuevay]=='E')||(tablero[nuevax][nuevay]=='X'))
            return false;
        if (esMejor (mejorTablero,tablero)){
            return false;
        }
        return true;
    }

    public static boolean esFactible (char tablero[][],int etapax,int etapay,int numPaso,int nuevax,int nuevay){
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
            if (esFactible(tablero,etapax,etapay,numPaso,nuevax,nuevay)){
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

    public static void BTtodas (char tablero[][],int etapax,int etapay,int numPaso){
        for (int intento=0;intento< mov_rel_x.length;intento++){
            int nuevax = etapax+mov_rel_x[intento];
            int nuevay = etapax+mov_rel_y[intento];
            if (esFactible(tablero,etapax,etapay,numPaso,nuevax,nuevay)){
                if(tablero[nuevax][nuevay]=='S'){
                    System.out.println("Solucion encontrada");
                    imprimir(tablero);
                }else{
                    tablero[nuevax][nuevay]='X';
                    BTtodas(tablero,nuevax,nuevay,numPaso+1);
                    tablero[nuevax][nuevay]=' ';
                }
            }
        }
    }

    public static void BTMejor (char tablero[][],int etapax,int etapay,int numPaso,char mejorTablero[][]){
        for (int intento=0;intento<mov_rel_x.length;intento++){
            int nuevax = etapax+mov_rel_x[intento];
            int nuevay = etapay+mov_rel_y[intento];
            if(esFactibleMejor(tablero,nuevax,nuevay,mejorTablero)){
                if(tablero[nuevax][nuevay]=='S'){
                    if(esMejor(tablero,mejorTablero)){
                        copiar(tablero,mejorTablero);
                    }
                }else{
                    tablero[nuevax][nuevay]='X';
                    BTMejor(tablero,nuevax,nuevay,numPaso+1,mejorTablero);
                    tablero[nuevax][nuevay]=' ';
                }
            }
        }
    }
    public static void main(String[] args) {
        char tablero [][] = new char[9][9];
        for(int i = 0;i<tablero.length;i++){
            for(int j =0;j<tablero.length;j++){
                tablero[i][j] = 'O';
            }
        }
        tablero[0][0] = 'E'; //Entrada al laberito
        tablero[8][8] = 'S'; //Salida del laberinto

        tablero[1][1] = 'M';
        tablero[1][2] = 'M';
        tablero[1][3] = 'M';
        tablero[1][4] = 'M';
        tablero[1][5] = 'M';

        System.out.println("Tablero inicial: ");
        imprimir(tablero);
    /*
        boolean exito = BT (tablero,0,0,1);
        if(exito){
            imprimir (tablero);
        }else{
            System.out.println("No hay solucion");
        }
        */
        char mejorTablero [][] = new char [9][9];
        for (int i=0;i<mejorTablero.length;i++){
            for(int j=0;j<mejorTablero.length;j++){
                mejorTablero[i][j]='X';
            }
        }
        mejorTablero[0][0] = 'E';
        mejorTablero[8][8] = 'S';

        mejorTablero[1][1] = 'M';
        mejorTablero[1][2] = 'M';
        mejorTablero[1][3] = 'M';
        mejorTablero[1][4] = 'M';
        mejorTablero[1][5] = 'M';

        System.out.println("Tablero mejor inicial: ");
        imprimir(mejorTablero);

        BTMejor(tablero,0,0,1,mejorTablero);
        System.out.println("El mejor tablero es: ");
        imprimir(mejorTablero);
    }
}
