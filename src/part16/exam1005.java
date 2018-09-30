package part16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class exam1005 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int [] score = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                score[j] = Integer.parseInt(st.nextToken());
            }

            int[] result = new int[K+1];
            result[1] = score[1];
            for (int j = 1; j <= K; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                if(result[Y] == 0){
                    result[Y] = result[X] + score[Y];
                } else{
                    result[Y] = Math.max(result[Y], result[X] + score[Y]);
                }
            }
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            System.out.println(result[W]);
        }
    }
}
