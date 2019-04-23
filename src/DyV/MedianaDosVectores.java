package DyV;

public class MedianaDosVectores {
    public static int MedianaDosDyV (int A[], int B[], int iniA, int finA, int iniB, int finB) {
        if (iniA==finA) {
            if (A[iniA]<B[iniB])
                return A[iniA];
            else
                return B[iniB];
        }else {
            int mitad1 = (iniA+finA)/2;
            int mitad2 = (iniB+finB)/2;

            if (A[mitad1]==B[mitad2]) {
                return A[mitad1];
            }else if (A[mitad1]<B[mitad2]){
                return MedianaDosDyV (A, B, mitad1+1,finA, iniB, mitad2-1);
            }else {
                return MedianaDosDyV (A, B, iniA,mitad1-1, mitad2+1, finB);
            }
        }
    }
    public static void main(String[] args) {
        int A[]={1,3,10,20,30};
        int B[]={50,60,70,80,90};

        int pos=MedianaDosDyV (A,B, 0, A.length-1, 0, B.length-1);
        System.out.println("Mediana: "+pos);

    }
}
