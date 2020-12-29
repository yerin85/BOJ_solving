import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder SB = new StringBuilder();
	static int map[][];
	static boolean check[][];
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static int m, n, cnt;
	static ArrayList<Integer> sol;
	
	public static void main(String[] args) throws IOException {
		String mnk[] = BR.readLine().split(" ");
		m = Integer.parseInt(mnk[0]);
		n = Integer.parseInt(mnk[1]);
		int k = Integer.parseInt(mnk[2]);
		
		sol = new ArrayList<Integer>();

		map = new int[m][n];
		for (int a[] : map)
			Arrays.fill(a, 0);

		check = new boolean[m][n];
		for (boolean a[] : check)
			Arrays.fill(a, false);

		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(BR.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for (int y = y1; y < y2; y++) {
				for (int x = x1; x < x2; x++) {
					map[y][x] = 1;
				}
			}

		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0 && check[i][j] == false)
					bfs(i, j);
			}
		}

		Collections.sort(sol);
		System.out.println(sol.size());
		for(int i=0; i<sol.size();i++) {
			System.out.print(sol.get(i)+" ");
		}
	}

	public static void bfs(int x, int y) {
		cnt = 1;
		Queue<info> q = new LinkedList<info>();
		check[x][y] = true;
		q.add(new info(x, y));

		while (!q.isEmpty()) {
			info temp = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = temp.x + dx[i];
				int nextY = temp.y + dy[i];

				if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
					if (map[nextX][nextY] == 0 && check[nextX][nextY] == false) {
						check[nextX][nextY] = true;
						cnt++;
						q.add(new info(nextX, nextY));
					}
				}
			}

		}
		
		sol.add(cnt);
	}
}

class info {
	int x;
	int y;

	info(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
