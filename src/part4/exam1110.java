package part4;

import java.util.Scanner;

public class exam1110 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String N = s.nextLine();
        if(N.length() == 1){
            N = "0" + N;
        }
        int intN = Integer.parseInt(N.substring(0,1))+ Integer.parseInt(N.substring(1,2));
        String newN = Integer.toString(intN);
        if(newN.length() == 1){
            newN = "0" + newN;
        }
        String result = N.substring(1,2) + newN.substring(1,2);
        int count = 1;
        while(!N.equals(result)){
            count++;
            intN = Integer.parseInt(result.substring(0,1))+ Integer.parseInt(result.substring(1,2));
            newN = Integer.toString(intN);
            if(newN.length() == 1){
                newN = "0" + newN;
            }
            result = result.substring(1,2) + newN.substring(1,2);
        }
        System.out.println(count);
    }
}
