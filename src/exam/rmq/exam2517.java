package exam.rmq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class exam2517 {
	static int[] t;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Runner[] runners = new Runner[N];
		t = new int[N + 1];

		for (int i = 0; i < N; i++) {
			runners[i] = new Runner(i, Integer.parseInt(br.readLine()));
		}

		Arrays.sort(runners, (o1, o2) -> o1.cost - o2.cost);

		for (int i = 0; i < N; i++) {
			runners[i].cost = i + 1;
		}

		Arrays.sort(runners, (o1, o2) -> o1.order - o2.order);

		int totalRunner = 0;
		for (int i = 0; i < N; i++) {
			totalRunner++;
			System.out.println(totalRunner - sum(runners[i].cost - 1));
			update(runners[i].cost);
		}
	}

	static int sum(int i) {
		int total = 0;
		while (i > 0) {
			total += t[i];
			i -= (i & -i);
		}
		return total;
	}

	static void update(int i) {
		while (i < t.length) {
			t[i] += 1;
			i += (i & -i);
		}
	}
}

class Runner {
	int order;
	int cost;

	Runner(int order, int cost) {
		this.order = order;
		this.cost = cost;
	}
}