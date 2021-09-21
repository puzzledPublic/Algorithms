package samsung;

import java.util.Scanner;

//로봇청소기 (백준 14503)
public class RobotCleaner {
	static int N, M, D;
	static int robotX, robotY;
	static int[][] Map;
	static int[][] Direction = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};	//서, 북, 동, 남
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		robotX = input.nextInt();
		robotY = input.nextInt();
		D = input.nextInt();
		Map = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				Map[i][j] = input.nextInt();
			}
		}
		solve();
	}
	
	static void solve() {
		int x, y, count = 0;
		int path = 2, slide = 2;	//path는 청소기가 움직이는 횟수, slide는 중복 청소 구간으로 이동하는 횟수
		while(true) {
			Map[robotX][robotY] = path++;	//1.현재 위치 청소
			count = 0;	//네 방향 카운터
			for(int i = 0; i < 4; i++) {
				x = robotX + Direction[D][0];	//2.현재 바라보는 방향 기준 왼쪽 위치 검사
				y = robotY + Direction[D][1];
				D = (D + 3) % 4;	//2.2왼쪽 방향으로 변환
				if(Map[x][y] == 0) {	//2.1왼쪽 위치 청소 가능하면 이동
					robotX = x;
					robotY = y;
					break;
				}
				count++;
			}
			if(count == 4) {	//2.3네 방향 모두 청소 불가능한 경우
				x = robotX + Direction[(D + 3) % 4][0];	//현재 바라보는 방향 기준 뒤쪽 위치 검사
				y = robotY + Direction[(D + 3) % 4][1];
				if(Map[x][y] == 1) {	//2.4뒤가 벽이라면 종료
					break;
				}else {	//2.3후진
					robotX = x;
					robotY = y;
					slide++;
				}
			}
		}
		System.out.println(path - slide);
	}
}
