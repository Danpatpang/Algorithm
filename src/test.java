import java.util.Collections;
import java.util.Vector;

public class test {
	static char A[] = {'a', 'b', 'c', 'd'};

	static void swap(int a, int b) {
		char temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}

	static void Permutation(int start, int end) {
		if (start == end) {
			for (int i = 0; i <= end; i++) {
				System.out.print(A[i]);
			}
			System.out.println();

		} else {
			for (int i = start; i <= end; i++) {
				swap(start, i);
				Permutation(start + 1, end);
				swap(start, i);
			}
		}
	}

	public static void main(String[] args) {
		Permutation(0, 3);
	}
}
