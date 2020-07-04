package acmicpc.basic.part9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class exam2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] value = new int[N];
        int[] count = new int[8001];
        int sum = 0;
        int max = -4000;
        int min = 4000;

        for (int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(br.readLine());
            sum += value[i];
            max = Math.max(max, value[i]);
            min = Math.min(min, value[i]);
            count[value[i] + 4000] += 1;
        }
        Arrays.sort(value);

        int counting = 0;
        for (int i = 0; i <= 8000; i++) {
            counting = Math.max(counting, count[i]);
        }

        List list = new LinkedList();
        for (int i = 0; i <= 8000; i++) {
            if (count[i] == counting) {
                list.add(i - 4000);
                if (list.size() == 2) {
                    break;
                }
            }
        }

        System.out.println(Math.round((double)sum / N));

        System.out.println(value[N / 2]);

        if (list.size() == 1) {
            System.out.println(list.get(0));
        } else {
            System.out.println(list.get(1));
        }

        System.out.println(max - min);
    }
}
