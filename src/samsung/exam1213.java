package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 10; i++) {
            br.readLine();
            String token = br.readLine();
            String str = br.readLine() + " ";

            String[] array = str.split(token);
            System.out.println("#" + i + " " + (array.length - 1));
        }
    }
}
