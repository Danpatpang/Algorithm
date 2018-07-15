package part5;

import java.util.Scanner;

public class exam2448 {
    static String[] map;

    static void makeStar(int n) {
        int height = 3 * (int) Math.pow(2, n);
        int middle = height/2;
        for (int i = middle; i < height; i++) {
            map[i] = map[i-middle] + " " + map[i-middle];
        }
        String space="";
        for (int i = 0; i < middle; i++) {
            space+=" ";
        }
        for (int i = 0; i < middle; i++) {
            map[i] = space + map[i] + space;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        map = new String[N];
        map[0] = "  *  ";
        map[1] = " * * ";
        map[2] = "*****";
        for (int i = 1; 3 * (int) Math.pow(2, i) <= N; i++) {
            makeStar(i);
        }
        for (int i = 0; i < N; i++) {
            System.out.println(map[i]);
        }
    }
}
