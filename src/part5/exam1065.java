package part5;

import java.util.Scanner;

public class exam1065 {

    static int count = 0;

    static boolean cal(int n) {
        if (n < 10) {
            return true;
        }
        int current = n%10;
        int next = (n%100 - n%10)/10;
        int gap = current-next;
        while (n >= 10) {
            if (gap != current-next) {
                return false;
            }
            n /= 10;
            current = next;
            next = (n%100 - n%10)/10;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        for (int i = 1; i <= N; i++) {
            if (cal(i)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
