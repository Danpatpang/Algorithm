package part9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class exam1427 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuffer sb = new StringBuffer();
		LinkedList<Integer> list = new LinkedList<Integer>();

		for (int i = 0; i < s.length(); i++) {
			list.add(Integer.valueOf(s.charAt(i) - '0'));
		}
		list.sort((o1, o2) -> o2 - o1);

		for (int i : list) {
			sb.append(i);
		}
		System.out.println(sb.toString());
	}
}
