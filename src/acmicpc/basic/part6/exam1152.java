package acmicpc.basic.part6;

import java.util.Scanner;

public class exam1152 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String sentence = s.nextLine().trim();
        String[] split = sentence.split(" ");
        if (sentence.length() == 0){
            System.out.println(0);
        } else{
            System.out.println(split.length);
        }
    }
}
