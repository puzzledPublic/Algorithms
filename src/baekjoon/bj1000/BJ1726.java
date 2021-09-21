package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//로봇
public class BJ1726 {
	static class Robot {	//로봇 상태
		int x, y, direction, step;
		Robot(int x, int y, int direction, int step) {
			this.x = x;	//x좌표
			this.y = y;	//y좌표
			this.direction = direction;	//방향
			this.step = step;	//도달시간
		}
	}
	static int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};	//0-동, 1-서, 2-남, 3-북
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[M][N];	//맵
		boolean[][][] check = new boolean[M][N][4];	//체크배열
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");	//시작 상태
		int startX = Integer.parseInt(st.nextToken()) - 1;	//1부터 시작하는 좌표들의 입력이므로 0으로 시작하도록 -1을 해준다.
		int startY = Integer.parseInt(st.nextToken()) - 1;
		int startD = Integer.parseInt(st.nextToken()) - 1;
		
		st = new StringTokenizer(br.readLine(), " ");	//도착 상태
		int endX = Integer.parseInt(st.nextToken()) - 1;
		int endY = Integer.parseInt(st.nextToken()) - 1;
		int endD = Integer.parseInt(st.nextToken()) - 1;
		
		Queue<Robot> queue = new LinkedList<>();
		queue.add(new Robot(startX, startY, startD, 0));
		check[startX][startY][startD] = true;	//시작 상태 체크
		while(!queue.isEmpty()) {
			Robot robot = queue.poll();
			if(robot.x == endX && robot.y == endY && robot.direction == endD) {	//도착 상태와 같다면 종료
				bw.write(robot.step + "\n");
				break;
			}
			
			for(int i = 1; i <= 3; i++) {	//1, 2, 3칸을 건너뛴다.
				int nx = robot.x + d[robot.direction][0] * i, ny = robot.y + d[robot.direction][1] * i;
				if((0 <= nx && nx < M) && (0 <= ny && ny < N) && !check[nx][ny][robot.direction]) {
					if(map[nx][ny] != '1') {	//갈수가 있으면 점프
						check[nx][ny][robot.direction] = true;
						queue.add(new Robot(nx, ny, robot.direction, robot.step + 1));
					}else {	//1->2->3순서로 건너뜀을 검사하므로 앞에서 갈 수가 없으면 뒤에 위치도 갈 수 없으니 바로 종료
						break;
					}
				}
			}
			
			int s = 0, e = 1;
			if(robot.direction == 0 || robot.direction == 1) {	//(동(0) or 서(1)) 방향이면 (남(2) or 북(3)) 탐색, (남 or 북) 방향이면 (동 or 서) 탐색 
				s += 2;
				e += 2;
			}
			for(int i = s; i <= e; i++) {
				if(!check[robot.x][robot.y][i]){	//방문한적 없으면 탐색
					check[robot.x][robot.y][i] = true;
					queue.add(new Robot(robot.x, robot.y, i, robot.step + 1));
				}
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
