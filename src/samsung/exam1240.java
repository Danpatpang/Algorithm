package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam1240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String current, secureCode = null;
            for (int j = 0; j < N; j++) {
                current = br.readLine();
                if (current.contains("1")) {
                    int last = current.lastIndexOf("1");
                    secureCode = current.substring(last - 55, last + 1);
                }
            }

            int[] data = new int[8];
            for (int k = 0; k < 8; k++) {
                String currentData = secureCode.substring((k * 7), (k * 7) + 7);

                if (currentData.equals("0001101")) {
                    data[k] = 0;
                } else if (currentData.equals("0011001")) {
                    data[k] = 1;
                } else if (currentData.equals("0010011")) {
                    data[k] = 2;
                } else if (currentData.equals("0111101")) {
                    data[k] = 3;
                } else if (currentData.equals("0100011")) {
                    data[k] = 4;
                } else if (currentData.equals("0110001")) {
                    data[k] = 5;
                } else if (currentData.equals("0101111")) {
                    data[k] = 6;
                } else if (currentData.equals("0111011")) {
                    data[k] = 7;
                } else if (currentData.equals("0110111")) {
                    data[k] = 8;
                } else if (currentData.equals("0001011")) {
                    data[k] = 9;
                }
            }

            int result = (data[0] + data[2] + data[4] + data[6]) * 3 + (data[1] + data[3] + data[5]) + data[7];
            int sum = 0;
            if (result % 10 == 0) {
                for (int k = 0; k < 8; k++) {
                    sum += data[k];
                }
            }

            System.out.println("#" + i + " " + sum);
        }
    }
}