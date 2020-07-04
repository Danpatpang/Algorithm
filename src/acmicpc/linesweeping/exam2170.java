package acmicpc.linesweeping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam2170 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Line[] lines = new Line[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			lines[i] = new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(lines);

		int result = 0;
		int left = Integer.MIN_VALUE;
		int right = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			if(lines[i].end < right) {
				continue;
			}
			if (right < lines[i].start) {
				left = lines[i].start;
			} else {
				left = right;
			}
			right = lines[i].end;
			result += (right - left);
		}
		System.out.println(result);
	}
}

class Line implements Comparable<Line> {
	int start;
	int end;

	Line(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Line o) {
		if (this.start > o.start) return 1;
		else if (this.start == o.start) {
			if (this.end > o.end) return 1;
			else return -1;
		} else return -1;
	}
}