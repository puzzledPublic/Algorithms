package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//주디와 당근농장
public class BJ16433 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		R %= 2;
		C %= 2;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if((i % 2 == R && j % 2 == C) || (i % 2 != R && j % 2 != C)) {	//예를 들어 R이 짝수이고 C가 홀수라면 ((짝수행, 홀수열), (홀수행, 짝수열)은 당근이 된다.
					bw.write("v");
				}else {
					bw.write(".");
				}
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
