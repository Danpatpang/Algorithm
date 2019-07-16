	package samsung;

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.StringTokenizer;

	public class exam3431 {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(br.readLine());

			for (int i = 1; i <= T; i++) {
				StringBuffer sb = new StringBuffer("#" + i + " ");
				StringTokenizer st = new StringTokenizer(br.readLine());

				int L = Integer.parseInt(st.nextToken());
				int U = Integer.parseInt(st.nextToken());
				int X = Integer.parseInt(st.nextToken());

				if (X > U) sb.append(-1);
				else if (X <= U && X >= L) sb.append(0);
				else sb.append(L - X);

				System.out.println(sb.toString());
			}
		}
	}
