package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//3루수는 몰라
public class BJ17351 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		char[][] ground = new char[N + 1][N + 1];
		int[][][] dp = new int[N + 1][N + 1][4];
		for(int i = 1; i <= N; i++) {
			String line = br.readLine();
			for(int j = 1; j <= N; j++) {
				ground[i][j] = line.charAt(j - 1);
			}
		}
		//dp[i][j][0] = (i - 1, j) -> (i, j)로 갈때 MOLA문자가 이어지는지 1로 체크 
        //dp[i][j][1] = (i - 1, j) -> (i, j)로 갈떄 MOLA문자의 최대 개수
        //dp[i][j][2] = (i, j - 1) -> (i, j)로 갈때 MOLA문자가 이어지는지 1로 체크
        //dp[i][j][3] = (i, j - 1) -> (i, j)로 갈때 MOLA문자의 최대 개수
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				
				int A = dp[i - 1][j][1];	//(i - 2, j) -> (i - 1, j)일때 MOLA 개수의 최대 값
				int B = dp[i - 1][j][3];	//(i - 1, j - 1) -> (i - 1, j)일때 MOLA 개수의 최대 값
				int C = dp[i][j - 1][1];	//(i - 1, j - 1) -> (i, j - 1)일때 MOLA 개수의 최대 값
				int D = dp[i][j - 1][3];	//(i, j - 2) -> (i, j - 1)일때 MOLA 개수의 최대 값
				
//				if(ground[i][j] == 'M') {
//					dp[i][j][0] = dp[i][j][2] = 1;
//				}else 
				if(ground[i][j] == 'O') {	//현재 문자가 'O'일때
					if(ground[i - 1][j] == 'M') {	//위쪽에 'M'이 있다면
						dp[i][j][0] = 1;	//위에서 이어짐을 체크
					}
					if(ground[i][j - 1] == 'M') {	//왼쪽에 'M'이 있다면
						dp[i][j][2] = 1;	//왼쪽에서 이어짐을 체크
					}
				}else if(ground[i][j] == 'L') {	//현재 문자가 'L'일때
					if((dp[i - 1][j][0] == 1 && ground[i - 1][j] == 'O') || (dp[i - 1][j][2] == 1 && ground[i - 1][j] == 'O')) {	//위쪽 문자가 'O'이고 이어지는 문자열이라면
						dp[i][j][0] = 1;
					}
					if((dp[i][j - 1][0] == 1 && ground[i][j - 1] == 'O') || (dp[i][j - 1][2] == 1 && ground[i][j - 1] == 'O')) {	//왼쪽 문자가 'O'이고 이어지는 문자열이라면
						dp[i][j][2] = 1;
					}
				}else if(ground[i][j] == 'A') {	//현재 문자가 'A'일때
					if((dp[i - 1][j][0] == 1 && ground[i - 1][j] == 'L')) {	//위쪽(위)에서 이어져 오는 경우
						if(dp[i - 2][j][0] == 1 && ground[i - 2][j] == 'O') {	//'O'의 위치의 check값으로 'M'의 위치를 알아낸다.
							A = Math.max(A, Math.max(dp[i - 3][j][1] + 1, dp[i - 3][j][3] + 1));
						}
						if(dp[i - 2][j][2] == 1 && ground[i - 2][j] == 'O') {
							A = Math.max(A, Math.max(dp[i - 2][j - 1][1] + 1, dp[i - 2][j - 1][3] + 1));
						}
					}
					if((dp[i - 1][j][2] == 1 && ground[i - 1][j] == 'L')) {	//위쪽(왼)에서 이어져 오는 경우
						if(dp[i - 1][j - 1][0] == 1 && ground[i - 1][j - 1] == 'O') {
							B = Math.max(B, Math.max(dp[i - 2][j - 1][1] + 1, dp[i - 2][j - 1][3] + 1));
						}
						if(dp[i - 1][j - 1][2] == 1 && ground[i - 1][j - 1] == 'O') {
							B = Math.max(B, Math.max(dp[i - 1][j - 2][1] + 1, dp[i - 1][j - 2][3] + 1));
						}
					}
					if((dp[i][j - 1][0] == 1 && ground[i][j - 1] == 'L')) {	//왼쪽(위)에서 이어져 오는 경우
						if(dp[i - 1][j - 1][0] == 1 && ground[i - 1][j - 1] == 'O') {
							C = Math.max(C, Math.max(dp[i - 2][j - 1][1] + 1, dp[i - 2][j - 1][3] + 1));
						}
						if(dp[i - 1][j - 1][2] == 1 && ground[i - 1][j - 1] == 'O') {
							C = Math.max(C, Math.max(dp[i - 1][j - 2][1] + 1, dp[i - 1][j - 2][3] + 1));
						}
					}
					if((dp[i][j - 1][2] == 1 && ground[i][j - 1] == 'L')) {	//왼쪽(왼)에서 이어져 오는 경우
						if(dp[i][j - 2][0] == 1 && ground[i][j - 2] == 'O') {
							D = Math.max(D, Math.max(dp[i - 1][j - 2][1] + 1, dp[i - 1][j - 2][3] + 1));
						}
						if(dp[i][j - 2][2] == 1 && ground[i][j - 2] == 'O') {
							D = Math.max(D, Math.max(dp[i][j - 3][1] + 1, dp[i][j - 3][3] + 1));
						}
					}
				}
				dp[i][j][1] = Math.max(A, B);	//위쪽에서 현재 칸으로 올때 MOLA 개수의 최대 값
				dp[i][j][3] = Math.max(C, D);	//왼쪽에서 현재 칸으로 올때 MOLA 개수의 최대 값
			}
		}
//		System.out.println();
//		for(int i = 1; i <= N; i++) {
//			for(int j = 1; j <= N; j++) {
//				System.out.print(dp[i][j][1] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for(int i = 1; i <= N; i++) {
//			for(int j = 1; j <= N; j++) {
//				System.out.print(dp[i][j][3] + " ");
//			}
//			System.out.println();
//		}
		
		bw.write(Math.max(dp[N][N][1], dp[N][N][3]) + "\n");

		bw.flush();
		bw.close();
		br.close();
		
	}
}
