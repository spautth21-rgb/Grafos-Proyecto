package router;

import java.util.*;

public class Router {

    public static void rutaMasRapida(int[][] g, int src, int dest){
        int n = g.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MIN_VALUE);

        dist[src] = Integer.MAX_VALUE;
        boolean[] vis = new boolean[n];

        for(int i=0;i<n;i++){
            int u=-1;
            for(int j=0;j<n;j++)
                if(!vis[j] && (u==-1 || dist[j]>dist[u]))
                    u=j;

            vis[u]=true;

            for(int v=0;v<n;v++){
                if(g[u][v]!=0){
                    int ancho = Math.min(dist[u], g[u][v]);
                    if(ancho > dist[v]){
                        dist[v] = ancho;
                    }
                }
            }
        }

        System.out.println("Mayor ancho de banda: " + dist[dest]);
    }
}
