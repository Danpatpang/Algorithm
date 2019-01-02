package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam11365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String now = "";

        while(!now.equals("DNE")) {
            now = new StringBuffer(br.readLine()).reverse().toString();

            if(!now.equals("DNE")) {
                System.out.println(now);
            }
        }
    }
}
