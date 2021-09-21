package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//새로운 게임
public class BJ17780 {
	static int[][] d = { { 0, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] board = new int[N + 2][N + 2];
		List<Integer>[][] list = new List[N + 2][N + 2];	//해당 칸의 말 리스트
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N + 2; i++) {
			board[i][0] = board[0][i] = board[i][N + 1] = board[N + 1][i] = 2;	//외곽은 파란색 칸으로 둔다.
		}

		int[][] piece = new int[K + 1][4]; 
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			piece[i][0] = Integer.parseInt(st.nextToken());
			piece[i][1] = Integer.parseInt(st.nextToken());
			piece[i][2] = Integer.parseInt(st.nextToken());
			
			list[piece[i][0]][piece[i][1]] = new ArrayList<>();	//초기 칸 초기화
			list[piece[i][0]][piece[i][1]].add(i);
		}
		
		boolean stop = false;
		int turn = 0;
		while (turn < 1000) {	//1000번 턴을 할 동안
			for(int i = 1; i <= K; i++) {	//각 말들을 돈다.
				int x = piece[i][0], y = piece[i][1];
				int bottom = list[x][y].get(0);
				if(bottom == i) {	//해당 말이 맨 아래인 경우
					int dir = piece[bottom][2];
					int nx = x + d[dir][0], ny = y + d[dir][1];
					switch(board[nx][ny]) {	//다음 진행 칸이
						case 0:	//흰색인 경우
							if(list[nx][ny] == null) {
								list[nx][ny] = new ArrayList<>();
							}
							for(int item = 0; item < list[x][y].size(); item++) {	//말을 그대로 다음 진행칸으로 옮긴다
								int p = list[x][y].get(item);
								list[nx][ny].add(p);
								piece[p][0] = nx;	//해당말의 좌표도 바꿔줘야한다.
								piece[p][1] = ny;
							}
							list[x][y] = null;	//현재 칸은 null
							break;
						case 1:	//빨강인 경우
							if(list[nx][ny] == null) {
								list[nx][ny] = new ArrayList<>();
							}
							for(int item = list[x][y].size() - 1; item >= 0; item--) {	//말을 거꾸로하여 다음 진행칸으로 옮긴다.
								int p = list[x][y].get(item);
								list[nx][ny].add(p);
								piece[p][0] = nx;
								piece[p][1] = ny;
							}
							list[x][y] = null;
							break;
						case 2:	//파랑인 경우
							if(dir == 1) dir = 2;	//방향 반전
							else if(dir == 2) dir = 1;
							else if(dir == 3) dir = 4;
							else dir = 3;
							nx = x + d[dir][0];	//새로운 진행 칸
							ny = y + d[dir][1];
							piece[i][2] = dir;	//bottom 말의 방향이 바뀐다.
							switch(board[nx][ny]) {	//새로운 진행 칸에 대해 다시 확인
								case 0:
									if(list[nx][ny] == null) {
										list[nx][ny] = new ArrayList<>();
									}
									for(int item = 0; item < list[x][y].size(); item++) {
										int p = list[x][y].get(item);
										list[nx][ny].add(p);
										piece[p][0] = nx;
										piece[p][1] = ny;
									}
									list[x][y] = null;
									break;
								case 1:
									if(list[nx][ny] == null) {
										list[nx][ny] = new ArrayList<>();
									}
									for(int item = list[x][y].size() - 1; item >= 0; item--) {
										int p = list[x][y].get(item);
										list[nx][ny].add(p);
										piece[p][0] = nx;
										piece[p][1] = ny;
									}
									list[x][y] = null;
									break;
							}
						break;
					}
				}
			}
			turn++;
			
			//모든 칸을 돌며 말이 4개 이상인 칸이 있다면 바로 종료
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(list[i][j] != null && list[i][j].size() >= 4) {
						stop = true;
						break;
					}
				}
			}
			if(stop) break;
		}
		
		bw.write((stop ? turn : -1)+ "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
