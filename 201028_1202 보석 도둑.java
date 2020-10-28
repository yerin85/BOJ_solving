import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder SB = new StringBuilder();

	static int n, k;
	static ArrayList<Integer> bag;
	static info[] gem;

	public static void main(String args[]) throws IOException {
		String nk[] = BR.readLine().split(" ");
		n = Integer.parseInt(nk[0]);
		k = Integer.parseInt(nk[1]);

		gem = new info[n];
		bag = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(BR.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			gem[i] = new info(m,v);
		}

		Arrays.sort(gem);

		for (int i = 0; i < k; i++) {
			int c = Integer.parseInt(BR.readLine());
			bag.add(c);
		}

		Collections.sort(bag);
		long answer = 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int start = 0;
		for(int weight : bag) {
			while(start<n) {
				if(weight>=gem[start].kg) {
					pq.add(-(gem[start].value));
					start++;
				}else break;
			}
			
			if(!pq.isEmpty()) answer+=Math.abs(pq.poll());
		}
		System.out.println(answer);
	}
}

class info implements Comparable<info> {
	int kg;
	int value;

	info(int kg, int v) {
		this.kg = kg;
		value = v;
	}

	@Override
	public int compareTo(info o) {
		if (this.kg <= o.kg)
			return -1;
		else return 1;
	}
}
