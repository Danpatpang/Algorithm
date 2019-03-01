package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam1208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 0; t < 10; t++) {
            int dump = Integer.parseInt(br.readLine());
            int[] box = new int[101];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 100; i++) {
                int temp = Integer.parseInt(st.nextToken());
                box[temp]++;
            }

            int max = 100, min = 1;
            for (int i = 0; i < dump; i++) {
                if (max == min) {
                    break;
                }

                for (int j = max; j >= min; j--) {
                    if (box[j] != 0) {
                        box[j]--;
                        box[j - 1]++;
                        max = j;
                        break;
                    }
                }

                for (int j = min; j <= max; j++) {
                    if (box[j] != 0) {
                        box[j]--;
                        box[j + 1]++;
                        min = j;
                        break;
                    }
                }
            }

            if (box[max] == 0) {
                max--;
            }
            if (box[min] == 0) {
                min++;
            }
            System.out.println("#" + (t + 1) + " " + (max - min));
        }
    }
}
