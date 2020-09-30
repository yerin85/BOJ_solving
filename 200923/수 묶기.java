import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(arr,new Comp());
		
		//for(int i: arr) System.out.println(i);
		int first = arr.get(0);
		int answer = 0;
		
		for (int i = 1; i < n; i++) {
			if (first == 20000) {
				first = arr.get(i);
			} else {
				// 값이 있는 경우
				if(first>0 && arr.get(i)>0) {
					if(first*arr.get(i) > first+arr.get(i)) {
						answer += (first*arr.get(i));
					}else {
						answer += (first+arr.get(i));
					}
					first = 20000;
				}else if(first<0 && arr.get(i)<0) {
					answer += (first*arr.get(i));
					first = 20000;
				}else {
					//둘중하나가 음수임
					if(first == 0 || arr.get(i)==0) answer+=0;
					else answer+=first;
					first = arr.get(i);
				}
			}
		}
		
		if(first!=20000) answer+=first;
		System.out.println(answer);
	}
}

class Comp implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1>0 && o2>0) return o2.compareTo(o1);
		else return o1.compareTo(o2);
	}
	
}





