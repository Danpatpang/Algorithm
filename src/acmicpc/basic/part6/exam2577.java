package acmicpc.basic.part6;

import java.util.Scanner;

public class exam2577 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int y = s.nextInt();
        int z = s.nextInt();
        long value = (long)x*y*z;
        String str = Long.toString(value);

        int[] count = new int[10];
        for (int i = 0; i < count.length; i++) {
            count[i] = 0;
        }

        for (int i = 0; i < str.length(); i++) {
            int j = Integer.parseInt(str.split("")[i]);
            count[j]++;
        }
        for (int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
        }
    }
}
