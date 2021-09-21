package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//돌다리 건너기
public class BJ2602 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] str = br.readLine().toCharArray();
		char[][] bridge = new char[2][];
		bridge[0] = br.readLine().toCharArray();
		bridge[1] = br.readLine().toCharArray();
		
		int[][][] dp = new int[bridge[0].length][str.length][2];	//현재 k(0=악마,1=천사)돌다리의 i번째 칸이고 두루마리의 j번째 문자일 때 경우의 수
		
		for(int i = 0; i < bridge[0].length; i++) {
			for(int j = 0; j < str.length; j++) {
				for(int k = 0; k < 2; k++) {
					if(bridge[k][i] == str[j]) {	//돌다리에 적힌 문자와 두루마리에 적힌 문자가 같고,
						if(j == 0) {	//두루마리 첫 문자라면 경우의 수는 1개.
							dp[i][j][k] = 1;
						}else {	//두루마리 첫 문자가 아닌 경우.
							for(int g = i - 1; g >= 0; g--) {	//반대편 돌다리의 이전의 위치들(i-1이하) 중 두루마리에 적힌 j-1번째 문자인 경우의 수를 모두 더한다.
								dp[i][j][k] += dp[g][j - 1][1 - k];
							}
						}
					}
				}
			}
		}
		
		int sum = 0;
		for(int i = 0; i < bridge[0].length; i++) {	//두 돌다리에서 맨 마지막 두루마리 문자까지 도달한 경우의 수를 합산.
			sum += (dp[i][str.length - 1][0] + dp[i][str.length - 1][1]);
		}
		
		bw.write(sum + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
