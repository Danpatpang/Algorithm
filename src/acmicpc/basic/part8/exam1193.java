package acmicpc.basic.part8;

import java.util.Scanner;

public class exam1193 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int level = 0;
        int sum = 0;
        while (sum < N) {
            level++;
            sum += level;
        }
        //System.out.println(N+level-sum);
        if (level % 2 == 0) {
            System.out.println((N + level - sum) + "/" + (level - (N + level - sum) + 1));
        } else {
            System.out.println((level - (N + level - sum) + 1) + "/" + (N + level - sum));
        }
    }
}
