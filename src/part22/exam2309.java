package part22;

import com.sun.org.apache.bcel.internal.classfile.DescendingVisitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class exam2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        ArrayList<Integer> length = new ArrayList<>();
        // 데이터 삽입
        for (int i = 0; i < 9; i++) {
            int value = Integer.parseInt(br.readLine());
            length.add(value);
            sum += value;
        }

        for (int i = 0; i < length.size() - 1; i++) {
            for (int j = i + 1; j < length.size(); j++) {
                int fake = length.get(i) + length.get(j);
                // 가짜 난쟁이 선별 및 제거
                if (sum - fake == 100) {
                    length.remove(i);
                    length.remove(j - 1);
                    break;
                }
            }
        }
        // 정렬
        Collections.sort(length);


        for (int i = 0; i < length.size(); i++) {
            System.out.println(length.get(i));
        }
    }
}
