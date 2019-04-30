package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class exam10826 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		BigInteger[] bigInteger = new BigInteger[10001];

		bigInteger[0] = new BigInteger("0");
		bigInteger[1] = new BigInteger("1");
		for (int i = 2; i <= n; i++) {
			bigInteger[i] = bigInteger[i-1].add(bigInteger[i-2]);
		}

		System.out.println(bigInteger[n]);
	}
}
