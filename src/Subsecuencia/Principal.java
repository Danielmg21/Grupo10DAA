package Subsecuencia;

public class Principal {

   /* private static SubSecuencia busquedaDyVRec(int[] a,int prim, int ult) {
        // aplicamos el algoritmo directo
        if (ult==prim) {
            SubSecuencia aux = new SubSecuencia ();
            aux.der=prim;
            aux.izq=ult;
            aux.suma=a[prim];
            return aux;
        }
        // caso recursivo
        int mitad=(ult+prim) / 2;
        SubSecuencia sIzq =busquedaDyVRec(a, prim, mitad);
        SubSecuencia sDer =busquedaDyVRec(a, mitad+1, ult);
        SubSecuencia mejorSol = SubSecuencia.max(sIzq,sDer);

        // recombinación de las soluciones

        // busca la mejor secuencia en la parte izquierda
        int sumaIzqMitad=Integer.MIN_VALUE;
        int izq=-1;
        int suma = 0;
        for(int i=mitad; i>=prim; i--) {
            suma += a[i];
            if (suma > sumaIzqMitad) {
                // nueva mejor suma
                izq=i;
                sumaIzqMitad=suma;
            }
        }

        // busca la mejor secuencia en la parte derecha
        int sumaDerMitad=Integer.MIN_VALUE;
        int der=-1;
        suma = 0;
        for (int j=mitad+1; j<=ult; j++) {
            suma += a[j];
            if (suma > sumaDerMitad) {
                // nueva mejor suma
                der=j; sumaDerMitad=suma;
            }
        }

        // la secuencia central es la mejor?
        if (sumaDerMitad+sumaIzqMitad > mejorSol.suma) {
            mejorSol.suma = sumaDerMitad + sumaIzqMitad;
            mejorSol.izq = izq;
            mejorSol.der = der;
        }
        // retorna la mejor secuencia encontrada
        return mejorSol;
    }
    public static SubSecuencia busquedaDyV(int[] a){
        return busquedaDyVRec (a, 0, a.length-1);
    }

    public static SubSecuencia busquedaLineal( int [] a){
        SubSecuencia mejorSol = new SubSecuencia();
        int suma=0; int inicioSección=0;
        // calcula todas las sumas para cada elemento
        for (int i=0; i<a.length; i++) {
            suma += a[i];
            // suma = a[inicioSección]+...+a[i]
            if (suma>mejorSol.suma) {
                mejorSol.izq =inicioSección;
                mejorSol.der=i;
                mejorSol.suma=suma;
            }
            if (suma<=0) {
                // si la suma hasta i no es positiva, esa parte
                // del vector no entra en la suma máxima
                inicioSección=i+1;
                suma=0;
            }
        }
        return mejorSol;
        // retorna la mejor solución
    }

    public static void main(String[] args) {
        int generadores[] = {5,-6,5,-2,20,7,-4,39};

        SubSecuencia solucion = busquedaDyV (generadores);
        System.out.println ("Sustituimos desde: "+solucion.izq+" hasta "+solucion.der+" con valor: "+solucion.suma);

        solucion = busquedaLineal (generadores);
        System.out.println ("Sustituimos desde: "+solucion.izq+" hasta "+solucion.der+" con valor: "+solucion.suma);

    }
*/
}
