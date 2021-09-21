package baekjoon.bj9000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//GCD 합
public class BJ9613 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			long sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int size = Integer.parseInt(st.nextToken());
			int[] arr = new int[size];
			for(int j = 0; j < size; j++) {	//숫자 리스트
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			for(int j = 0; j < arr.length - 1; j++) {	//숫자를 2개씩 고르는 모든 경우
				for(int k = j + 1; k < arr.length; k++) {
					sum += gcd(arr[j], arr[k]);	//해당 쌍의 gcd를 구하여 합산
				}
			}
			bw.write(sum + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
}
