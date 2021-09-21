package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

//팩토리얼5 (BJ1676 아이디어)
public class BJ1564 {
	static int MOD = 100000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		solve(N, bw);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int n, Writer w) throws IOException {
		int count = 0;
		for(int i = 5; i <= n; i *= 5) {	//뒷자리에 0을 만드는(5x2) n이하의 5의 개수를 찾는다.
			count += (n / i);
		}
		long result = 1;
		int count2 = 0;
		for(int i = 2; i <= n; i++) {	//2~n까지 모두 곱하는데
			int k = i;
			if(count2 != count && k % 2 == 0) {	//2의 배수면 5의 개수가 될때까지 나눈다.
				while(k % 2 == 0) {	
					count2++;
					k /= 2;
					if(count2 == count) {
						break;
					}
				}
			}
			
			if(k % 5 == 0) {	//5의 배수면 모두 나눠버린다.
				while(k % 5 == 0) {
					k /= 5;
				}
				result = (result * k) % MOD;	//뒤 5자리만 알면 되므로 100000으로 나눈 나머지를 저장
			}else {
				result = (result * k) % MOD;
			}
		}
		if(result < 10000) {	//result = 5278의 경우 05278로 출력
			w.write("0" + result + "\n");
		}else {
			w.write(result + "\n");
		}
	}
}
