package acmicpc.basic.part8;

import java.util.Scanner;

public class exam1475 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[] str = s.nextLine().toCharArray();
        int[] count = new int[10];
        int max = 0;
        for (int i = 0; i < str.length; i++) {
            count[str[i] - '0']++;
        }
        count[6] += count[9];
        if (count[6] % 2 == 1) {
            count[6]++;
        }
        count[6] /= 2;

        for (int i = 0; i < count.length - 1; i++) {
            if (count[i] > max) {
                max = count[i];
            }
        }
        System.out.println(max);
    }
}
