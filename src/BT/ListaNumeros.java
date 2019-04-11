package BT;

public class ListaNumeros {

    public static void copiar (boolean solucion[], boolean solucionMejor[]) {
        for (int i=0; i< solucion.length; i++) {
            solucionMejor[i]=solucion[i];
        }
    }
    public static boolean esMejorSolucion (boolean solucion[], boolean solucionMejor[]) {
        int cont1=0;
        int cont2=0;

        for (int i=0; i< solucion.length; i++) {
            if (solucion[i]) {
                cont1++;
            }
        }

        for (int i=0; i< solucionMejor.length; i++) {
            if (solucionMejor[i]) {
                cont2++;
            }
        }
        return (cont1<=cont2);

    }

    public static boolean esSolucion (int l[], int s, boolean solucion[]) {
        int acu=0;
        for (int i=0; i< solucion.length; i++) {
            if (solucion[i]) {
                acu = acu + l[i];
            }
        }

        return (acu == s);
    }

    public static boolean esFactible (int l[], int s, boolean solucion[],
                                      boolean solucionMejor[], int k, int intento) {
        int lo_que_ya_llevo_seleccionado = 0;
        for (int i=0; i< solucion.length; i++) {
            if (solucion[i]) {
                lo_que_ya_llevo_seleccionado = lo_que_ya_llevo_seleccionado + l[i];
            }
        }

        if (intento==2) //Lo quiero
            lo_que_ya_llevo_seleccionado = lo_que_ya_llevo_seleccionado + l[k];

        if (lo_que_ya_llevo_seleccionado>s) {
            return false;
        }

        if ((lo_que_ya_llevo_seleccionado<s) && (k==l.length-1))
            return false;

        //Poda
        int cont1=0;
        int cont2=0;

        for (int i=0; i< solucion.length; i++) {
            if (solucion[i]) {
                cont1++;
            }
            if (solucionMejor[i]) {
                cont2++;
            }
        }

        if (intento==2)
            cont1++;

        if (cont2<cont1)
            return false;

        return true;
    }
    public static void BTMejor (int l[], int s, boolean solucion[], boolean solucionMejor[], int k) {
        for (int intento=1; intento<=2; intento++) {
            if (esFactible (l,s,solucion,solucionMejor, k, intento)) {
                if (intento==2) {
                    solucion[k]=true;
                }
                if (esSolucion (l, s, solucion)) {
                    if (esMejorSolucion (solucion, solucionMejor)) {
                        copiar (solucion, solucionMejor);
                    }
                }else { //Si no es solución
                    if (k<l.length-1) {
                        BTMejor (l,s,solucion, solucionMejor, k+1);
                    }
                }
                solucion[k]=false;
            }
        }

    }
    public static void imprimir (int l[], boolean solucionMejor[]) {
        for (int i=0; i<solucionMejor.length;i++) {
            if (solucionMejor[i])
                System.out.print (l[i]+" ");
        }
        System.out.println ("");

    }
    public static void main(String[] args) {
        int l[] = {1,2,3,5,6,7,9};
        int s = 13;

        boolean solucion[] = new boolean [l.length];
        boolean solucionMejor[] = new boolean [l.length];
        for (int i=0; i<solucionMejor.length; i++) {
            solucionMejor[i]=true;
        }

        BTMejor (l,s,solucion,solucionMejor, 0);

        imprimir (l,solucionMejor);
    }



}
