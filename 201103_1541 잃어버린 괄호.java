import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String s = BR.readLine();
		
		LinkedList<String> st = new LinkedList<String>();
		String temp = "";
		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == '-' || s.charAt(i) == '+') {
				st.add(temp);
				st.add(String.valueOf(s.charAt(i)));
				temp = "";
			} else
				temp += s.charAt(i);

			if (i == s.length() - 1) {
				st.add(temp);
			}
		}
		
		

		int oper = 1;
		int sum = 0;
		while (true) {
			if (st.size() <= 3)
				break;
			if (st.get(oper).equals("-")) {
				if (st.get(oper + 2).equals("+")) {
					sum = Integer.parseInt(st.get(oper + 1)) + Integer.parseInt(st.get(oper + 3));
					st.set(oper + 1, String.valueOf(sum));
					st.remove(oper + 2);

					if (st.size() == 3)
						break;
					st.remove(oper + 2);

				} else {
					sum = Integer.parseInt(st.get(oper - 1)) - Integer.parseInt(st.get(oper + 1));
					st.set(oper - 1, String.valueOf(sum));
					st.remove(oper + 1);
					if (st.size() == 3)
						break;
					st.remove(oper);
				}
			} else {
				sum = Integer.parseInt(st.get(oper - 1)) + Integer.parseInt(st.get(oper + 1));
				st.set(oper - 1, String.valueOf(sum));
				st.remove(oper + 1);
				if (st.size() == 3)
					break;
				st.remove(oper);

			}

		}

		if(st.size()==3) {
			if (st.get(1).equals("+")) sum = Integer.parseInt(st.get(0)) + Integer.parseInt(st.get(2));
			else sum = Integer.parseInt(st.get(0)) - Integer.parseInt(st.get(2));			
		}else sum = Integer.parseInt(st.get(0));


		System.out.println(sum);

	}
}
