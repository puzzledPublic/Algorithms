package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//낚시왕
public class BJ17143 {
	static class Shark {
		int speed, direction, size;
		Shark(int speed, int direction, int size) {
			this.speed = speed;
			this.direction = direction;
			this.size = size;
		}
	}
	static int[][] d = {{0, 0}, {-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Shark[][] waterPool = new Shark[R + 1][C + 1];
		Shark[][] copyPool = new Shark[R + 1][C + 1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken()), z = Integer.parseInt(st.nextToken());
			waterPool[r][c] = new Shark(s, d, z);
		}
		
		int human = 0;
		int totalCaptureSize = 0;
		while(human < C) {
			//인간 움직임
			human++;
			//상어잡기
			int deep = 0;
			while(deep <= R) {
				if(waterPool[deep][human] != null) {
//					System.out.println("["+ deep + "," + human + "] 위치 " + waterPool[deep][human].direction +"방향 상어 잡힘!");
					totalCaptureSize += waterPool[deep][human].size;
					waterPool[deep][human] = null;
					break;
				}
				deep++;
			}
			if(human == C) {
				break;
			}
			//상어 움직임 (d = 1(위), 2(아래), 3(오른쪽), 4(왼쪽)
			for(int i = 1; i <= R; i++) {
				for(int j = 1; j <= C; j++) {
					if(waterPool[i][j] != null) {
						int nx = i, ny = j, move, dir = waterPool[i][j].direction;
//						System.out.print("["+ nx + "," + ny + "] 위치 " + dir +"방향 상어");
						if(waterPool[i][j].direction == 1 || waterPool[i][j].direction == 2) {	//방향이 위 또는 아래인 경우
							//(R - 1) * 2만큼 움직인다면 자기 자리로 온다. 그러므로 움직여야하는 횟수에서 (R - 1) * 2로 나눈 나머지만 시뮬레이션 해주면 된다.
							move = waterPool[i][j].speed == 0 ? 0 : (waterPool[i][j].speed % ((R - 1) * 2) == 0 ? (R - 1) * 2 : waterPool[i][j].speed % ((R - 1) * 2));
							while(move > 0) {
								if((1 <= nx + d[dir][0] && nx + d[dir][0] <= R) && (1 <= ny + d[dir][1] && ny + d[dir][1] <= C)) {
									nx += d[dir][0];
									ny += d[dir][1];
									move--;
								}else {
									dir = (dir % 2) + 1;
								}
							}
						}else {		//방향이 왼쪽 또는 오른쪽인 경우
							move = waterPool[i][j].speed == 0 ? 0 : (waterPool[i][j].speed % ((C - 1) * 2) == 0 ? (C - 1) * 2: waterPool[i][j].speed % ((C - 1) * 2));
							while(move > 0) {
								if((1 <= nx + d[dir][0] && nx + d[dir][0] <= R) && (1 <= ny + d[dir][1] && ny + d[dir][1] <= C)) {
									nx += d[dir][0];
									ny += d[dir][1];
									move--;
								}else {
									dir = (dir % 2) + 3;
								}
							}
						}
//						System.out.println(" -> ["+ nx + "," + ny + "] 위치 " + dir +"방향 상어");
						if(copyPool[nx][ny] == null || (copyPool[nx][ny] != null && copyPool[nx][ny].size < waterPool[i][j].size)) {	//상어가 움직인곳에 이미 상어가 존재한다면 크기를 비교하여 상어를 갱신한다.
							waterPool[i][j].direction = dir;
							copyPool[nx][ny] = waterPool[i][j];
						}
						waterPool[i][j] = null;
					}
				}
			}
//			System.out.println();
			for(int i = 1; i <= R; i++) {
				for(int j = 1; j <= C; j++) {
					if(copyPool[i][j] != null) {
						waterPool[i][j] = copyPool[i][j];
						copyPool[i][j] = null;
					}
				}
			}
		}
		
		bw.write(totalCaptureSize + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
