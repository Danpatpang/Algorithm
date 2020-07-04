package acmicpc.exam.rmq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class exam2517 {
	static int[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Runner[] runners = new Runner[N];
		tree = new int[N + 1];

		for (int i = 0; i < N; i++) {
			runners[i] = new Runner(i + 1, Integer.parseInt(br.readLine()));
		}

		Arrays.sort(runners, (o1, o2) -> o1.ability - o2.ability);
		for (int i = 0; i < N; i++) {
			runners[i].ability = i + 1;
		}

		Arrays.sort(runners, (o1, o2) -> o1.order - o2.order);

		int totalRunner = 0;
		for (int i = 0; i < N; i++) {
			totalRunner++;
			System.out.println(totalRunner - sum(runners[i].ability - 1));
			update(runners[i].ability);
		}
	}

	static int sum(int i) {
		int result = 0;
		while (i > 0) {
			result += tree[i];
			i -= (i & -i);
		}
		return result;
	}

	static void update(int i) {
		while (i < tree.length) {
			tree[i] += 1;
			i += (i & -i);
		}
	}
}

class Runner {
	int order;
	int ability;

	Runner(int order, int ability) {
		this.order = order;
		this.ability = ability;
	}
}