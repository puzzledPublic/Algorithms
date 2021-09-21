package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//피자는 나눌 수록 커지잖아요
public class BJ17946 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int K = Integer.parseInt(br.readLine());
			
			//평면분할을 이용하면 K개의 직선으로 구역을 나눌때 최대 구역 개수는 2, 4, 7, 11, 16 ... 계차수열이 되어 일반화하면 (K * K + K + 2) / 2가 된다.
			bw.write((((K * K + K + 2) / 2) - ((K * K + K) / 2)) + "\n");	//계산에 의해 결국 1
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
