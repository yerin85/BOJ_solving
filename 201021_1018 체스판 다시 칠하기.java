import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder SB = new StringBuilder();

	static char map[][];
	public static void main(String args[]) throws IOException {
		String nm[] = BR.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		
		map = new char[n][m];
		for(int i=0; i<n;i++) {
			String s = BR.readLine();
			for(int j=0; j<m;j++) map[i][j] = s.charAt(j);
		}

		int ans = Integer.MAX_VALUE;
		for(int i=0; i<n;i++) {
			for(int j=0; j<m;j++) {
				if(i+8-1 <n && j+8-1<m) {
					boolean flag = true;
					ans = Math.min(ans, check(i, j, flag));
					flag = false;
					ans = Math.min(ans, check(i, j, flag));
				}
			}
		}
		
		System.out.println(ans);
		
	}
	
	static int check(int x, int y, boolean flag) {
		int sum = 0;
		
		for(int i = x; i< x+8 ; i++) {
			for(int j=y; j< y+8; j++) {
				if(map[i][j]=='B') {
					if(flag) flag = false;
					else {
						flag = true;
						sum++;
					}
				}else {
					if(!flag) flag = true;
					else {
						flag = false;
						sum++;
					}
				}
			}
			
			if(flag) flag = false;
			else flag = true;
		}
		return sum;
	}

}
