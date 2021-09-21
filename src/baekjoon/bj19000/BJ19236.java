package baekjoon.bj19000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//청소년 상어
public class BJ19236 {
	static class Fish {
		int x, y, d;
		Fish(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	static int maxVal = Integer.MIN_VALUE;
	static int[][] d = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[][] pool = new int[4][4];
		Fish[] fishes = new Fish[18];
		
		for(int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				pool[i][j] = num;
				fishes[num] = new Fish(i, j, dir);
			}
		}
		
		int sum = pool[0][0];	//상어에게 처음 먹히는 물고기 번호
		Fish first = fishes[pool[0][0]];
		fishes[17] = new Fish(0, 0, first.d);	//상어는 해당 물고기 방향을 가진다.
		first.d = -1;
		pool[0][0] = 17;	//상어 위치 설정.
		
		solve(pool, fishes, sum);
		
		bw.write(maxVal + "\n");
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	static void solve(int[][] pool, Fish[] fishes, int sum) {
		//물고기 이동
		for(int i = 1; i <= 16; i++) {	//번호가 낮은 순으로
			Fish fish = fishes[i];
			if(fish.d == -1) continue;	//물고기 방향이 -1인 경우 잡아먹혔다는 뜻
			int dir = fish.d;
			int nx = fish.x + d[dir][0], ny = fish.y + d[dir][1];
			while(!((0 <= nx && nx < 4) && (0 <= ny && ny < 4) && pool[nx][ny] != 17)) {	//물고기가 갈 수 있는 곳 찾기.
				dir = (dir + 1) % 8;
				nx = fish.x + d[dir][0];
				ny = fish.y + d[dir][1];
			}
			
			if(pool[nx][ny] != 0) {	//갈 수 있는 곳에 물고기가 있다면 물고기 위치 바꾸기
				fishes[pool[nx][ny]].x = fish.x;
				fishes[pool[nx][ny]].y = fish.y;
			}
			
			pool[fish.x][fish.y] = pool[nx][ny];
			pool[nx][ny] = i;
			
			fish.x = nx;
			fish.y = ny;
			fish.d = dir;
		}
		
		//상어 이동
		Fish shark = fishes[17];
		int nx = shark.x + d[shark.d][0], ny = shark.y + d[shark.d][1];
		while((0 <= nx && nx < 4) && (0 <= ny && ny < 4)) {	//상어가 갈 수 있는 곳 찾기
			if(pool[nx][ny] == 0) {	//갈 수 있는 곳에 아무것도 없으면 종료. 지금까지 먹은 물고기 번호 최대 합 비교 갱신
				if(maxVal < sum) {
					maxVal = sum;
				}
			}else {
				//현 상태에서 상어가 움직이는 여러가지 방법이 있으므로 상태를 변경하지 못하도록 현재 상태 복사.
				Fish[] copyFishes = new Fish[18];
				int[][] copyPool = new int[4][4];
				for(int i = 1; i < fishes.length; i++) {
					copyFishes[i] = new Fish(fishes[i].x, fishes[i].y, fishes[i].d);
				}
				for(int i = 0; i < 4; i++) {
					for(int j = 0; j < 4; j++) {
						copyPool[i][j] = pool[i][j];
					}
				}
				
				//상어를 다음 위치로 이동시킨다.
				Fish copyShark = copyFishes[17];	//상어
				int fishNum = copyPool[nx][ny];	//잡아먹힐 물고기 번호
				copyShark.d = copyFishes[fishNum].d;	//상어의 방향은 잡아먹힐 물고기 방향
				copyFishes[fishNum].d = -1;	//잡아 먹힌 물고기의 방향은 -1로 체크
				copyPool[copyShark.x][copyShark.y] = 0;	//상어가 있던 자리는 0으로
				copyShark.x = nx;
				copyShark.y = ny;
				copyPool[nx][ny] = 17;	//상어를 나타냄.
				solve(copyPool, copyFishes, sum + fishNum);
			}
			nx += d[shark.d][0];
			ny += d[shark.d][1];
		}
		if(maxVal < sum) {	//다음 갈 곳이 범위를 넘어서면 종료.
			maxVal = sum;
		}
	}
}
