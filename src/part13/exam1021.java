package part13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class exam1021 {
    // 좌우로 비교할 수 있지만 2개의 큐를 사용하는 게 더빠르다고 판단...
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Deque<Integer> dequeLeft = new ArrayDeque();
        for (int i = 0; i < M; i++) {
            dequeLeft.add(i + 1);
        }
        Deque<Integer> dequeRight = ((ArrayDeque<Integer>) dequeLeft).clone();

        int count = 0;
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());

            // left
            int left = 0;
            if(temp == dequeLeft.peek()){
                dequeLeft.poll();
            } else if(temp != dequeLeft.peekFirst()){
                // 처음 값은 뽑았다고 취급
                left++;
                while(temp != dequeLeft.peekLast()){
                    left++;
                    dequeLeft.addFirst(dequeLeft.pollLast());
                }
                dequeLeft.pollLast();
            }

            // right
            int right = 0;
            while(temp != dequeRight.peekFirst()){
                right++;
                dequeRight.addLast(dequeRight.pollFirst());
            }
            dequeRight.pollFirst();

            count += Math.min(left, right);
        }
        System.out.println(count);
    }
}
