package part7;

import java.util.ArrayList;
import java.util.Scanner;

public class exam1316 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = Integer.parseInt(s.nextLine());
        int result = 0;
        for (int i = 0; i < N; i++) {
            String str = s.nextLine();
            boolean checking = true;
            ArrayList arrayList = new ArrayList();
            arrayList.add(str.charAt(0));
            check:
            for (int j = 0; j < str.length() - 1; j++) {
                if (str.charAt(j) != str.charAt(j + 1)) {
                    if (arrayList.contains(str.charAt(j + 1))) {
                        checking = false;
                        break check;
                    }
                    arrayList.add((str.charAt(j + 1)));
                }
            }
            if(checking){
                result++;
            }
        }
        System.out.println(result);
    }
}
