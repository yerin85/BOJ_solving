import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder SB = new StringBuilder();

	static char map[][];
	static boolean check[][];
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};
	static Queue<xy>colors;
	
	public static void main(String args[]) throws IOException {
		map = new char[12][6];
		check= new boolean[12][6];
		colors = new LinkedList<>();
		for(int i=0; i<12;i++) {
			char temp[] = BR.readLine().toCharArray();
			for(int j=0; j<6;j++) map[i][j] = temp[j];
		}
		
		int answer = 0;
		while(true) {
			for(boolean c[]:check) Arrays.fill(c, false);
			//1. 뿌요찾기
			for(int i=0; i<12;i++) {
				for(int j=0; j<6;j++) {
					if(map[i][j]!='.' && !check[i][j]) game(i, j, 1);
				}
			}
			
			//없애기 전에 폭발할 뿌요 없음 종료
			if(colors.isEmpty()) break;
			//2. 없애버리기
			for(boolean c[]:check) Arrays.fill(c, false);
			
			while(!colors.isEmpty()) {
				xy del = colors.poll();
				delete(del.x, del.y);
			}
			
			//3. 내리기
			down();
			answer++;
		}
		System.out.println(answer);
		
		
	}
	
	static void down() {
		for(int i=0; i<6;i++) {
			ArrayList<Character> temp = new ArrayList<>();
			
			for(int j=11; j>=0;j--) {
				if(map[j][i]!='.') temp.add(map[j][i]);
			}
			
			for(int j=0; j<12;j++) map[j][i] = '.';
			
			int idx = 11;
			while(!temp.isEmpty()) {
				map[idx][i] = temp.get(0);
				idx--;
				temp.remove(0);
			}
			
		}
	}
	
	static void delete(int x, int y) {
		char color = map[x][y];
		
		map[x][y]='.';
		Queue<xy> queue = new LinkedList<>();
		check[x][y] = true;
		
		for(int i=0; i<4;i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
		
			if(nextX>=0 && nextY>=0 && nextX<12 && nextY<6 ) {
				if(color == map[nextX][nextY] && !check[nextX][nextY]) {
					queue.add(new xy(nextX, nextY));
				}
			}
		}
		
		while(!queue.isEmpty()) {
			xy next = queue.poll();
			delete(next.x, next.y);
		}
		return;
	}
	
	static int game(int x, int y, int cnt) {
		char color = map[x][y];
		Queue<xy> queue = new LinkedList<>();
		check[x][y] = true;
		
		if(cnt==4) {
			colors.add(new xy(x, y));
			return cnt;
		}
		
		
		for(int i=0; i<4;i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
		
			if(nextX>=0 && nextY>=0 && nextX<12 && nextY<6 ) {
				if(color == map[nextX][nextY] && !check[nextX][nextY]) {
					queue.add(new xy(nextX, nextY));
				}
			}
		}
		
		while(!queue.isEmpty()) {
			xy next = queue.poll();
			cnt = game(next.x, next.y, cnt+1);
		}
		return cnt;
	}
}


class xy{
	int x;
	int y;
	
	xy(int x, int y){
		this.x = x;
		this.y =y;
	}
}
