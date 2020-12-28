import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Main {
	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder SB = new StringBuilder();

	static int n;
	public static void main(String args[]) throws IOException {
		int n = Integer.parseInt(BR.readLine());

		ArrayList<String> cal = new ArrayList<String>();
		int num = 9;
		HashMap<Character, Integer> alpha = new HashMap<Character, Integer>();
		for (int i = 0; i < n; i++) {
			String input = BR.readLine();
			cal.add(input);
			for (int j = 0; j < input.length(); j++) {
				if(!alpha.containsKey(input.charAt(j))) alpha.put(input.charAt(j), (int) Math.pow(10, input.length() - j));
				else alpha.replace(input.charAt(j), alpha.get(input.charAt(j)) +(int) Math.pow(10, input.length() - j));			
			}
		}
		
		List<Entry<Character, Integer>> list = new ArrayList<Entry<Character, Integer>>(alpha.entrySet());

		Collections.sort(list, new Comparator<Entry<Character, Integer>>() {
			public int compare(Entry<Character, Integer> obj1, Entry<Character, Integer> obj2) {
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});

		for (Entry<Character, Integer> entry : list) {
			alpha.replace(entry.getKey(), num);
			num--;
		}

		int answer = 0;
		for (int i = 0; i < n; i++) {
			String t = "";
			for (int j = 0; j < cal.get(i).length(); j++) {
				t += alpha.get(cal.get(i).charAt(j));
			}

			answer += Integer.parseInt(t);
		}

		System.out.println(answer);
	}
}
