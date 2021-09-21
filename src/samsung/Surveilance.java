package samsung;

import java.util.Scanner;

//감시 (백준 15683)
public class Surveilance {
	static int N, M, C, result = 987654321;
	static int[][] position = new int[8][2];	//감시 카메라 위치
	static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};	//우, 하, 좌, 상
	static int[][] map;	//전체 맵
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = input.nextInt();
				if(map[i][j] > 0 && map[i][j] < 6) { //감시 카메라 위치 기억
					position[C][0] = i;
					position[C][1] = j;
					C++;
				}
			}
		}
		solve(0);
		System.out.println(result);
	}
	
	static void solve(int index) {
		if(index == C) {	//모든 감시카메라 위치에 대해 감시구역을 확인했으면
			int temp = 0;
			for(int i = 0; i < N; i++) {	//사각지역 확인
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 0) {
						temp++;
					}
				}
			}
			if(result > temp) {	//이전에 구한 사각지역보다 작으면
				result = temp; // 교체
			}
			return;
		}
		
		for(int i = 0; i < 4; i++) {	//상, 하, 좌, 우 위치에 대해 탐색
			if(map[position[index][0]][position[index][1]] == 2 && (i == 2 || i == 3)) {	//90도 방향 감시카메라는 (좌,우) = (우,좌)가 같으므로 같은 경우는 건너 뛴다.
				continue;
			}
			checkCameraZone(map[position[index][0]][position[index][1]], index, i, -1); //감시구역 체크
			solve(index + 1);	//다음 감시카메라 위치로
			checkCameraZone(map[position[index][0]][position[index][1]], index, i, 1);	//감시구역 체크 해제
		}
	}
	
	static void checkCameraZone(int k, int index, int d, int f) {
		switch(k) {
		case 1:	//한 방향만 감시
			checking(index, d, f);
		break;
		case 2:	//(좌,우), (상,하) 감시
			for(int i = d; i < d + 3; i += 2) {
				checking(index, i, f);
			}
		break;
		case 3: //(우,하),(하,좌),(좌,상),(상,우) 감시
			for(int i = d; i < d + 2; i++) {
				checking(index, i % 4, f);
			}
		break;
		case 4: //(우,하,좌),(하,좌,상),(좌,상,우),(상,우,하) 감시
			for(int i = d; i < d + 3; i++) {
				checking(index, i % 4, f);
			}
		break;
		case 5: //상,하,좌,우 모두 감시
			for(int i = 0; i < 4; i++) {
				checking(index, i, f);
			}
		}
	}
	static void checking(int i, int d, int f) { //감시카메라 방향에 대해 감시 지역 체크 함수
		int x = position[i][0] + direction[d][0];
		int y = position[i][1] + direction[d][1];
		while(x >= 0 && x < N && y >= 0 && y < M && map[x][y] != 6) {
			if(map[x][y] <= 0) {
				map[x][y] += f;
			}
			x += direction[d][0];
			y += direction[d][1];
		}
	}
}
