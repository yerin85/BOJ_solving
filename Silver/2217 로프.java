import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer arr[] = new Integer[n];
		for(int i=0; i<n;i++) arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		
		//collections은 object만 가능
		
		long max = 0;
		for(int i=n-1; i>=0;i--) {
			arr[i] = arr[i]*(n-i);
			if(arr[i]>max) max = arr[i];
		}
		System.out.println(max);
	}
}
