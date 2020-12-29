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
	static int n;
	static long d[];
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(BR.readLine());
		d = new long[1001];
		Arrays.fill(d, 0);
		
		d[1] = 1;
		d[2] = 3;
		
		for(int i=3; i<=n;i++) {
			if(i%2==0) {
				d[i] = (d[i-1]*2 +1)%10007;
			}else {
				d[i] = (d[i-1]*2 -1)%10007;
			}
		}
		
		System.out.println(d[n]);
		
	}
}
