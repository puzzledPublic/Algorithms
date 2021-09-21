package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//조합 0의 개수
public class BJ2004 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		long n = Integer.parseInt(st.nextToken());
		long m = Integer.parseInt(st.nextToken());
		
		int countN5 = 0, countM5 = 0, countN2 = 0, countM2 = 0;	//n! / r! * (n - r)!의 5의 개수, 2의 개수를 구한다.
		//단순 n!일때는 5의 개수가 2의 개수보다 적으므로 5의 개수로 마지막 0의 개수를 알 수 있었지만
		//nCm에서는 나눗셈으로 인해 2의 개수가 더 적어질 수 있으므로 2의 개수도 구해야한다.
		for(long i = 5; i <= n; i *= 5) {
			countN5 += (n / i);
		}
		for(long i = 2; i <= n; i *= 2) {
			countN2 += (n / i);
		}
		for(long i = 5; i <= n - m; i *= 5) {
			countN5 -= ((n - m) / i);
		}
		for(long i = 2; i <= n - m; i *= 2) {
			countN2 -= ((n - m) / i);
		}
		for(long i = 5; i <= m; i *= 5) {
			countM5 += (m / i);
		}
		for(long i = 2; i <= m; i *= 2) {
			countM2 += (m / i);
		}
		
		countN5 -= countM5;
		countN2 -= countM2;
		bw.write(Math.min(countN5, countN2) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
