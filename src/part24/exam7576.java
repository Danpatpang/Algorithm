package part24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class exam7576 {
    static int[][] map;
    static int M;
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Pointer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];

        // y축
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            // x축
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    // M과 N 조심... (x, y)
                    queue.add(new Pointer(j, i));
                }
            }
        }

        BFS();
        int max = 0;
        boolean complete = true;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                max = Math.max(max, map[i][j]);

                if (map[i][j] == 0) {
                    complete = false;
                    break;
                }
            }
        }

        if (complete) {
            System.out.println(max - 1);
        } else {
            System.out.println(-1);
        }
    }

    static void BFS() {
        while (!queue.isEmpty()) {
            Pointer now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (nextX < 1 || nextY < 1 || nextX > M || nextY > N) {
                    continue;
                }
                if (map[nextY][nextX] != 0) {
                    continue;
                }

                queue.add(new Pointer(nextX, nextY));
                map[nextY][nextX] = map[now.y][now.x] + 1;
            }
        }
    }
}

class Pointer {
    int x;
    int y;

    Pointer(int x, int y) {
        this.x = x;
        this.y = y;
    }
}