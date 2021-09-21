package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//로봇 시뮬레이션
public class BJ2174 {
	static class Robot {
		int x, y, direction;
		Robot(int x, int y, int direction) {
			this.x = x;
			this.y = y;
			this.direction = direction;
		}
	}
	//0 = E, 1 = S, 2 = W, 3 = N
	static int[] rotate = {0, 1, 2, 3};
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[B + 1][A + 1];	//맵상에 로봇들을 나타내는 배열,(배열을 위아래로 뒤집었다고 생각하자.)
		Robot[] robotList = new Robot[N + 1];	//로봇(위치, 방향을 포함하는)들 배열
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			map[x][y] = i;
			int dir;
			switch(st.nextToken().charAt(0)) {
			case 'E':
				dir = 0;
				break;
			case 'S':	//배열을 위아래로 뒤집었으므로 남쪽과 북쪽의 방향이 서로 바뀌어야한다.
				dir = 3;
				break;
			case 'W':
				dir = 2;
				break;
			default:
				dir = 1;
			}
			robotList[i] = new Robot(x, y, dir);
		}
		boolean crashed = false;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int operation = st.nextToken().charAt(0);
			int repeat = Integer.parseInt(st.nextToken());
			
			crashed = false;
			switch(operation) {
			case 'L':	//왼쪽으로 회전
				robotList[num].direction = rotate[(robotList[num].direction + repeat) % 4];
				break;
			case 'R':	//오른쪽으로 회전
				int nd = (robotList[num].direction - repeat) % 4;
				robotList[num].direction = rotate[nd < 0 ? 4 + nd : nd];
				break;
			case 'F':	//전진
				int nx = robotList[num].x;
				int ny = robotList[num].y;
				for(int j = 0; j < repeat; j++) {
					nx += d[robotList[num].direction][0];	//현재 방향으로 전진
					ny += d[robotList[num].direction][1];
					if(!((0 < nx && nx <= B) && (0 < ny && ny <= A))) {	//벽에 부딪혔거나
						bw.write("Robot " + num + " crashes into the wall\n");
						crashed = true;
						break;
					}else if(map[nx][ny] != 0) {	//다른 로봇에 부딪혔다면 crash 종료
						bw.write("Robot " + num + " crashes into robot " + map[nx][ny] + "\n");
						crashed = true;
						break;
					}
					//무사히 전진 가능하면 위치 갱신
					map[robotList[num].x][robotList[num].y] = 0;
					robotList[num].x = nx;
					robotList[num].y = ny;
					map[nx][ny] = num;
				}
				break;
			}
			if(crashed) {
				break;
			}
		}
		
		if(!crashed) {
			bw.write("OK\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
