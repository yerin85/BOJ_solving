import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

	static boolean check[];
	static int ans = 0;
	static int n, s, arr[];
	public static void main(String[] args) throws IOException {
	
		String ns[] = BR.readLine().split(" ");
		n = Integer.parseInt(ns[0]);
		s = Integer.parseInt(ns[1]);
		

		arr = new int[n];
		check = new boolean[n];
		
		StringTokenizer st = new StringTokenizer(BR.readLine());
		for(int i=0; i<n;i++) arr[i] = Integer.parseInt(st.nextToken());
		
		func(0, 0);
		
		System.out.println(ans);
	}
	
	static void func(int start, int sum) {
		
		if(start == n) {
			return;
		}
		
		for(int i=start;i<n;i++) {
			if(!check[i]) {
				check[i] = true;
				sum+=arr[i];
				if(sum==s) ans++;
				func(i+1, sum);
				sum-=arr[i];
				check[i]=false;
				
			}
		}
	}

		

}
