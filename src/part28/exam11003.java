package part28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class exam11003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Deque<Node> deque = new LinkedList<Node>();

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		StringBuffer sb = new StringBuffer();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());

			if (!deque.isEmpty() && deque.peekFirst().index + L == i) {
				deque.removeFirst();
			}

			while (!deque.isEmpty() && deque.peekLast().value > now) {
				deque.removeLast();
			}

			deque.addLast(new Node(now, i));
			sb.append(deque.peekFirst().value + " ");
		}

		System.out.println(sb.toString());
	}
}

class Node {
	public int value;
	public int index;

	Node(int value, int index) {
		this.value = value;
		this.index = index;
	}
}