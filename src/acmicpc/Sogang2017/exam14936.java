package acmicpc.Sogang2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class exam14936 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int none = 0;
        int condition1 = N;
        int condition2 = N / 2;
        int condition3 = (N % 2 == 0) ? N / 2 : N / 2 + 1;
        int condition4 = ((N - 1) / 3) + 1;
        int combo1 = condition1 + condition4;
        int combo2 = condition2 + condition4;
        int combo3 = condition3 + condition4;

        ArrayList<Integer> list = new ArrayList();
        list.add(none);
        list.add(condition4);
        list.add(condition2);
        list.add(condition3);
        list.add(combo2);
        list.add(combo3);
        list.add(condition1);
        list.add(combo1);

        int count = 0;
        if(N == 1){
            if(M == 0){
                System.out.println(1);
            } else{
                System.out.println(2);
            }
        } else if(N == 2){
            if(M == 0){
                System.out.println(1);
            } else if(M == 1){
                System.out.println(3);
            } else{
                System.out.println(4);
            }
        }
        else{
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > M) {
                    break;
                } else {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
