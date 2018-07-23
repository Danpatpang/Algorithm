package part8;

import java.util.Scanner;

public class exam1011 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] result = new int[N];
        int start;
        int end;
        int distance;
        for (int i = 0; i < N; i++) {
            start = s.nextInt();
            end = s.nextInt();
            distance = end - start;
            int count = (int) Math.sqrt(distance);
            if (Math.pow(count, 2) == distance) {
                result[i] = count * 2 - 1;
            } else if (Math.pow(count, 2) < distance && distance <= (Math.pow(count, 2) + Math.pow(count + 1, 2)) / 2) {
                result[i] = count * 2;
            } else {
                result[i] = count * 2 + 1;
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(result[i]);
        }
    }
}