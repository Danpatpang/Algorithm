package part9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class exam2751_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList data = new ArrayList();
        for (int i = 0; i < N; i++) {
            data.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(data);
        for (int i = 0; i < N; i++) {
            System.out.println(data.get(i));
        }
    }
}
