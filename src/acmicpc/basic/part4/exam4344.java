package acmicpc.basic.part4;

import java.util.Scanner;

public class exam4344 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int C = s.nextInt();
        int[] N = new int[C];
        int[][] value = new int[C][1000];
        float[] sum = new float[C];

        for (int i = 0; i < C; i++) {
            N[i] = s.nextInt();
            for (int j = 0; j < N[i]; j++) {
                value[i][j] = s.nextInt();
                sum[i] += value[i][j];
            }
            sum[i] /= N[i];
            int count = 0;
            for (int j = 0; j < N[i]; j++) {
                if (sum[i] < value[i][j]) {
                    count++;
                }
            }
            sum[i] = (float) count / N[i] * 100;
        }
        for (int i = 0; i < C; i++) {
            System.out.format("%.3f%%\n", sum[i]);
        }
    }
}