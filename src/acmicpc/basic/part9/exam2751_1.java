package acmicpc.basic.part9;

import java.util.Scanner;

public class exam2751_1 {
    static int count = 0;
    static int[] heap;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        heap = new int[N];
        for (int i = 0; i < N; i++) {
            insert(s.nextInt());
        }
        delete(N);
    }

    public static void insert(int data) {
        if (count == 0) {
            heap[count++] = data;
        } else {
            heap[count++] = data;
            int current = count - 1;
            int parent = current / 2;
            if (current % 2 == 0) {
                parent -= 1;
            }
            while (heap[current] < heap[parent]) {
                int temp = heap[current];
                heap[current] = heap[parent];
                heap[parent] = temp;
                current = parent;
                parent = parent / 2;
                if (current % 2 == 0 && current != 0) {
                    parent -= 1;
                }
            }
        }
    }

    public static void delete(int N) {
        if (count < 3) {
            for (int i = 0; i < N; i++) {
                System.out.println(heap[i]);
            }
        } else {
            while (count != 0) {
                System.out.println(heap[0]);
                count--;
                heap[0] = heap[count];
                heap[count] = Integer.MAX_VALUE;
                int current = 0;
                int child;
                if (heap[1] < heap[2]) {
                    child = 1;
                } else {
                    child = 2;
                }
                while (heap[current] > heap[child]) {
                    int temp = heap[current];
                    heap[current] = heap[child];
                    heap[child] = temp;
                    current = child;
                    child = current * 2 + 1;
                    if(child >= count){
                        break;
                    }
                    if(heap[child] > heap[child+1]){
                        child += 1;
                    }
                }
            }
        }
    }
}
