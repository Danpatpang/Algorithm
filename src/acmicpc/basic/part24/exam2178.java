package acmicpc.basic.part24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class exam2178 {
    static int[][] map;
    static boolean[][] isVisit;
    static int N;
    static int M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        isVisit = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
//            char[] value = br.readLine().toCharArray();
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
//                map[i][j] = (int) value[j - 1] - 48;
                map[i][j] = str.charAt(j - 1) - '0';
            }
        }

        isVisit[1][1] = true;
        BFS(1, 1);
        System.out.println(map[N][M]);
    }

    public static void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList();
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            // 현재 위치에서 상하좌우 확인
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                // 1 <= x <= N, 1 <= y <= M이 아닐 경우
                if (nextX < 1 || nextX > N || nextY < 1 || nextY > M) {
                    continue;
                }
                // 방문하거나 해당 위치가 벽일 경우
                if (isVisit[nextX][nextY] || map[nextX][nextY] == 0) {
                    continue;
                }

                queue.add(new Point(nextX, nextY));
                map[nextX][nextY] = map[now.x][now.y] + 1;
                isVisit[nextX][nextY] = true;
            }
        }
    }
}

// 정점(x, y)를 표현하기 위한 클래스
class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}