package shake2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam15905 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		Person[] person = new Person[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			person[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(person);

		int count = 0;
		for (int i = 5; i < N; i++) {
			if (person[i].order == person[4].order) {
				count++;
			}
		}
		System.out.println(count);
	}
}

class Person implements Comparable<Person> {
	int order;
	int score;

	Person(int order, int score) {
		this.order = order;
		this.score = score;
	}


	@Override
	public int compareTo(Person o) {
		if (this.order > o.order) {
			return -1;
		} else if (this.order == o.order) {
			return this.score - o.score;
		} else {
			return 1;
		}
	}
}