package part7;

import java.util.Scanner;

public class exam1157 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[] c = s.nextLine().toUpperCase().toCharArray();
        int[] count = new int[26];
        int max = 0;
        int current = 0;
        boolean equal = false;

        for (int i = 0; i < c.length; i++) {
            count[c[i]-'A']++;
        }
        for (int i = 0; i < count.length; i++) {
            if(count[i] > max){
                max = count[i];
                current = i;
                equal = true;
            } else if(max == count[i]){
                equal = false;
            }
        }
        if(!equal){
            System.out.println("?");
        } else{
            System.out.println((char)(current+'A'));
        }
    }
}