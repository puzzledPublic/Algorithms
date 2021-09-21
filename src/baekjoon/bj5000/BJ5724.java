package baekjoon.bj5000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//파인만	(n x n 사각형 내의 정사각형 개수를 f(n)이라 할때 f(n) = n * n + f(n - 1)이다. (f(1) = 1) 
//위의 식(O(n))으로 풀 수도 있으나 더 보면 f(n) = n^2 + (n-1)^2 + ... 1^2이고 이는 (시그마n^2 = (k(k+1)(2k+1))/6)이다. (O(1)) 
public class BJ5724 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int i;
		while((i = Integer.parseInt(br.readLine())) != 0) {
			bw.write(((i * (i + 1) * (2 * i + 1)) / 6) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
