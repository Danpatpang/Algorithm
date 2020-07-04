package acmicpc.basic.part23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class exam1967 {
    public static LinkedList<Node>[] tree;
    public static boolean[] isVisit;
    public static int[] nodeValue;

    public static int n;
    public static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        tree = new LinkedList[n + 1];
        isVisit = new boolean[n + 1];
        nodeValue = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new LinkedList<Node>();
        }

        int startNode = 0;
        for (int i = 1; i <= n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[start].add(new Node(destination, weight));
            tree[destination].add(new Node(start, weight));

            if (i == 1) {
                startNode = start;
            }
        }

        BFS(startNode);

        int max = 0;
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (nodeValue[i] > max) {
                max = nodeValue[i];
                index = i;
            }
        }

        for (int i = 1; i <= n; i++) {
            isVisit[i] = false;
            nodeValue[i] = 0;
        }

        queue.add(index);
        BFS(index);

        max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, nodeValue[i]);
        }
        System.out.println(max);
    }

    public static void BFS(int node) {
        queue = new LinkedList<Integer>();

        queue.add(node);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            isVisit[currentNode] = true;

            for (Node nextNode : tree[currentNode]) {
                if (!isVisit[nextNode.node]) {
                    queue.add(nextNode.node);
                    nodeValue[nextNode.node] = nodeValue[currentNode] + nextNode.weight;
                }
            }
        }
    }
}

class Node {
    int node;
    int weight;

    Node(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}