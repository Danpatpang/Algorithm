package exam.rmq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam10868 {
    public static int[] map;
    public static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }
        tree = new int[N + 1];
        init(1, 1, 10);
    }

    public static int init(int node, int start, int end) {
        if (start == end) {
            return map[start];
        } else {
            return tree[node] = Math.min(init(node * 2, start, (start + end) / 2),
                    init(node * 2 + 1, (start + end) / 2 + 1, end));

        }
    }

    public static int Minimum() {
        return 0;
    }
}
