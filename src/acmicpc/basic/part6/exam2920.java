package acmicpc.basic.part6;

import java.util.Scanner;

public class exam2920 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int[] value = new int[8];
        boolean[] order = new boolean[2];
        for (int i = 0; i < 2; i++) {
            order[i] = true;
        }

        for (int i = 0; i < 8; i++) {
            value[i] = Integer.parseInt(str.split(" ")[i]);
        }

        for (int i = 0; i < 7; i++) {
            if (value[i] > value[i + 1]) {
                order[0] = false;
            } else {
                order[1] = false;
            }
        }

        if (!(order[0] || order[1])) {
            System.out.println("mixed");
        } else if (order[0]) {
            System.out.println("ascending");
        } else {
            System.out.println("descending");
        }
    }
}