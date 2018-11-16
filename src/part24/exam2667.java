package part24;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class exam2667 {
    static int[][] map;
    static boolean[][] isVisit;
    static Queue<Dot2> queue = new LinkedList<>();
    static ArrayList<Integer> result = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        isVisit = new boolean[N + 1][N + 1];

        // 입력
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= N; j++) {
                map[i][j] = (int) (str.charAt((j - 1)) - '0');
            }
        }

        // 탐색
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!isVisit[i][j] && map[i][j] == 1) {
                    int count = 1;
                    queue.add(new Dot2(i, j));
                    isVisit[i][j] = true;

                    result.add(BFS(count));
                }
            }
        }

        // 정렬
        result.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public static int BFS(int count) {
        while (!queue.isEmpty()) {
            Dot2 now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (nextX < 1 || nextY < 1 || nextX > N || nextY > N) {
                    continue;
                }
                if (isVisit[nextX][nextY] || map[nextX][nextY] == 0) {
                    continue;
                }

                count++;
                queue.add(new Dot2(nextX, nextY));
                isVisit[nextX][nextY] = true;
            }
        }
        return count;
    }
}

class Dot2 {
    int x;
    int y;

    Dot2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}