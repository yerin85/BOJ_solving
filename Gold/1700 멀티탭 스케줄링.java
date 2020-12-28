import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder SB = new StringBuilder();

	static int n;
	static ArrayList<Queue<Integer>> arr;

	public static void main(String args[]) throws IOException {
		String nk[] = BR.readLine().split(" ");
		n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);
		ArrayList<Integer> muti = new ArrayList<Integer>();
		arr = new ArrayList<>();
		for(int i=0;i<=k;i++) {
			arr.add(new LinkedList<Integer>());
		}
		
		int order[] = new int[k];
		String goods[] = BR.readLine().split(" ");
		int cnt = 0;
        int last = 0;
		for(int i=0; i<k;i++) {
			
			int g = Integer.parseInt(goods[i]);
			order[i] = g;
			if(cnt<n) {
				if(!muti.contains(g)) {
					muti.add(g);
					cnt++;
				}
                last++;
			}
			else arr.get(g).add(i);
		}
		
		int idx = last;
		int count = 0;
		while(true) {
			if(muti.contains(order[idx])) {
				
				arr.get(order[idx]).poll();
				idx++;
			}else {
				int max = 0;
				int num = 0;
				//비거나 가장 멀리 있는 인덱스
				int insert = order[idx];
				
				for(int i=0; i<muti.size();i++) {
					int prev = muti.get(i);
					
					if(arr.get(prev).isEmpty()) {
						max = -1;
						num = prev;
						break;
					}else {
						if(max<=arr.get(prev).peek()) {
							max = arr.get(prev).peek();
							num = prev;
						}
					}
				}
				
				for(int i=0;i<muti.size();i++) {
					if(muti.get(i) == num) {
						muti.remove(i);
						count++;
					}
				}
				
				if(!arr.get(insert).isEmpty()) arr.get(insert).poll();
			
				muti.add(insert);
				idx++;
				
				
			}
			
			if(idx==k) break;
		}
		System.out.println(count);
		

		
	}
}
