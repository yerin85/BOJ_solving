import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//d 10 c 26
		
		String s = br.readLine();
		int answer = 1;
		int c = 26;
		int d = 10;
		char prv = 'a';
		for(int i=0; i<s.length();i++) {
			if(s.charAt(i) == 'c') {
				if(prv==s.charAt(i)) c=25;
				else c=26;
				
				answer*=c;
				prv = s.charAt(i);
			}else {
				if(prv==s.charAt(i)) d=9;
				else d=10;
				
				answer*=d;
				prv = s.charAt(i);
			}
		}
		System.out.println(answer);
		
	}

}
