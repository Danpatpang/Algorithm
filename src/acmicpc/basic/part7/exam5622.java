package acmicpc.basic.part7;

import java.util.Scanner;

public class exam5622 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String number = s.nextLine();
        int result = 0;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) >= 'A' && number.charAt(i) <= 'C') {
                result += 3;
            } else if (number.charAt(i) >= 'D' && number.charAt(i) <= 'F') {
                result += 4;
            } else if (number.charAt(i) >= 'G' && number.charAt(i) <= 'I') {
                result += 5;
            } else if (number.charAt(i) >= 'J' && number.charAt(i) <= 'L') {
                result += 6;
            } else if (number.charAt(i) >= 'M' && number.charAt(i) <= 'O') {
                result += 7;
            } else if (number.charAt(i) >= 'P' && number.charAt(i) <= 'S') {
                result += 8;
            } else if (number.charAt(i) >= 'T' && number.charAt(i) <= 'V') {
                result += 9;
            } else if (number.charAt(i) >= 'W' && number.charAt(i) <= 'Z') {
                result += 10;
            }
        }
        System.out.println(result);
    }
}
