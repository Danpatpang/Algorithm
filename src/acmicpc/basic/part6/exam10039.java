package acmicpc.basic.part6;

import java.util.Scanner;

public class exam10039 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] score = new int[5];
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            score[i] = s.nextInt();
            if(score[i] < 40){
                score[i] = 40;
            }
            sum += score[i];
        }
        System.out.println(sum/5);
    }
}
