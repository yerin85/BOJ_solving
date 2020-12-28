import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int x = Integer.parseInt(BR.readLine());
		
		boolean arr[] = new boolean[1001];
		for(int i=1;i<100;i++) arr[i] = true;
		for(int i=100;i<=999;i++) {
			int a = i/100;
			int b = (i-(a*100))/10;
			int c = (i-(a*100)-(b*10));
			
			if(a-b == b-c) arr[i] = true;
		}
		
		int answer = 0;
		for(int i=1;i<=x;i++) {
			if(arr[i]) answer++;
		}
		System.out.println(answer);

		
		

	}
}
