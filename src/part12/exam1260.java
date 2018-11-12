package part12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class exam1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] edge = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            edge[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            if (!edge[start].contains(destination)) {
                edge[start].add(destination);
            }
        }

        // 정렬
        for (int i = 0; i < N; i++) {
            edge[i].sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            });
        }

        // DFS
        ArrayList<Integer> result = new ArrayList();
        Stack<Integer> stack = new Stack();
        stack.push(V);

        while (!stack.isEmpty()) {
            int now = stack.pop();
            if (result.contains(now)) {
                continue;
            } else {
                result.add(now);
            }

            for (int i = edge[now].size() - 1; i >= 0; i--) {
                stack.push(edge[now].get(i));
            }
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }

        System.out.println();
        // BFS
        result.clear();
        Queue<Integer> order = new LinkedList();
        order.add(V);

        while (!order.isEmpty()) {
            int now = order.peek();
            result.add(order.poll());

            for (int i = 0; i < edge[now].size(); i++) {
                if (!order.contains(edge[now].get(i))) {
                    order.add(edge[now].get(i));
                }
            }
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i)  + " ");
        }
    }
}