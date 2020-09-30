import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
            int answer = 0;
			ArrayList<info> arr = new ArrayList<info>();
			for (int j = 0; j < n; j++) {
				String temp[] = br.readLine().split(" ");
				arr.add(new info(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
			}

			Collections.sort(arr);
			int rank = n+1;

			for (info info : arr) {
				if (info.step2 < rank) {
					answer++;
					rank = info.step2;
				}
			}
			System.out.println(answer);
		}

	}
}

class info implements Comparable<info> {
	int step1;
	int step2;

	info() {
	}

	info(int s1, int s2) {
		step1 = s1;
		step2 = s2;
	}

	@Override
	public int compareTo(info o) {
		return Integer.compare(this.step1, o.step1);
	}
}
