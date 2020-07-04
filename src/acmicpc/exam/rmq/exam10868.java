package acmicpc.exam.rmq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam10868 {
    public static int[] tree;
    public static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int size = 1;
        while (size < N) {
            size <<= 1;
        }

        tree = new int[size * 2];
        Arrays.fill(tree, INF);

        for (int i = size; i < size + N; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        init();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int finish = Integer.parseInt(st.nextToken());

            System.out.println(Minimum(size + start - 1, size + finish - 1));
        }
    }

    public static void init() {
        for (int i = tree.length - 1; i >= 0; i -= 2) {
            tree[i / 2] = Math.min(tree[i], tree[i - 1]);
        }
    }

    public static int Minimum(int start, int finish) {
        int min = INF;

        while (start <= finish) {
            if (start % 2 == 1) {
                min = Math.min(min, tree[start]);
                start++;
            }
            if (finish % 2 == 0) {
                min = Math.min(min, tree[finish]);
                finish--;
            }

            start /= 2;
            finish /= 2;
        }
        return min;
    }
}
