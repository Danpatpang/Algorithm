package acmicpc.Sogang2017;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class exam14935 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("FA");
        bw.flush();
        bw.close();
    }

//    public static void f(int x) {
//        if (x == 0) {
//            System.out.println("FA");
//            return;
//        }
//        int length = (int) Math.log10(x) + 1;
//        int first = x / (int) Math.pow(10, length - 1);
//        int result = (length) * first;
//        if (x == result) {
//            System.out.println("FA");
//        } else {
//            f(result);
//        }
//    }
}
