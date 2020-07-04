package acmicpc.basic.part9;

import java.util.Scanner;

public class exam2750 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = s.nextInt();
        }
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                if(num[i] > num[j]){
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(num[i]);
        }
    }
}
