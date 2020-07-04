package acmicpc.basic.part24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 배열을 계속 생성하면 메모리 초과
// 배열을 만들어서 맵을 정의 후 탐색하는 기법은 시간 초과
public class exam10216 {
    static boolean[] isVisit;
    static ArrayList<Area> enemy;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        enemy = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            isVisit = new boolean[N];
            count = 0;

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int R = Integer.parseInt(st.nextToken());

                enemy.add(new Area(x, y, R));
            }

            check();
            System.out.println(count);
            enemy.clear();  // 초기화
        }
    }

    public static void check() {
        int n = enemy.size();
        for (int i = 0; i < n; i++) {
            if (!isVisit[i]) {
                BFS(i);
                count++;
            }
        }
    }

    public static void BFS(int i) {
        Queue<Area> queue = new LinkedList<>();
        queue.add(enemy.get(i));
        isVisit[i] = true;

        while (!queue.isEmpty()) {
            Area now = queue.poll();

            for (int j = 0; j < enemy.size(); j++) {
                if (!isVisit[j] && isGroup(enemy.get(j), now)) {
                    queue.add(enemy.get(j));
                    isVisit[j] = true;
                }
            }
        }
    }

    // 두 점 간의 거리 <= 범위
    static boolean isGroup(Area a, Area b) {
        double distanceAB = Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2);
        double addRange = Math.pow((a.r + b.r), 2);
        return addRange >= distanceAB;
    }
}

class Area {
    int x;
    int y;
    int r;

    Area(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
}