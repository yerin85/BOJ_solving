import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder SB = new StringBuilder();
	static int check[];
	static int n;
	static int k;
	public static void main(String[] args) throws IOException {
		String sk[] = BR.readLine().split(" ");
		 n = Integer.parseInt(sk[0]);
		 k = Integer.parseInt(sk[1]);
		/*
		 * 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤
		 * 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로
		 * 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다. 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을
		 * 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
		 * 
		 */
		check = new int[100001];
		Arrays.fill(check, 0);

		if (n == k)
			System.out.println(0);
		else {
			bfs(n);
			
		}
			
		

	}

	static void bfs(int num) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(num);
		check[num] = 1;

		while (!q.isEmpty()) {
			int temp = q.poll();
			for (int i = 0; i < 3; i++) {
				int next = 0;
				if (i == 0)
					next = temp + 1;
				else if (i == 1)
					next = temp - 1;
				else
					next = 2 * temp;
				
				if(next == k) {
					System.out.println(check[temp]);
					return;
				}
				
				if (next >= 0 && next < check.length && check[next] == 0) {
					check[next] = check[temp] + 1;
					q.add(next);
				}
			}

		}
		return;
	}
}
