import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder SB = new StringBuilder();
	
	public static void main(String[] args) throws IOException {

	int n = Integer.parseInt(BR.readLine());
	int distance[] = new int[n-1];
	int oil[] = new int[n];
	
	StringTokenizer st = new StringTokenizer(BR.readLine());
	for(int i =0 ; i<n-1;i++) distance[i] = Integer.parseInt(st.nextToken());
	
	st = new StringTokenizer(BR.readLine());
	for(int i =0 ; i<n;i++) oil[i] = Integer.parseInt(st.nextToken());

	long answer = 0;
	
	ArrayList<city> arr = new ArrayList<city>();
	arr.add(new city(oil[0], distance[0]));
	
	for(int i=1; i<oil.length-1;i++) {
		city last = arr.get(arr.size()-1);
		
		if(last.oil > oil[i]) {
			arr.add(new city(oil[i], distance[i]));
			
		}else {
			last.distance+=distance[i];
			arr.remove(arr.size()-1);
			arr.add(last);
		}
	}
  
	for(int i=0; i<arr.size();i++) answer +=arr.get(i).distance * arr.get(i).oil;
	
	System.out.println(answer);
	
	}
}

class city{
	long oil;
	long distance;
	
	city(long o, long d){
		oil = o;
		distance = d;
	}
	
}
