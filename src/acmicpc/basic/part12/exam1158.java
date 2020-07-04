package acmicpc.basic.part12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class exam1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder("<");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> queue = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            queue.add(i + 1);
        }

        int index = 0;
        while (!queue.isEmpty()) {
            index += M - 1;
            if (index >= queue.size()) {
                index %= queue.size();
            }
            sb.append(queue.remove(index) + ", ");
        }
        System.out.println(sb.toString().substring(0, sb.length()-2) + ">");
    }
}
