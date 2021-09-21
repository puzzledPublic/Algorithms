package baekjoon.bj6000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//이항 쇼다운	nCr = nC(n-r)을 이용하는 문제.	(n/2 < r)이라면 nC(n-r)을 이용하는것이 더 효율적
public class BJ6591 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n, k;
		while(true){
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			if(n == 0 && k == 0) {
				break;
			}
			if(n / 2 < k) {
				k = n - k;
			}
			int div = 1;
			long result = 1;
			while(k-- > 0) {
				result *= n--;	// nPr
				result /= div++; // 1/r!
			}
			/*
			 * k -> 1순으로 나누면 소수점 값이 나와서 부정확한 값이 나온다.
			 * long result = 1;
			for(int i = 0; i < k; i++) {
				System.out.println((n - i) + " " + (k - i));
				result *= (n - i);
				result /= (k - i);
			}*/
			bw.write(result + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
