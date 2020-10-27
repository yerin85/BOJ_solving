import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class test4 {
	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder SB = new StringBuilder();

	public static void main(String args[]) throws IOException {
		String nm[] = BR.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);

		HashMap<Integer, String> inttost = new HashMap<Integer, String>();
		HashMap<String, Integer> sttoint = new HashMap<String, Integer>();

		for (int i = 1; i <= n; i++) {
			String s = BR.readLine();
			inttost.put(i, s);
			sttoint.put(s, i);
		}

		for (int i = 0; i < m; i++) {
			String s = BR.readLine();

			if (Character.isDigit(s.charAt(0))) {
				int in = Integer.parseInt(s);

				System.out.println(inttost.get(in));
			} else
				System.out.println(sttoint.get(s));

		}
	}

}
