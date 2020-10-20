import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test4 {
	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder SB = new StringBuilder();

	static int n, map[][];
	static boolean check[][];

	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String args[]) throws IOException {
		n = Integer.parseInt(BR.readLine());

		map = new int[n][n];
		check = new boolean[n][n];
		int height = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(BR.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				height = Math.max(map[i][j], height);
			}
		}

		int ans = 0;
		for (int h = 0; h <= height; h++) {
			int max = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					check[i][j] = false;
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] > h && !check[i][j]) {
						max++;
						bfs(i, j, h);
					}

				}
			}

			ans = Math.max(ans, max);
		}

		System.out.println(ans);

	}

	public static void bfs(int x, int y, int h) {

		Queue<xy> queue = new LinkedList<>();
		queue.add(new xy(x, y));

		while (!queue.isEmpty()) {
			xy prev = queue.poll();
			int thisx = prev.x;
			int thisy = prev.y;

			for (int i = 0; i < 4; i++) {
				int nextX = thisx + dx[i];
				int nextY = thisy + dy[i];

				if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < n) {
					if (!check[nextX][nextY] && map[nextX][nextY] > h) {
						queue.add(new xy(nextX, nextY));
						check[nextX][nextY] = true;
					}

				}

			}
		}
	}
}

class xy {
	int x;
	int y;

	xy(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
