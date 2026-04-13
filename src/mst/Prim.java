package mst;

import java.util.*;

public class Prim {
    static final int V = 10;

    public static int prim(int[][] g) {
        boolean[] vis = new boolean[V];
        int[] key = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;

        int res = 0;

        for (int i = 0; i < V; i++) {
            int u = -1;
            for (int j = 0; j < V; j++)
                if (!vis[j] && (u == -1 || key[j] < key[u]))
                    u = j;

            vis[u] = true;
            res += key[u];

            for (int v = 0; v < V; v++)
                if (g[u][v] != 0 && !vis[v] && g[u][v] < key[v])
                    key[v] = g[u][v];
        }
        return res;
    }
}
