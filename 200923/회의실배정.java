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
		int n = Integer.parseInt(br.readLine());

		ArrayList<time> arr = new ArrayList<time>();
		for (int i = 0; i < n; i++) {
			String temp[] = br.readLine().split(" ");
			int start = Integer.parseInt(temp[0]);
			int end = Integer.parseInt(temp[1]);

			arr.add(new time(start, end));
		}
		Collections.sort(arr);

		int start = arr.get(0).start;
		int end = arr.get(0).end;
		
		ArrayList<time> arraysort = new ArrayList<time>();
		arraysort.add(new time(start, end));
		for(int i=1; i<arr.size();i++) {
			if(arr.get(i).start == start && arr.get(i).end == end) continue;
			else arraysort.add(arr.get(i));
			start = arr.get(i).start;
			end = arr.get(i).end;
		}
		
		
		start = -1;
		int answer = 0;
		for(time t: arr) {
		//	System.out.println(t.start +" " + t.end);
			if(t.start>=start) {
				answer++;
				start = t.end;
				
			}
		}
		
		System.out.println(answer);
	}
}

class time implements Comparable<time> {
	int start;
	int end;

	time() {
	}

	time(int s, int e) {
		start = s;
		end = e;
	}

	@Override
	public int compareTo(time o) {
		if(this.end == o.end) return Integer.compare(this.start, o.start);
		return Integer.compare(this.end, o.end);
	}

}
