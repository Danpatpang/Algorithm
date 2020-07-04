package acmicpc.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam1018 {
    public static int M, N, result;
    public static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        result = 32;
        map = new char[M][N];

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i <= M - 8; i++) {
            for (int j = 0; j <= N - 8; j++) {
                int choice = Math.min(dfs(i, j, 8, 'B', 'W'), dfs(i, j, 8, 'W', 'B'));
                result = Math.min(result, choice);
            }
        }

        System.out.println(result);
    }

    public static int dfs(int x, int y, int length, char left, char right) {
        int len = length / 2;
        int count = 0;

        if (length == 2) {
            if (map[x][y] != left) {
                count++;
            }
            if (map[x + 1][y] != right) {
                count++;
            }
            if (map[x][y + 1] != right) {
                count++;
            }
            if (map[x + 1][y + 1] != left) {
                count++;
            }
            return count;
        }

        count += dfs(x, y, len, left, right);
        count += dfs(x + len, y, len, left, right);
        count += dfs(x, y + len, len, left, right);
        count += dfs(x + len, y + len, len, left, right);

        return count;
    }
}
