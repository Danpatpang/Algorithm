package part16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class exam1005 {
    static int T, N, K;
    static int[] score, pointedNode, dp;
    static ArrayList<Integer> sortedNode;
    static ArrayList<Integer>[] nodeArray, from, fromValue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            // 정점, 간선 입력
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            score = new int[N + 1];
            nodeArray = new ArrayList[N + 1];
            from = new ArrayList[N + 1];
            fromValue = new ArrayList[N + 1];

            // 점수 입력
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                nodeArray[j] = new ArrayList<Integer>();
                from[j] = new ArrayList<Integer>();
                fromValue[j] = new ArrayList<Integer>();
                score[j] = Integer.parseInt(st.nextToken());
            }

            // 간선 정보 입력
            pointedNode = new int[N + 1];
            for (int j = 1; j <= K; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                // 내가 가리키고 있는 노드
                nodeArray[X].add(Y);
                pointedNode[Y]++;
                // 나를 가리키는 노드
                from[Y].add(X);
                fromValue[Y].add(score[X]);
            }

            // queue에 시작점 추가
            dp = new int[N + 1];
            Queue<Integer> queue = new LinkedList<Integer>();
            for (int j = 1; j <= N; j++) {
                if (pointedNode[j] == 0) {
                    queue.add(j);
                }
            }

            sortedNode = new ArrayList<Integer>();
            while (!queue.isEmpty()) {
                int currentNode = queue.poll();
                sortedNode.add(currentNode);
                for (int j = 0; j < nodeArray[currentNode].size(); j++) {
                    int node = nodeArray[currentNode].get(j);
                    if (--pointedNode[node] == 0) {
                        queue.add(node);
                    }
                }
            }

            // 노드별 dp 계산
            for (int j : sortedNode) {
                for (int k = 0; k < from[j].size(); k++) {
                    int node = from[j].get(k);
                    int nodeValue = fromValue[j].get(k);
                    dp[j] = Math.max(dp[j], dp[node] + nodeValue);
                }
            }

            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int result = dp[W] + score[W];
            System.out.println(result);
        }
    }
}
