package baekjoon.bj18000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//Gaaaaaaaaaarden
public class BJ18809 {
	static class State {
		int x, y, time;
		public State(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	static int[][][] ground;
	static int N, M, G, R;
	static List<State> seedPositions = new ArrayList<>();
	static char[][] liquidOrder;
	static char[] liquidTemp;
	static int liquidCounter;
	static int result;
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		ground = new int[N][M][2];	//[i][j][0] = 호수 => 0, 배양액 놓을 수 있는 곳 => 2, 없는 곳 => 1, [i][j][1] = bfs를 위한 배양액이 옮겨가는 time값
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				ground[i][j][0] = Integer.parseInt(st.nextToken());
				if(ground[i][j][0] == 2) {	//배양액을 넣을 수 있는 좌표 저장.
					seedPositions.add(new State(i, j, -1));
				}
			}
		}
		
		liquidOrder = new char[facto(G + R) / (facto(G) * facto(R))][seedPositions.size()];
		liquidTemp = new char[seedPositions.size()];
		makeLiquidOrder(0, G, R);	//가능한 배양액 순서를 만든다.
		
		for(int f = 1; f < (1 << seedPositions.size()); f++) {
			int peekCount = 0;
			for(int g = 0; g < seedPositions.size(); g++) {	//배양액을 넣을 수 있는 좌표 개수 중 (G + R)개를 고른다.
				if((f & (1 << g)) > 0) {
					peekCount++;
				}
			}
			
			if(peekCount == G + R) {	//(G + R)개를 고른 경우
				for(int k = 0; k < liquidOrder.length; k++) {	//가능한 모든 배양액 순서에따라
					for(int i = 0; i < N; i++) {	//bfs를 위한 초기화
						for(int j = 0; j < M; j++) {
							if(ground[i][j][0] != 0) {
								ground[i][j][0] = 1;
							}
							ground[i][j][1] = 0;
						}
					}
					
					Queue<State> queue = new LinkedList<>();
					int index = 0;
					for(int g = 0; g < seedPositions.size(); g++) {	//배양액 넣을 수 있는 곳에 순서대로 배양액을 넣는다.
						if((f & (1 << g)) > 0) {
							ground[seedPositions.get(g).x][seedPositions.get(g).y][0] = liquidOrder[k][index++];
							queue.add(new State(seedPositions.get(g).x, seedPositions.get(g).y, 0));	//bfs를 위한 시작값도 넣는다.
						}
					}
					
					int flower = 0;
					while(!queue.isEmpty()) {	//bfs 시작.
						State s = queue.poll();
						
						if(ground[s.x][s.y][0] == -1) {	//이미 꽃이 핀 곳이면 넘어간다.
							continue;
						}
						
						for(int i = 0; i < 4; i++) {	//상하좌우를 탐색.
							int nx = s.x + d[i][0], ny = s.y + d[i][1];
							if((0 <= nx && nx < N) && (0 <= ny && ny < M)) {
								//1.다음 좌표에 배양액이 있다.
								//2.현재 좌표와 다른 배양액이다.
								//3.현재 시간 + 1이 다음 좌표 배양액의 시간과 같다.
								//위의 경우를 만족하면 서로 다른 배양액이 같이 도달하는 곳이므로 꽃이 핀다.
								if(ground[nx][ny][0] > 1 && ground[s.x][s.y][0] != ground[nx][ny][0] && ground[nx][ny][1] > s.time && ground[nx][ny][1] == s.time + 1) {
									ground[nx][ny][0] = -1;
									flower++;
								}else if(ground[nx][ny][0] == 1) {	//1인 경우 배양액이 없고 옮겨갈 수 있는 곳이다.
									ground[nx][ny][0] = ground[s.x][s.y][0];	//체크
									ground[nx][ny][1] = s.time + 1;
									queue.add(new State(nx, ny, s.time + 1));
								}
							}
						}
					}
					
					if(result < flower) {	//피는 꽃의 개수 갱신
						result = flower;
					}
				}
			}
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int facto(int n) {
		int result = 1;
		for(int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}
	
	static void makeLiquidOrder(int n, int g, int r) {
		if(n == seedPositions.size() || (g == 0 && r == 0)) {
			for(int i = 0; i < liquidTemp.length; i++) {
				liquidOrder[liquidCounter][i] = liquidTemp[i];
			}
			liquidCounter++;
			return;
		}
		if(g > 0) {
			liquidTemp[n] = 'G';
			makeLiquidOrder(n + 1, g - 1, r);
		}
		if(r > 0) {
			liquidTemp[n] = 'R';
			makeLiquidOrder(n + 1, g, r - 1);
		}
	}
}
