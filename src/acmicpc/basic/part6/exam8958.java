package acmicpc.basic.part6;

import java.util.Scanner;

public class exam8958 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = Integer.parseInt(s.nextLine());
        int sum[] = new int[N];
        for (int i = 0; i < N; i++) {
            String str = s.nextLine();
            sum[i] = 0;
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == 'O'){
                    count ++;
                } else{
                    count = 0;
                }
                sum[i] += count;
            }
        }
        for (int i = 0; i < N ; i++) {
            System.out.println(sum[i]);
        }
    }
}
