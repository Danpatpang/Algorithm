package acmicpc.etc;

import java.util.Scanner;

public class exam1932 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int result = 0;
        int[][] component = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                component[i][j] = s.nextInt();
                if (i > 0) {
                    if (j == 0) {
                        component[i][j] = component[i][j] + component[i - 1][j];
                    } else if (j == i) {
                        component[i][j] = component[i][j] + component[i - 1][j - 1];
                    } else {
                        if (component[i - 1][j - 1] >= component[i - 1][j]) {
                            component[i][j] = component[i][j] + component[i - 1][j - 1];
                        } else {
                            component[i][j] = component[i][j] + component[i - 1][j];
                        }
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if(component[N-1][i] > result){
                result = component[N-1][i];
            }
        }
        System.out.println(result);
    }
}
