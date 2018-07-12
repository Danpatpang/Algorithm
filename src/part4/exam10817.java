package part4;

import java.io.*;

public class exam10817 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int[] x = new int[3];
        for (int i = 0; i < x.length; i++) {
            x[i] = Integer.parseInt(str.split(" ")[i]);
        }
        int result;
        if (x[0] < x[1]) {
            if (x[0] >= x[2]) {
                result = x[0];
            } else {
                if (x[1] >= x[2]) {
                    result = x[2];
                } else {
                    result = x[1];
                }
            }
        } else if (x[0] == x[1]) {
            result = x[1];
        } else {
            if (x[1] >= x[2]) {
                result = x[1];
            } else {
                if (x[0] >= x[2]) {
                    result = x[2];
                } else {
                    result = x[0];
                }
            }
        }


        bw.write(String.valueOf(result));
        bw.flush();
    }
}