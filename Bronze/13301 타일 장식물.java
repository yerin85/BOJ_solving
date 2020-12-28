import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder SB = new StringBuilder();

	public static void main(String args[]) throws IOException {
		int n = Integer.parseInt(BR.readLine());

		long D[] = new long [82];
		D[1] = 1;
		for(int i=2;i<=81;i++) D[i] = D[i-1]+D[i-2];
		long answer = D[n]*2 + D[n+1]*2;
		System.out.println(answer);
	}
}
