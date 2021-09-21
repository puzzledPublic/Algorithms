package baekjoon.bj4000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

//피보나치 수
public class BJ4150 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		//큰 수(최대 1000자리)이므로 BigInteger나 직접 배열을 이용해 계산할 수 있다.
		BigInteger f1 = new BigInteger("1");
		BigInteger f2 = new BigInteger("1");
		
		for(int i = 0; i < N - 2; i++) {
			BigInteger t = f1.add(f2);
			f1 = f2;
			f2 = t;
		}
		
		bw.write(f2.toString());
		
		bw.flush();
		bw.close();
		br.close();
	}
}
