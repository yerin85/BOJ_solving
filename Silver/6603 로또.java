import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder SB = new StringBuilder();

	static int arr[];
	static ArrayList<Integer> temp;
	public static void main(String[] args) throws IOException {
		String s = BR.readLine();
		
		while(true) {
			if(s.equals("0")) break;
			else {
				StringTokenizer st = new StringTokenizer(s);
				int n = Integer.parseInt(st.nextToken());
				arr = new int[n];
				temp = new ArrayList<Integer>();
				for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());
				
				lotto(temp , 0, 6);
				System.out.println(SB);
				SB.setLength(0);
				s = BR.readLine();
				
			}
		}

	}
	
	static void lotto(ArrayList<Integer> s, int start, int count) {
		if(count == 0) {
			for(int i=0; i<s.size();i++) {
				SB.append(s.get(i)+" ");
			}
			SB.append("\n");
			return;
		}
		
		for(int i= start; i<arr.length;i++) {
			if(i==arr.length&& count>1) return;
			s.add(arr[i]);
			lotto(s, i+1, count-1);
			s.remove(s.size()-1);
		}
	}
}
