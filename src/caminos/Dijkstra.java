package caminos;

import java.util.*;

public class Dijkstra {

    public static void dijkstra(int[][] g, int src, int dest){
        int n = g.length;
        int[] dist = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        dist[src] = 0;
        boolean[] vis = new boolean[n];

        for(int i=0;i<n;i++){
            int u=-1;
            for(int j=0;j<n;j++)
                if(!vis[j] && (u==-1 || dist[j]<dist[u]))
                    u=j;

            vis[u]=true;

            for(int v=0;v<n;v++){
                if(g[u][v]!=0 && dist[u]+g[u][v]<dist[v]){
                    dist[v] = dist[u]+g[u][v];
                    parent[v] = u;
                }
            }
        }

        if(dist[dest]==Integer.MAX_VALUE){
            System.out.println("No hay ruta posible");
            return;
        }

        imprimirCamino(parent, dest);
        System.out.println(" (Costo " + dist[dest] + ")");
    }

    static void imprimirCamino(int[] parent, int j){
        if(parent[j]==-1){
            System.out.print(j);
            return;
        }
        imprimirCamino(parent, parent[j]);
        System.out.print(" -> " + j);
    }
}
