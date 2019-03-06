package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam1210 {
    public static int[][] map;
    public static int[] dx = {-1, 1, 0};
    public static int[] dy = {0, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 10; i++) {
            br.readLine();
            map = new int[102][102];
            StringTokenizer st;

            for (int j = 1; j <= 100; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= 100; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 1; j <= 100; j++) {
                if (map[100][j] == 2) {
                    int startPoint = dps(100, j);
                    System.out.println("#" + i + " " + startPoint);
                    break;
                }
            }
        }
    }

    public static int dps(int y, int x) {
        if (y == 1) {
            return x - 1;
        }

        map[y][x] = 0;
        int startPoint = 0;
        int currentX, currentY;

        for (int i = 0; i < 3; i++) {
            currentX = x + dx[i];
            currentY = y + dy[i];

            if (map[currentY][currentX] == 1) {
                startPoint = dps(currentY, currentX);
                break;
            }
        }
        return startPoint;
    }
}
