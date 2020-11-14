import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String s = BR.readLine();

		String answer = "";
		boolean flag = false;
		String temp = "";
		
		for(int i=0; i<s.length();i++) {
			char a = s.charAt(i);
			
			if(a=='<' || flag) {
				if(a=='<') {
					flag = true;
					if(!temp.equals("")) {
						for(int j=temp.length()-1;j>=0;j--) answer+=temp.charAt(j);
						temp="";
					}
				}
				else if(a=='>') flag = false;
				
				answer+=a;
				
				
			}else {
				if(a==' ') {
					if(!temp.equals("")) {
						for(int j=temp.length()-1;j>=0;j--) answer+=temp.charAt(j);
						temp="";
					}
					answer+=a;
				}else temp+=a;
			}
			

		}
		
		if(!temp.equals("")) {
			for(int j=temp.length()-1;j>=0;j--) answer+=temp.charAt(j);
			temp="";
		}		
		

		System.out.println(answer);
	}
}
