import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder SB = new StringBuilder();

	static int f, s, g, u, d, check[];

	public static void main(String args[]) throws IOException {
		String temp[] = BR.readLine().split(" ");
		f = Integer.parseInt(temp[0]);
		s = Integer.parseInt(temp[1]);
		g = Integer.parseInt(temp[2]);
		u = Integer.parseInt(temp[3]);
		d = -1 * Integer.parseInt(temp[4]);

		// 총 f층이고 가야할 곳은 g층 나는 s층에 있음
		// u층, d층 가는
		int check[] = new int[1000001];
		int move[] = {u, d};
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		check[s]= 1;
    
		while(!queue.isEmpty()) {
			int prev = queue.poll();
			
			if(prev == g) break;
			
			for(int i=0; i<2;i++) {
				int next = prev+move[i];
				
				if(next>=1 && next<=f && check[next]==0) {
						check[next] = check[prev]+1;
						queue.add(next);
					
				}
			}
			
		}
		
		if(s==g) System.out.println(0);
		else if(check[g]==0) System.out.println("use the stairs");
		else System.out.println(check[g]-1);
	}


}
