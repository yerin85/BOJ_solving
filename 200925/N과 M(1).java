import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	
	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder SB = new StringBuilder();
    
    static int answer = 0;
	static ArrayList<Integer> temp;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String s[] = BR.readLine().split(" ");
		
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		boolean check[] = new boolean[n+1];
		int arr[] = new int[n+1];
		for(int i=1;i<=n;i++) arr[i]=i;
		Arrays.fill(check, false);
		temp = new ArrayList<Integer>();
		backtracking(arr, check, 1, m);
		//뽑아야 하는 숫자가 있고
		//트래킹할때 --
		System.out.println(SB.toString());
	}
	
	public static void backtracking(int arr[], boolean check[], int start, int count) throws IOException {
		
		if(count == 0) {
			for(int i=0;i<temp.size();i++) {
				SB.append(temp.get(i) + " ");
				
			}
			
			SB.append("\n");
			return;
		}
		
		for(int i=1; i<check.length;i++) {
			if(!check[i]) {
				check[i]=true;
				temp.add(i);
				backtracking(arr, check, i, count-1);
				check[i]=false;
				temp.remove(temp.size()-1);
			}
		}
			
	}

}
