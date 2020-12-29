import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String nk[] = BR.readLine().split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);
		
		int arr[] = new int[n];
		StringTokenizer st = new StringTokenizer(BR.readLine());
		for(int i=0; i<n;i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int D[] = new int[n];
		for(int i=0;i<k;i++) D[0]+=arr[i];
		
		int max = D[0];
		for(int i=1; i<=n-k;i++) {
			D[i] = D[i-1] + arr[i+k-1] -arr[i-1];
			max = Math.max(max, D[i]);
		}
		System.out.println(max);
	}
}
