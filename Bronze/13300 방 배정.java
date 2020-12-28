import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder SB = new StringBuilder();

	public static void main(String args[]) throws IOException {
		String nk[] = BR.readLine().split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);
		
		int room[][] = new int[7][2];
		for(int i=0; i<n;i++) {
			String sm[] = BR.readLine().split(" ");
			int s = Integer.parseInt(sm[0]);
			int m = Integer.parseInt(sm[1]);
			//s 0여자 1남자
			room[m][s]++;
		}
			
		int answer = 0;
		for(int i=1; i<=6;i++) {
			for(int j=0; j<2;j++) {
				if(room[i][j]==0) continue;
				
				answer += room[i][j]/k; 
				if(room[i][j]%k!=0) answer++; 
				
			}
		}
		
		System.out.println(answer);
	}
}
