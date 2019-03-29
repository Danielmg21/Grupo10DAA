package DyV;

import java.util.Scanner;

public class Digito {
    public static void main(String[] args) {
        int numero;
        int digito;

        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduzca cifra: ");
        numero = entrada.nextInt();
        System.out.print("Introduzca digito: ");
        digito = entrada.nextInt();
        System.out.println("Trabajando...");
        int nuevonumero = DyV(numero, digito);
        System.out.println("Nuevo numero: "+ nuevonumero);
    }

    public static int DyV(int numero, int digito) {
        int resto;
        //caso base (dos cifras)
        if (numero < 10) {
            if (numero > digito)
                return (digito * 10) + numero;
            else
                return (numero * 10) + digito;
            //caso recursivo (mas de una cifra y no solucion todavia)
        } else {
            resto = numero % 10;
            if (resto < digito) {
                return (numero * 10) + digito;
            } else {
                numero = numero / 10;
                return DyV(numero, digito)*10 + resto;
            }
        }
    }
}
