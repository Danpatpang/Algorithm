package acmicpc.basic.part8;

import java.util.Scanner;

public class exam2292 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int result = 0;
        if(N == 1){
            result = 1;
        }else{
            for (int i = 0; 0 < N-1; i++) {
                N -= 6*i;
                result++;
            }
        }
        System.out.println(result);
    }
}
