package caminos;

public class FloydWarshall {

    public static void floyd(int[][] g){
        int n = g.length;
        int[][] dist = new int[n][n];

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                dist[i][j] = (g[i][j]==0 && i!=j) ? 999999 : g[i][j];

        for(int k=0;k<n;k++)
        for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
            if(dist[i][k]+dist[k][j]<dist[i][j])
                dist[i][j]=dist[i][k]+dist[k][j];

        System.out.println("Matriz de distancias mínimas:");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                System.out.print(dist[i][j]+" ");
            System.out.println();
        }
    }
}
