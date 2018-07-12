package part4;

import java.io.*;

public class exam10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int N = Integer.parseInt(str.split(" ")[0]);
        int X = Integer.parseInt(str.split(" ")[1]);
        str = br.readLine();
        for (int i = 0; i < N; i++) {
            if (X > Integer.parseInt(str.split(" ")[i])) {
                bw.write(String.valueOf(str.split(" ")[i]) + " ");
            }
        }
        bw.flush();
    }
}