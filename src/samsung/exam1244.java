package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam1244 {
    public static int[] input, sortedInput;
    public static String money;
    public static int caseNum, changeNum, max, index, lastIndex, size, changeIndex;
    public static boolean flag, check;

    public static void swap(int a, int b) {
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        caseNum = Integer.parseInt(br.readLine());

        for (int i = 1; i <= caseNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            money = st.nextToken();
            input = new int[money.length()];
            sortedInput = new int[money.length()];
            changeNum = Integer.parseInt(st.nextToken());

            for (int j = 0; j < money.length(); j++) {
                input[j] = money.charAt(j) - '0';
            }
            sortedInput = input.clone();
            Arrays.sort(sortedInput);

            index = 0;
            lastIndex = money.length() - 1;
            size = money.length();
            max = sortedInput[money.length() - 1];
            flag = true;
            check = false;

            while (changeNum != 0) {
                // 이미 정렬이 끝난지 확인
                for (int j = 0; j < size; j++) {
                    if (input[j] != sortedInput[size - 1 - j]) {
                        flag = false;
                        break;
                    }
                }

                // 동일한 숫자의 존재 유무 확인
                for (int j = size - 1; j > 0; j--) {
                    if (sortedInput[j] == sortedInput[j - 1]) {
                        check = true;
                        break;
                    }
                }

                // 정렬이 끝나고 동일한 숫자가 존재하는 경우
                if (check && flag) {
                    break;
                }

                // 길이가 2이고
                if (money.length() == 2 || (changeNum % 2 == 0 && flag)) {
                    swap(0, 1);
                    break;
                } else {
                    if (index < size) {
                        // 현재 값이 최대 값이 아닐 때
                        if (input[index] != sortedInput[size - 1 - index]) {
                            for (int j = size - 1; j > index; j--) {
                                // 최대 값이 될 경우
                                if (input[j] == sortedInput[size - 1 - index]) {
                                    changeIndex = j;
                                    swap(index, changeIndex);
                                    // 이전 값이 동일한 경우 가장 큰 수가 되야하므로 마지막 2자리를 비교 후 결정.
                                    if (index > 0 && index < size && input[index - 1] == input[index]) {
                                        if (input[changeIndex] < input[changeIndex + 1]) {
                                            swap(changeIndex, changeIndex + 1);
                                        }
                                    }

                                    break;
                                }
                            }

                            index++;
                            changeNum--;
                        } else if (input[index] == sortedInput[size - 1 - index]) {
                            index++;
                        }
                    } else {
                        swap(size - 2, size - 1);
                        changeNum--;
                    }
                }
            }

            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < money.length(); j++) {
                sb.append(input[j]);
            }

            System.out.println("#" + i + " " + sb.toString());
        }
    }
}