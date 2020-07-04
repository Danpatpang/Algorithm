package acmicpc.basic.part24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class exam7569 {
    static int[][][] map;
    static Queue<Dot> queue = new LinkedList();
    static int M;
    static int N;
    static int H;

    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        // map[z][y][x]
        map = new int[H + 1][N + 1][M + 1];
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    // 익은 토마토를 큐에 추가
                    if (map[i][j][k] == 1) {
                        queue.add(new Dot(k, j, i));
                    }
                }
            }
        }

        BFS();
        System.out.println(findMax());
    }

    public static void BFS() {
        while (!queue.isEmpty()) {
            Dot now = queue.poll();
            // 위, 아래, 왼쪽, 오른쪽, 앞, 뒤 조회
            for (int i = 0; i < 6; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                int nextZ = now.z + dz[i];

                if (nextX < 1 || nextX > M || nextY < 1 || nextY > N || nextZ < 1 || nextZ > H) {
                    continue;
                }
                if (map[nextZ][nextY][nextX] != 0) {
                    continue;
                }

                map[nextZ][nextY][nextX] = map[now.z][now.y][now.x] + 1;
                queue.add(new Dot(nextX, nextY, nextZ));
            }
        }
    }

    // 안 익은 토마토가 있는지 조회 및 최소 날짜 반환
    public static int findMax() {
        int max = 0;

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= M; k++) {
                    max = Math.max(max, map[i][j][k]);

                    if (map[i][j][k] == 0) {
                        return -1;
                    }
                }
            }
        }
        return (max - 1);
    }
}

// (x,y,z) 좌표
class Dot {
    int x;
    int y;
    int z;

    Dot(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}