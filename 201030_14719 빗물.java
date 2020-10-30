import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder SB = new StringBuilder();

	public static void main(String args[]) throws IOException {
		String hw[] = BR.readLine().split(" ");
		int h = Integer.parseInt(hw[0]);
		int w = Integer.parseInt(hw[1]);

		int map[] = new int[w];
		StringTokenizer st = new StringTokenizer(BR.readLine());
		for (int i = 0; i < w; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}

		int L[] = new int[w];
		int R[] = new int[w];

		L[0] = map[0];
		for (int i = 1; i < w; i++) {
			L[i] = Math.max(L[i - 1], map[i]);
		}

		R[w - 1] = map[w - 1];
		for (int i = w - 2; i >= 0; i--) {
			R[i] = Math.max(R[i + 1], map[i]);
		}

		int answer = 0;
		for (int i = 0; i < w; i++) {
			answer += (Math.min(L[i], R[i]) - map[i]);
		}
		System.out.println(answer);
	}
}
