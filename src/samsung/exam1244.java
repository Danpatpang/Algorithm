package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam1244 {
    public static char[] value, temp;
    public static String money;
    public static int count, answer;

    public static void go(char[] array, int pos, int cnt) {
        if (count == cnt) {
            int ret = Integer.valueOf(array.toString());
            if (ret > answer) {
                answer = ret;
            }
            return;
        }

        if (pos == array.length - 2) {
            temp = array;
            swap(temp, pos + 1, pos);
            go(temp, pos, cnt + 1);
            return;
        }

        int big = -1;
        for (int i = pos + 1; i < array.length; i++) {
            if (array[i] - '0' > big) {
                big = array[i] - '0';
            }
        }

        if (array[pos] - '0' == big) {
            go(array, pos + 1, cnt);
        }

        for (int i = pos + 1; i < array.length; i++) {
            if (array[i] - '0' == big) {
                temp = array;
                swap(temp, i, pos);
                go(temp, pos + 1, cnt + 1);
            }
        }
    }

    public static void swap(char[] array, int a, int b) {
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            value = new char[6];
            StringTokenizer st = new StringTokenizer(br.readLine());

            money = st.nextToken();
            for (int j = 0; j < money.length(); j++) {
                value[j] = money.charAt(j);
            }
            count = Integer.parseInt(st.nextToken());

            go(value, 0, 0);
//            for (int j = 0; j < count; j++) {
//                // 초과
//                if (count > money.length()) {
//                    int temp = value[money.length() - 1];
//                    value[money.length() - 1] = value[money.length() - 2];
//                    value[money.length() - 2] = temp;
//                }
//
//                int max = value[j];
//                int index = j;
//                for (int k = money.length() - 1; k > j; k--) {
//                    if (value[k] > max) {
//                        max = value[k];
//                        index = k;
//                    }
//                }
//
//                if (index == j && index != money.length() - 2) {
//
//
//                    int temp = value[money.length() - 1];
//                    value[money.length() - 1] = value[money.length() - 2];
//                    value[money.length() - 2] = temp;
//                } else {
//                    int temp = value[index];
//                    value[index] = value[j];
//                    value[j] = temp;
//                }
//            }

            System.out.println("#" + i + " " + answer);
        }
    }
}
