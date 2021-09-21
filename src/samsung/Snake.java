package samsung;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//뱀 (백준 3190)
public class Snake {
	static int N, K, L;	//맵 크기, 사과 갯수, 방향 회전 수
	static int[][] Map, SD;	//맵, [몇 초후][회전방향]
	static int[][] Direction = { {0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //방향 (동, 남, 서, 북)
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);		
		N = input.nextInt();
		Map = new int[N + 2][N + 2];	//벽을 위해 크기 + 2
		for(int i = 0; i < N + 2; i++) {	//벽을 생성
			Map[i][0] = 3;
			Map[0][i] = 3;
			Map[i][N + 1] = 3;
			Map[N + 1][i] = 3;
		}
		
		K = input.nextInt();
		for(int i = 0; i < K; i++) {	//사과 위치 표시
			int x = input.nextInt();
			int y = input.nextInt();
			Map[x][y] = 2;
		}
		L = input.nextInt();
		SD = new int[L][2];
		for(int i = 0; i < L; i++) {	//시간, 회전 방향
			SD[i][0] = input.nextInt();
			SD[i][1] = input.next().charAt(0);
		}
		solve();
	}
	
	static void solve() {
		int snakeX = 1, snakeY = 1, count = 0, d = 0, seconds = 0, secondsPointer = 0;	//뱀 머리 위치, 먹은 사과 수, 현재 방향, 현재 시간, 다음 회전 시간 포인터
		Queue<Pos> queue = new LinkedList<>();
		queue.add(new Pos(1, 1));
		while(Map[snakeX][snakeY] <= 2 && count <= K) {	// map[i][j] == (3, 벽), (4, 몸), (0, 땅), (2, 사과)
			Map[snakeX][snakeY] = 4;	//뱀 표시
			if(secondsPointer < SD.length && SD[secondsPointer][0] == seconds) {	//회전 시간이 됐으면 회전
				if(SD[secondsPointer][1] == 'D') {	//오른쪽
					d = (d + 1) % 4;
				} else {	//왼쪽
					d = (d + 3) % 4;
				}
				secondsPointer++;
			}
			snakeX += Direction[d][0];	//다음 뱀 이동 위치
			snakeY += Direction[d][1];
			if(Map[snakeX][snakeY] < 2) {	//사과를 못먹으면
				Pos p = queue.poll();	
				Map[p.x][p.y] = 0; 	//꼬리 부분 제거
			}
			queue.add(new Pos(snakeX, snakeY));	//뱀 머리 위치 저장
			seconds++;	// +1초
		}
		System.out.println(seconds);
	}
}
class Pos {
	int x;
	int y;
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}