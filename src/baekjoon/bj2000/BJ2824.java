package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//최대공약수
public class BJ2824 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		List<Integer> primesA = new ArrayList<>();
		for(int i = 0; i < N; i++) {	//각 수를 모두 소인수분해
			int num = Integer.parseInt(st.nextToken());
			getPrimes(num, primesA);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");

		List<Integer> primesB = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			getPrimes(num, primesB);
		}
		
		//A와 B의 소인수 분해 결과 정렬
		Collections.sort(primesA);
		Collections.sort(primesB);

		int a = 0, b = 0;
		long result = 1;
		boolean over = false;
		while(a < primesA.size() && b < primesB.size()) {
			int an = primesA.get(a);
			int bn = primesB.get(b);
			if(an == bn) {
				if(result * an >= 1_000_000_000L) {	//9자리를 넘어가는 숫자인 경우를 기억
					over = true;
				}
				result = (result * an) % 1_000_000_000L;
				a++;
				b++;
			}else if(an < bn) {
				a++;
			}else {
				b++;
			}
		}

		if(over) {	//최대공약수가 9자리가 넘어간 경우 10억으로 나머지 값을 구했기 때문에 앞의 0을 채워줘야한다.
			String str = Long.toString(result);
			for(int i = 0; i < 9 - str.length(); i++) {
				bw.write("0");
			}
			bw.write(str + "\n");
		}else {	//9자리를 안넘어가면 그냥 출력
			bw.write(result + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void getPrimes(int n, List<Integer> primes) {	//소인수 분해
		int div = 2;
		while(div * div <= n) {
			if(n % div == 0) {
				n /= div;
				primes.add(div);
			}else {
				div++;
			}
		}
		primes.add(n);
	}
}
