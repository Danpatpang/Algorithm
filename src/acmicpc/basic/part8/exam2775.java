package acmicpc.basic.part8;

import java.util.Scanner;

public class exam2775 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCase = s.nextInt();
        int height, width;
        int[][] graph = new int[15][15];
        for (int i = 0; i < 15; i++) {
            graph[0][i] = i+1;
            graph[i][0] = 1;
        }
        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                graph[i][j] = graph[i-1][j]+graph[i][j-1];
            }
        }

        for (int i = 0; i < testCase; i++) {
            height = s.nextInt();
            width = s.nextInt();
            System.out.println(graph[height][width-1]);
       }
    }
}
