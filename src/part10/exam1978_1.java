package part10;

import java.util.Scanner;

/**
 * 소수는 n의 배수가 아니어야 한다.
 * 입력받은 수를 입력받은 수보다 작은 수 들로 나누어서 떨어지면 소수가 아니다.
 * 그러나 모두 나누어볼 필요없이, 루트 n 까지만 나누어서 떨어지면 소수가 아니다.
 */
public class exam1978_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int count = 0;
        test : for (int i = 0; i < N; i++) {
            int num = s.nextInt();
            if(num == 1){
                continue test;
            }
            for (int j = 2; j <= Math.sqrt(num); j++) {
                if(num % j == 0){
                    continue test;
                }
            }
            count++;
        }
        System.out.println(count);
    }
}
