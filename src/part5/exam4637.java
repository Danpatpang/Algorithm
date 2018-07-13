package part5;

public class exam4637 {
    static boolean[] N = new boolean[10001];

    static void kaprekar(int i) {
        int sum = i;
        while(sum%i!=0){

        }
    }

    public static void main(String[] args) {
        for (int i = 1; i < N.length; i++) {
            N[i] = false;
        }
        for (int i = 1; i < N.length; i++) {
            kaprekar(i);
            if (!N[i]) {
                System.out.println(i);
            }
        }
    }
}