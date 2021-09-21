package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//분수 합
public class BJ1735 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[][] number = new int[2][2];
		for(int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			number[i][0] = Integer.parseInt(st.nextToken());
			number[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int A, B, gcd;
		A = number[0][0] * number[1][1] + number[1][0] * number[0][1];	//분자
		B = number[0][1] * number[1][1];								//분모
		gcd = getGCD(A, B);	//분자, 분모의 최소공배수
		
		bw.write((A / gcd) + " " + (B / gcd) + "\n");	//기약분수
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int getGCD(int a, int b) {
		if(b == 0) {
			return a;
		}
		return getGCD(b, a % b);
	}
}
