package acmicpc.basic.part16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int[] count = new int[X + 1];

        for (int i = 2; i <= X; i++) {
            count[i] = count[i - 1] + 1;
            if (i % 2 == 0) {
                count[i] = Math.min(count[i], count[i / 2] + 1);
            }
            if (i % 3 == 0) {
                count[i] = Math.min(count[i], count[i / 3] + 1);
            }
        }
        System.out.println(count[X]);
        
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int X = Integer.parseInt(br.readLine());
//         int[] count = new int[X + 1];

//         for (int i = 2; i <= X; i++) {
//             count[i] = count[i - 1] + 1;
//             if (i % 2 == 0) {
//                 count[i] = Math.min(count[i], count[i / 2] + 1);
//             }
//             if (i % 3 == 0) {
//                 count[i] = Math.min(count[i], count[i / 3] + 1);
//             }
//         }
//         System.out.println(count[X]);
    }
}
