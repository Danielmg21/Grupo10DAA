package Subsecuencia;

public class Subsecuencia {
    int suma;
    int izq;
    int der;

    public SubSecuencia() {
        izq=0;
        der=-1;
        suma=Integer.MIN_VALUE;
    }
    public static SubSecuencia max(SubSecuencia s1, SubSecuencia s2){
        if (s1.suma>=s2.suma)
            return s1;
        else
            return s2;
    }

}
