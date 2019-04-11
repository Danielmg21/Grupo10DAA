package Voraz;

public class hortelano  {
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
    public static void main(String[] args){
        int huertas [][]={{3,8,2,3,1},{1,2,5,6,4}};//huertas[0]= fechas caducidad; huertas[1]=beneficios
        int solucion[];

        hortelano horte = new hortelano();
        //imprimir datos
        System.out.println(" h: ");
        for ( int i=0;i<N;i++){
            System.out.println(i+", ");
        }
        System.out.print("/nfc: ");
        for(int i=0;i<N;i++){
            System.out.print(huertas[1][i]+", ");
        }
        System.out.print("/n");
        //solucion
        solucion = horte.soluVoraz(huertas);
        for(int i=0;i<K;i++){
            System.out.print(solucion[i]+", ");
        }
    }
}
