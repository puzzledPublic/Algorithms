package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//줄세우기
public class BJ2631 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] line = new int[N];	//서있는 어린이 번호
		int[] dp = new int[N];		//i번째 어린이 번호까지의 LIS
		
		for(int i = 0; i < N; i++) {
			line[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i < N; i++) {
			dp[i] = 1;	//기본적으로 자기자신 LIS는 1
			for(int j = i - 1; j >= 0; j--) {	//그 이전 어린이 번호중에
				if(line[j] < line[i]) {	//현재 어린이 번호보다 작으면서 
					dp[i] = Math.max(dp[i], dp[j] + 1);	//가장 긴 LIS를 가진 숫자를 골라 현재 어린이의 LIS를 갱신.
				}
			}
		}
		
		int max = 1;
		for(int i = 0; i < N; i++) {	//가장 긴 LIS를 찾는다.
			max = Math.max(max, dp[i]);
		}
		
		bw.write((N - max) + "\n");	//최소로 옮길 어린이 수는 총 어린이 수에서 LIS를 뺀 숫자가 된다.
		bw.flush();
		bw.close();
		br.close();
	}
}
