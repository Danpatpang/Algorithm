package exam;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class exam10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger bigInteger = new BigInteger(st.nextToken());
        bigInteger = bigInteger.add(new BigInteger(st.nextToken()));

        bw.write(bigInteger.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
