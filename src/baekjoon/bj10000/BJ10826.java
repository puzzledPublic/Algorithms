package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

//피보나치 수 4
public class BJ10826 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		BigInteger prev1 = new BigInteger("0");
		BigInteger prev2 = new BigInteger("1");
		int i = 1;
		while(i <= N) {
			BigInteger temp = prev1.add(prev2);
			prev1 = prev2;
			prev2 = temp;
			i++;
		}
		bw.write(prev1.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
