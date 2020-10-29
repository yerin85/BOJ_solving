import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class Main {
	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder SB = new StringBuilder();

	static int n;
	static String arr[];

	public static void main(String args[]) throws IOException {
		int n = Integer.parseInt(BR.readLine());

		ArrayList<String> cal = new ArrayList<String>();

		int alpha[] = new int[26];
		// -65
		int num = 9;

		HashMap<Character, info> hm = new HashMap<Character, info>();
		for (int i = 0; i < n; i++) {
			String input = BR.readLine();
			cal.add(input);
			for (int j = 0; j < input.length(); j++) {
				if (!hm.containsKey(input.charAt(j))) {
					hm.put(input.charAt(j), new info((int) Math.pow(10, input.length() - j), 1));
				} else {
					info temp = hm.get(input.charAt(j));
					int max = temp.max_length + (int) Math.pow(10, input.length() - j);
					hm.replace(input.charAt(j), new info(max, temp.count + 1));
				}
			}
		}

		List<Entry<Character, info>> list = new LinkedList<Entry<Character, info>>(hm.entrySet());
		Collections.sort(list, new Comparator<Entry<Character, info>>() {
			public int compare(Entry<Character, info> o1, Entry<Character, info> o2) {
				if (o1.getValue().max_length > o2.getValue().max_length)
					return -1;
				else if (o1.getValue().max_length == o2.getValue().max_length) {
					if (o1.getValue().count > o2.getValue().count)
						return -1;
				}
				return 1;
			}
		});

		for (Entry<Character, info> entry : list) {
			alpha[entry.getKey() - 'A'] = num;
			num--;
		}

		int answer = 0;
		for (int i = 0; i < n; i++) {
			String t = "";
			for (int j = 0; j < cal.get(i).length(); j++) {
				t += alpha[cal.get(i).charAt(j) - 'A'];
			}

			answer += Integer.parseInt(t);
		}

		System.out.println(answer);
	}
}

class info implements Comparable<info> {
	int max_length;
	int count;

	info(int m, int c) {
		max_length = m;
		count = c;
	}

	@Override
	public int compareTo(info o2) {
		if (this.max_length > o2.max_length)
			return -1;
		else if (this.max_length == o2.max_length) {
			if (this.count > o2.count)
				return -1;
		}
		return 1;
	}
}
