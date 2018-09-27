package part16;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;

public class exam1149 {
    public static void main(String[] args) throws IOException {
        int r = 0, g = 1, b = 2;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] cost= new int[3][N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int redPaintPrice = Integer.parseInt(st.nextToken());
            int bluePaintPrice = Integer.parseInt(st.nextToken());
            int greenPaintPrice = Integer.parseInt(st.nextToken());

            cost[r][i] = Math.min(cost[g][i-1], cost[b][i-1]) + redPaintPrice;
            cost[g][i] = Math.min(cost[r][i-1], cost[b][i-1]) + greenPaintPrice;
            cost[b][i] = Math.min(cost[r][i-1], cost[g][i-1]) + bluePaintPrice;
        }
        System.out.println(Math.min(cost[r][N],Math.min(cost[g][N], cost[b][N])));
    }
}