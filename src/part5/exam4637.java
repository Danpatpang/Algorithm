package part5;

public class exam4637 {
    static boolean[] N = new boolean[10000];

    static int check(int n) {
        int result = n;
        while (n > 0) {
            result += (n % 10);
            n /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i = 0; i < N.length; i++) {
            N[i] = false;
        }
        for (int i = 0; i < N.length; i++) {
            int result = check(i+1);
            if (result <= N.length) {
                N[result-1] = true;
            }
        }

        for (int i = 0; i < N.length; i++) {
            if (!N[i]){
                System.out.println(i+1);
            }
        }

    }
}