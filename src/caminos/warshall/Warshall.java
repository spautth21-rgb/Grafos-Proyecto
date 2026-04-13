package warshall;

public class Warshall {

    public static void warshall(int[][] g){
        int n = g.length;
        boolean[][] reach = new boolean[n][n];

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                reach[i][j] = (g[i][j]!=0);

        for(int k=0;k<n;k++)
        for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
            reach[i][j] = reach[i][j] || (reach[i][k] && reach[k][j]);

        System.out.println("Matriz de alcanzabilidad:");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                System.out.print((reach[i][j]?1:0)+" ");
            System.out.println();
        }
    }
}
