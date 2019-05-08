package DyV;

import java.util.Scanner;

public class Kesimo {

    public static int particion2(int v[], int ini, int fin) {
        int p, q;
        int k;
        int aux;
        int pivote = v[(ini+fin)/2];
        p=ini;k=ini;q=fin;
        while (k<=q)
        {
            if (v[k] == pivote) {
                k = k+1;
            }else if (v[k] < pivote) {
                aux = v[p];
                v[p] = v[k];
                v[k] = aux;
                p= p+1; k=k+1;
            }
            else {
                aux = v[q];
                v[q] = v[k];
                v[k] = aux;
                q=q-1;
            }
        }
        return p;
    }

    public static int kesimo_maspequeno (int v[], int k) {
        int pivote=particion2 (v, 0, v.length-1);

        if (pivote==k) {
            return v[pivote];
        }else if (k<pivote) {
            int v_aux[] = new int [pivote];
            for (int i=0; i<pivote; i++) {
                v_aux[i] = v[i];
            }
            return kesimo_maspequeno (v_aux,k);
        }else {
            int v_aux[] = new int [v.length-(pivote)];
            int cont=0;
            for (int i=pivote+1; i<v.length; i++) {
                v_aux[cont] = v[i];
                cont++;
            }
            return kesimo_maspequeno (v_aux,k-pivote);
        }
    }


    public static void main (String args[]) {
        //int []v={2, 40, 2,3,5, 6,7,7,5,6,4,678,1, 0};
        //int v[] =  {51,23,6,72,100};
        
        Scanner entrada = new Scanner (System.in);
        int tam = Integer.parseInt(entrada.nextLine());
        int v[] = new int [tam];
        String datos = entrada.nextLine();
        String trozos[] = datos.split(" ");
        for (int i=0; i<trozos.length; i++) {
            v[i]=Integer.parseInt(trozos[i]);
        }
        int k = Integer.parseInt(entrada.nextLine());
        int numero = kesimo_maspequeno (v, k-1);

        System.out.print (numero);
/*
10
579 271 83 657 404 559 289 232 553 542
4
*/

    }
}
