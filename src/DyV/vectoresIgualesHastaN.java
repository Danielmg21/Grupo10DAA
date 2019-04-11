package DyV;
import java.util.Scanner;

public class vectoresIgualesHastaN {

    public static void main (String [] args){
        Scanner lector = new Scanner (System.in);
        System.out.println("Escriba el primer vector");
        String v1 = lector.nextLine();
        String [] A = v1.split(" ");
        int [] vA = new int [A.length];
        for (int i=0;i<A.length;i++){
            vA [i] = Integer.parseInt(A[i]);
        }
       System.out.println("Escriba el segundo vector");
        String v2 =lector.nextLine();
        String [] B = v2.split(" ");
        int vB [] = new int [B.length];
        for (int i =0;i<B.length;i++) {
            vB [i] = Integer.parseInt(B[i]);
        }
        int posicion = DyV(vA,vB,0,vA.length);
        System.out.println(posicion+1);
    }

    public static int DyV (int a[] , int b[],int ini,int fin){
        if(ini==fin){
            if(a[ini]!=b[ini]){
                return ini;
            }else{
                return -1;
            }
        }else{
            int medio = (ini+fin)/2;
            if(a[medio]==b[medio]){
                return DyV(a,b,medio+1,fin);
            }else{
                int posicionAux = DyV(a,b,ini,medio-1);
                if ((posicionAux<medio)&&(posicionAux!=-1)){
                    return posicionAux;
                }else{
                    return medio;
                }
            }
        }
    }



}

