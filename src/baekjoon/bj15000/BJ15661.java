package baekjoon.bj15000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//링크와 스타트
public class BJ15661 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] team = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				team[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = Integer.MAX_VALUE;
		
		int[] startTeam = new int[20];	//스타트 팀에 속하는 사람의 번호들.
		int[] linkTeam = new int[20];	//링크 팀에 속하는 사람의 번호들
		// 1 <= i < (1 << N) - 1까지 탐색해도 되지만 2팀으로 나누므로 0001과 1110은 동일하다. 그러므로 절반인 (1 << N) / 2까지만 탐색해도 충분하다.
		for(int i = 1; i < (1 << N) / 2; i++) {	//두 팀으로 나누는 모든 경우를 탐색.
			int s = 0, l = 0;
			for(int j = 0; j < N; j++) {
				if((i & (1 << j)) > 0) {
					startTeam[s++] = j;
				}else {
					linkTeam[l++] = j;
				}
			}
			//각 팀의 시너지 계산.
			int startPower = 0, linkPower = 0;
			for(int j = 0; j < s - 1; j++) {
				for(int k = j + 1; k < s; k++) {
					startPower += (team[startTeam[j]][startTeam[k]] + team[startTeam[k]][startTeam[j]]);
				}
			}
			for(int j = 0; j < l - 1; j++) {
				for(int k = j + 1; k < l; k++) {
					linkPower += (team[linkTeam[j]][linkTeam[k]] + team[linkTeam[k]][linkTeam[j]]);
				}
			}
			
			result = Math.min(result, Math.abs(startPower - linkPower));
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
