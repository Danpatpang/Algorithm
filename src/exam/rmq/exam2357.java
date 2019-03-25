package exam.rmq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam2357 {
    public static int[] minTree, maxTree;
    public static int INF = Integer.MAX_VALUE;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int size = 1;
        while (size <= N) {
            size <<= 1;
        }

        maxTree = new int[size * 2];
        minTree = new int[size * 2];

        for (int i = 0; i < size; i++) {
            Arrays.fill(minTree, INF);
        }

        for (int i = size; i < size + N; i++) {
            int value = Integer.parseInt(br.readLine());
            minTree[i] = value;
            maxTree[i] = value;
        }

        init();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int finish = Integer.parseInt(st.nextToken());
            int[] result = findMinAndMaxValue(start + size - 1, finish + size - 1);
            System.out.println(result[0] + " " + result[1]);
        }
    }

    public static void init() {
        for (int i = minTree.length - 1; i > 0; i -= 2) {
            minTree[i / 2] = Math.min(minTree[i], minTree[i - 1]);
            maxTree[i / 2] = Math.max(maxTree[i], maxTree[i - 1]);
            System.out.println();
        }
    }

    public static int[] findMinAndMaxValue(int start, int finish) {
        int[] result = {INF, 0};

        while (start <= finish) {
            if (start % 2 == 1) {
                result[0] = Math.min(result[0], minTree[start]);
                result[1] = Math.max(result[1], maxTree[start]);
                start++;
            }

            if (finish % 2 == 0) {
                result[0] = Math.min(result[0], minTree[finish]);
                result[1] = Math.max(result[1], maxTree[finish]);
                finish--;
            }

            start /= 2;
            finish /= 2;
        }

        return result;
    }
}
