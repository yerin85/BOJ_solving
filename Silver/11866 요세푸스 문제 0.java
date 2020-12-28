import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class test4 {
	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder SB = new StringBuilder();

	static int n, k;

	public static void main(String args[]) throws IOException {
		String nk[] = BR.readLine().split(" ");
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);
		
		for(int i=1; i<=n;i++) ll.add(i);
		
		int cnt = 1;
		int idx = 0;
		
		while(!ll.isEmpty()) {
			if(cnt%k == 0) {
				ans.add(ll.get(idx));
				ll.remove(idx);
				idx--;
			}
			
			cnt++; idx++;
			
			if(idx == ll.size()) idx=0;
		}
		
		SB.append("<"+ans.get(0));
		for(int i=1;i<ans.size();i++) SB.append(", "+ans.get(i));
		SB.append(">");
		System.out.println(SB);
	}

}
