package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class exam2805 {
    public static Queue<Point> queue;
    public static int[][] map;
    public static boolean[][] isVisit;
    public static int size;
    public static int count;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            size = Integer.parseInt(br.readLine());
            count = 0;
            map = new int[size][size];
            isVisit = new boolean[size][size];
            queue = new LinkedList<Point>();

            for (int j = 0; j < size; j++) {
                String str = br.readLine();
                for (int k = 0; k < size; k++) {
                    map[j][k] = str.charAt(k) - '0';
                }
            }

            queue.add(new Point(size / 2, size / 2));
            isVisit[size / 2][size / 2] = true;
            count += map[size / 2][size / 2];
            BFS();

            System.out.println("#" + i + " " + count);
        }
    }

    public static void BFS() {
        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int currentX = point.x + dx[i];
                int currentY = point.y + dy[i];

                if (currentX >= 0 && currentX < size && currentY >= 0 && currentY < size) {
                    if (!isVisit[currentX][currentY]) {
                        count += map[currentX][currentY];
                        isVisit[currentX][currentY] = true;

                        if (currentX <= 1 || currentX >= size - 2 || currentY <= 1 || currentY >= size - 2) {
                            if (currentX == 0 || currentX == size - 1 || currentY == 0 || currentY == size - 1) {
                                continue;
                            }
                            if (currentX == size / 2 || currentY == size / 2) {
                                queue.add(new Point(currentX, currentY));
                            }
                            continue;
                        }
                        queue.add(new Point(currentX, currentY));
                    }
                }
            }
        }
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}