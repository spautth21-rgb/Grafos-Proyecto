package mst;

import java.util.*;

public class Kruskal {

    static class Edge implements Comparable<Edge> {
        int u, v, w;
        Edge(int u, int v, int w){this.u=u;this.v=v;this.w=w;}
        public int compareTo(Edge e){return this.w - e.w;}
    }

    static int find(int[] p, int x){
        if(p[x]!=x) p[x]=find(p,p[x]);
        return p[x];
    }

    static void union(int[] p, int a, int b){
        p[find(p,a)] = find(p,b);
    }

    public static int kruskal(int[][] g){
        int V = g.length;
        List<Edge> edges = new ArrayList<>();

        for(int i=0;i<V;i++)
            for(int j=i+1;j<V;j++)
                if(g[i][j]!=0)
                    edges.add(new Edge(i,j,g[i][j]));

        Collections.sort(edges);

        int[] p = new int[V];
        for(int i=0;i<V;i++) p[i]=i;

        int cost=0, ciclos=0;

        for(Edge e: edges){
            if(find(p,e.u)!=find(p,e.v)){
                union(p,e.u,e.v);
                cost+=e.w;
            } else {
                ciclos++;
            }
        }

        System.out.println("Ciclos evitados: " + ciclos);
        return cost;
    }
}
