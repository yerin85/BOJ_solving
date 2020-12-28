import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class Main {
	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));


	public static void main(String[] args) throws IOException {

		int t = Integer.parseInt(BR.readLine());
		for (int test = 0; test < t; test++) {
			StringBuilder SB = new StringBuilder();
			String p = BR.readLine();
			int n = Integer.parseInt(BR.readLine());
			String s = BR.readLine();
			String num[] = s.substring(1, s.length() - 1).split(",");

			Deque<String> deque = new ArrayDeque<String>();
			for (String v : num) {
				deque.add(v);
			}

			if (n == 0)
				deque.clear();

			boolean check = false; // 정방향
			for (int i = 0; i < p.length(); i++) {
				if (p.charAt(i) == 'R') {
					if (!check)
						check = true;
					else
						check = false;
				} else {
					if (deque.isEmpty()) {
						SB.append("error");
						break;
					} else {
						if (!check)
							deque.pollFirst();
						else
							deque.pollLast();
					}
				}

			}

			if (!deque.isEmpty()) {
				SB.append("[");
				while (!deque.isEmpty()) {
					if(check) {
						if (deque.size() == 1)
							SB.append(deque.pollLast() +"]");
						else
							SB.append(deque.pollLast() + ",");
					}else {
						if (deque.size() == 1)
							SB.append(deque.poll() + "]");
						else
							SB.append(deque.poll() + ",");
					}
				}
			}else {
				if(SB.length()==0) SB.append("[]");
			}
			
			
			
			System.out.println(SB);
		}

	}

}
