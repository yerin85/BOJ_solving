import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class test4 {
	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder SB = new StringBuilder();

	public static void main(String args[]) throws IOException {
		int n = Integer.parseInt(BR.readLine());
		
		int map[] = new int[1002];
		int maxidx = 0;
		int minidx = 1001;
		for(int i=0; i<n;i++) {
			String s[] = BR.readLine().split(" ");
			map[Integer.parseInt(s[0])] = Integer.parseInt(s[1]);
			maxidx = Math.max(maxidx, Integer.parseInt(s[0]));
			minidx = Math.min(minidx, Integer.parseInt(s[0]));
		}
		
		int L[] = new int[maxidx+1];
		int R[] = new int[maxidx+1];
		
		L[minidx] = map[minidx];
		for(int i=minidx+1; i<=maxidx;i++) {
			L[i] = Math.max(L[i-1], map[i]);
		}
		
		R[maxidx] = map[maxidx];
		for(int i=maxidx-1; i>=minidx;i--) {
			R[i] = Math.max(R[i+1], map[i]);
		}
		
		int answer = 0;
		for(int i=minidx; i<=maxidx;i++) {
			answer += Math.min(L[i], R[i]);
		}
		System.out.println(answer);
		
	}
}
