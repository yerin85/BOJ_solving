import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder SB = new StringBuilder();

	static String alphabet[];
	public static void main(String[] args) throws IOException {
		String ls[] = BR.readLine().split(" ");
		int l = Integer.parseInt(ls[0]); 
		int s = Integer.parseInt(ls[1]); 
		
		
		alphabet = new String[s];
		StringTokenizer st = new StringTokenizer(BR.readLine());
		for(int i=0; i<s;i++) alphabet[i] = st.nextToken();
		Arrays.sort(alphabet);
		
		func(0, l, new StringBuffer(""));
		System.out.println(SB);
	}
	
	public static void func(int start, int count, StringBuffer s) {

		//이게 조건! 모음은 1개 이상 자음은 2개 이상
		if(count==0) {
			int mo = 0;
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u') mo++;
			}
			
			if(mo>=1 && s.length()-mo >=2) {
				SB.append(s);
				SB.append("\n");
			}
			return;
		}
		
		for(int i = start; start<alphabet.length;i++) {
			if(i==alphabet.length) return;
      
			s.append(alphabet[i]);
			func(i+1, count-1, s);
			s.deleteCharAt(s.length()-1);
		}		
	}
}
