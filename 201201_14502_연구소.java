import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


//3190
public class Main {

	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder SB = new StringBuilder();
	
	static int n, m, max, map[][], copy[][];
	static boolean visited[][];
	public static void main(String args[]) throws IOException {
	
		String nm[] = BR.readLine().split(" ");
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		max = Integer.MIN_VALUE;
		
		visited = new boolean[n][m];
		map = new int[n][m];
		for(int i=0; i<n;i++) {
			StringTokenizer st = new StringTokenizer(BR.readLine());
			for(int j=0; j<m;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		backtracking(0,0,0);
		System.out.println(max);
	}
	
	static void backtracking(int x, int y, int cnt) {
		
		if(cnt == 3) {
			int count = 0;
			copy = new int[n][m];
			for(int i=0;i<n;i++) {
				for(int j=0; j<m;j++) copy[i][j] = map[i][j];
			}
			
			boolean check[][] = new boolean[n][m];
			
			for(int i=0; i<n;i++) {
				for(int j=0; j<m;j++) {
					if(copy[i][j]==2 && !check[i][j]) bfs(copy, check, i,j);
				}
			}

			for(int i=0; i<n;i++) {
				for(int j=0; j<m;j++) {
					if(copy[i][j]==0) count++;
				}
			}
			
			max = Math.max(max, count);
			return;
		}
		
		for(int i=0; i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==0 && !visited[i][j]) {
					map[i][j]=3;
					visited[i][j] = true;
					backtracking(i, j, cnt+1);
					visited[i][j] = false;
					map[i][j]=0;
				}
				
			}
		}
	}
	
	static void bfs(int copy[][], boolean check[][], int x, int y) {
		int dx[] = {-1,0,1,0};
		int dy[] = {0,1,0,-1};
		
		Queue<point> q = new LinkedList<>();
		
		for(int i=0; i<4;i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
			
			if(nextX>=0 && nextY>=0 && nextX<n && nextY<m) {
				if(copy[nextX][nextY]==0 && !check[nextX][nextY]) {
					q.add(new point(nextX, nextY));
					check[nextX][nextY] = true;
					copy[nextX][nextY] = 2;
				}
			}

		}
		
		while(!q.isEmpty()) {
			point temp = q.poll();

			for(int i=0; i<4;i++) {
				int nextX = temp.x+dx[i];
				int nextY = temp.y+dy[i];
				
				if(nextX>=0 && nextY>=0 && nextX<n && nextY<m) {
				if(copy[nextX][nextY]==0 && !check[nextX][nextY]) {
					q.add(new point(nextX, nextY));
					check[nextX][nextY] = true;
					copy[nextX][nextY] = 2;
				}
				}
			}
		}
		
	}

}

class point{
	int x;
	int y;
	
	point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
