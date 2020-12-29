import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder SB = new StringBuilder();
	
    static boolean check[];
    static ArrayList<Integer> temp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String mn[] = BR.readLine().split(" ");
		int M = Integer.parseInt(mn[0]);
		int N = Integer.parseInt(mn[1]);
		
		check = new boolean[M+1];
		Arrays.fill(check, false);
		temp = new ArrayList<Integer>();
		backtracking(1, N, check);
		System.out.println(SB.toString());
	}
	
	
	static void backtracking(int start, int count, boolean check[]) {
		if(count==0) {
			for(int i=0; i<temp.size();i++) SB.append(temp.get(i)+" ");
			SB.append("\n");
			return;
		}
		
		for(int i=start; i<check.length;i++) {
			if(!check[i]) {
				if(!temp.isEmpty()) if(temp.get(temp.size()-1) > i ) continue;
				temp.add(i);
				check[i] = true;
				backtracking(i, count-1, check);
				check[i] = false;
				temp.remove(temp.size()-1);
			}
		}
		
	}
	
	
}
