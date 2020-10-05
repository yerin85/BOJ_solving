import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder SB = new StringBuilder();
      
	    public static void main(String args[]) throws IOException{
	    	int n = Integer.parseInt(BR.readLine());
	    	PriorityQueue<value> pq = new PriorityQueue<value>();
	    		
	    	for(int i=0; i<n;i++) {
	    		int temp = Integer.parseInt(BR.readLine());
	    		if(temp != 0) pq.add(new value(Math.abs(temp), temp));
	    		else {
	    			if(pq.isEmpty()) System.out.println(0);
	    			else System.out.println(pq.poll().real);
	    		}
	    	}
	    	
	    }
	}

class value implements Comparable<value>{
	int abs;
	int real;
	
	value(int a, int r){
		abs = a;
		real = r;
	}
	
	@Override
	public int compareTo(value o) {
		if(this.abs > o.abs) return 1;
		else if(this.abs == o.abs) {
			if(this.real > o.real) return 1;
		}
		return -1;
	}
	
	
}




