package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 666; i < Integer.MAX_VALUE; i++) {
            if(Integer.toString(i).contains("666")) {
                N--;
            }
            if(N == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
