package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//스테판 쿼리
public class BJ14654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] team = new int[2][N];
		for(int k = 0; k < 2; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				team[k][i] = Integer.parseInt(st.nextToken());
			}
		}
		//0번팀, 1번팀.
		int prevWin = -1;	//이전에 이긴 팀 번호
		int winCount = 0;	//연승 횟수
		int maxCount = -1;	//최대 연승 횟수
		
		for(int i = 0; i < N; i++) {
			int winner = whoWin(team[0][i], team[1][i], prevWin);	//각 라운드의 이긴팀을 구한다.
			
			if(winner != prevWin) {	//이전 라운드와 현재 라운드의 이긴 팀이 다르면 연승 초기화
				winCount = 0;
			}
			winCount++;	//연승 횟수 증가
			maxCount = Math.max(maxCount, winCount);	//최대 연승 횟수 갱신
			
			prevWin = winner;	//이전 라운드 이긴 팀 갱신
		}
		
		bw.write(maxCount + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int whoWin(int teamA, int teamB, int prevWin) {
		if(teamA == teamB) {	//서로 비긴 경우 처음 나온 사람이 이긴다.
			return 1 - prevWin;
		}
		if(teamA == 1 && teamB == 3 || teamA == 2 && teamB == 1 || teamA == 3 && teamB == 2) {	//0번 팀이 이기는 경우
			return 0;
		}
		return 1;	//그 외의 경우 1번 팀이 이긴다.
	}
}
