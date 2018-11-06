package part9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class exam1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] word = new String[N];
        for (int i = 0; i < N; i++) {
            word[i] = br.readLine();
        }
        // 길이로 정렬
        Arrays.sort(word, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        // 사전순으로 정렬
        Arrays.sort(word, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return 0;
                }
            }
        });

        System.out.println(word[0]);
        for (int i = 1; i < N; i++) {
            if (word[i].equals(word[i - 1])) {
                continue;
            }
            System.out.println(word[i]);
        }
    }
}
