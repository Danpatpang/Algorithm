package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam1206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 0; t < 10; t++) {
            int length = Integer.parseInt(br.readLine());
            int[] height = new int[length + 4];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 2; i < length + 2; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }

            int result = 0;
            int temp = 0;

            for (int i = 2; i < length + 2; i++) {
                temp = height[i] - Math.max(Math.max(height[i - 1], height[i - 2]),
                        Math.max(height[i + 1], height[i + 2]));
                if (temp > 0) {
                    result += temp;
                }
            }

            System.out.println("#" + (t + 1) + " " + result);
        }
    }
}
