package DyV;

import java.util.ArrayList;
import java.util.List;

public class DistanciaK {
    public DistanciaK() {
    }

    public static List<Integer> distanciaK(List<Integer>[] g, int origen, int destino, int distancia) {
        List<Integer> recorrido = new ArrayList<>(g.length);
        boolean[] visitados = new boolean[g.length];

        visitados[origen] = true;
        recorrido.add(origen);
        boolean exito=distanciaK (g, origen, destino, distancia, visitados, recorrido);

        return recorrido;
    }



    public static boolean distanciaK(List<Integer>[] g, int origen, int destino, int distancia,
                                     boolean[] visitados, List<Integer> recorrido) {

        boolean exito=false;

        for (int adj : g[origen]) {
            if ((!visitados[adj]) && (distancia>0)){ //Factible
                visitados[adj] = true;//Marcar
                recorrido.add(adj);//Marcar

                if (distancia-1==0) { //Es la última etapa
                    if (adj==destino) {
                        exito=true;
                    }else {
                        visitados[adj] = false;
                        recorrido.remove((Integer)adj);
                        break;
                    }
                }else {
                    exito=distanciaK(g, adj, destino, distancia-1, visitados, recorrido);
                }

                if (exito) {
                    break;
                }else {
                    visitados[adj] = false;
                    recorrido.remove((Integer)adj);
                }
            }
        }

        return exito;
    }

    public static void main (String args[]) {
        DistanciaK d = new DistanciaK();
        List<Integer>[] grafo = new List[9];
        grafo[0]=new ArrayList();
        grafo[0].add (1); grafo[0].add (4);

        grafo[1]=new ArrayList();
        grafo[1].add (2);

        grafo[2]=new ArrayList();
        grafo[2].add (3);

        grafo[3]=new ArrayList();

        grafo[4]=new ArrayList();
        grafo[4].add (5);

        grafo[5]=new ArrayList();
        grafo[5].add (6);

        grafo[6]=new ArrayList();
        grafo[6].add (3);grafo[6].add (7);

        grafo[7]=new ArrayList();
        grafo[7].add (8);

        grafo[8]=new ArrayList();
        grafo[8].add (3);
        //grafo, origen, destino, distancia (aristas hasta llegar)
        List<Integer> recorrido = d.distanciaK(grafo,0,3,4);

        for (int nodo: recorrido) {
            System.out.println (nodo);
        }
    }
}
