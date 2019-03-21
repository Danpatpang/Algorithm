package part23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class exam1967 {
    public static int[][] tree;
    public static int[][] value;
    public static boolean[] isVisit;
    public static int[] nodeValue;

    public static int n;
    public static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        tree = new int[n + 1][n + 1];
        value = new int[n + 1][n + 1];
        isVisit = new boolean[n + 1];
        nodeValue = new int[n + 1];

        int startNode = 0;

        for (int i = 1; i <= n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[start][destination] = 1;
            tree[destination][start] = 1;
            value[start][destination] = weight;
            value[destination][start] = weight;

            startNode = start;
        }

        queue = new LinkedList<Integer>();
        queue.add(startNode);
        isVisit[startNode] = true;

        BFS(startNode);

        int max = 0;
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (nodeValue[i] > max) {
                max = nodeValue[i];
                index = i;
            }
        }


        isVisit = new boolean[n + 1];
        nodeValue = new int[n + 1];
        queue.add(index);
        isVisit[index] = true;

        BFS(index);

        max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, nodeValue[i]);
        }
        System.out.println(max);
    }

    public static void BFS(int node) {
//        queue.add(node);
//        isVisit[node] = true;
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            isVisit[currentNode] = true;

            for (int i = 1; i <= n; i++) {
                if (tree[currentNode][i] == 1 && !isVisit[i]) {
                    queue.add(i);
                    nodeValue[i] = nodeValue[currentNode] + value[currentNode][i];
                }
            }
        }
    }
}
