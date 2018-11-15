package part24;

import java.io.*;
import java.util.StringTokenizer;

public class exam2606 {
    static int[][] map;
    static int V;
    static int E;
    static int count;
    static boolean[] isVisit;

    public static void DFS(int start) {
        isVisit[start] = true;

        for (int i = 1; i <= V; i++) {
            // 바이러스가 옮겨질 때마다 count + 1
            if(!isVisit[i] && map[start][i] == 1) {
                count++;
                DFS(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        count = 0;
        map = new int[V + 1][V + 1];
        isVisit = new boolean[V + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());

            map[start][destination] = 1;
            map[destination][start] = 1;
        }

        // 바이러스는 1번부터 시작.
        DFS(1);
        System.out.println(count);
    }
}
