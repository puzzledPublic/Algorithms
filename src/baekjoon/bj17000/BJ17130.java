package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//토끼가 정보섬에 올라온 이유
public class BJ17130 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] garden = new char[N][M];
		int[][] dp = new int[N][M];
		List<int[]> rabbitHole = new ArrayList<>();
		
		int rabbitX = 0, rabbitY = 0;
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				garden[i][j] = line.charAt(j);
				if(garden[i][j] == 'R') {	//토끼의 위치 저장
					rabbitX = i;
					rabbitY = j;
				}else if(garden[i][j] == 'O') {	//도망칠 구멍의 위치들 저장
					rabbitHole.add(new int[] {i, j});
					dp[i][j] = -1;
				}else if(garden[i][j] == '#') {	//벽과 도망칠 구멍을 -1로 채운다.
					dp[i][j] = -1;
				}
			}
		}
		
		//토끼 위치를 기준으로 토끼가 갈수 없는 위치를 -1로 채운다.
		int k = 1;
		for(int i = rabbitX - 1; i >= 0 ; i--) {
			int end = Math.min(M, rabbitY + k);
			for(int j = rabbitY; j < end; j++) {
				dp[i][j] = -1;
			}
			k++;
		}
		
		k = 1;
		for(int i = rabbitX + 1; i < N; i++) {
			int end = Math.min(M, rabbitY + k);
			for(int j = rabbitY; j < end; j++) {
				dp[i][j] = -1;
			}
			k++;
		}
		
		k = 1;
		for(int j = rabbitY + 1; j < M; j++) {	//토끼가 있는 다음 열부터 시작
			for(int i = 0; i < N; i++) {
				if(garden[i][j] != '#') {	//벽이 아니고
					boolean flag = false;	//토끼가 현재 위치로 올 수 있는지 여부
					if(i - 1 >= 0 && j - 1 >= 0 && dp[i - 1][j - 1] != -1) {	//왼쪽 위에서 오는 경우
						flag = true;
						dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1]);
					}
					if(j - 1 >= 0 && dp[i][j - 1] != -1) {	//왼쪽에서 오는 경우
						flag = true;
						dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
					}
					if(i + 1 < N && j - 1 >= 0 && dp[i + 1][j - 1] != -1) {	//왼쪽 아래서 오는 경우
						flag = true;
						dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1]);
					}
					if(flag && garden[i][j] == 'C') {	//3군데 중 한곳에서라도 올 수 있고 현재 위치에 당근이 있으면 하나 추가.
						dp[i][j]++;
					}else if(!flag){	//3군데 중 한곳도 현재위치로 올 수 없는 경우라면 -1로 채운다.
						dp[i][j] = -1;
					}
				}
			}
			k++;
		}
		
		int result = -1;
		for(int[] coord : rabbitHole) {	//도망칠 구멍위치들을 탐색하며 해당위치의 당근 갯수를 센다. -1이라면 그곳으로는 갈 수가 없음을 나타낸다.
			if(result < dp[coord[0]][coord[1]]) {
				result = dp[coord[0]][coord[1]]; 
			}
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
