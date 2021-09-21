package samsung;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//구슬 탈출2 (백준 13460)
public class EscapeBead2 {	
	static int N, M, Min = 987654321;
	static char[][] Map;
	static Queue<BeadPosition> queue = new LinkedList<>();
	static int[][] Direction = { {0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		Map = new char[N][];
		int rx = 0, ry = 0, bx = 0, by = 0;
		for(int i = 0; i < N; i++) {
			Map[i] = input.next().toCharArray();
			for(int j = 0; j < M; j++) {
				if(Map[i][j] == 'R') {
					rx = i;
					ry = j;
				}else if(Map[i][j] == 'B') {
					bx = i;
					by = j;
				}
			}
		}
		queue.add(new BeadPosition(rx, ry, bx, by, -1, 1)); //현재 구슬 위치 
		solve();	//bfs
		System.out.println(Min > 10 ? -1 : Min);
	}
	static void solve() {
		while(!queue.isEmpty()) {
			BeadPosition bp = queue.poll();
			if(bp.depth > 10) {	//10번 기울이면 끝
				break;
			}
			for(int i = 0; i < 4; i++) {
				if(bp.currentDirection != i) {
					int rxt, ryt, bxt, byt;	//빨강, 파랑 위치 고정
					int rx = bp.redX, ry = bp.redY, bx = bp.blueX, by = bp.blueY; //빨강, 파랑이 옮겨진 위치
					rxt = rx;
					ryt = ry;
					bxt = bx;
					byt = by;
					boolean rb = false, br = false, ro = false, bo = false;	//rb = 빨강이 파랑 쪽으로 갈 때, br = 파랑이 빨강 쪽으로 갈 때, ro = 빨강이 구멍에 들어갈 때, bo = 파랑이 구멍에 들어갈 때
					while(Map[rx + Direction[i][0]][ry + Direction[i][1]] != '#') {	//빨강을 해당 방향으로 끝까지 옮긴다
						if(rx + Direction[i][0] == bxt && ry + Direction[i][1] == byt) {	//파랑 쪽으로 가는가?
							rb = true;
						} else if(Map[rx + Direction[i][0]][ry + Direction[i][1]] == 'O') {	//구멍을 만나는가?
							ro = true;
							break;
						}
						rx += Direction[i][0];
						ry += Direction[i][1];
					}
					if(rb) {	//파랑을 만난다면 끝까지 간 후 반대 방향으로 한번 물러선다.
						rx -= Direction[i][0];
						ry -= Direction[i][1];
					}
					while(Map[bx + Direction[i][0]][by + Direction[i][1]] != '#') {	//파랑을 해당 방향으로 끝까지 옮긴다
						if(bx + Direction[i][0] == rxt && by + Direction[i][1] == ryt) {	//빨강 쪽으로 가는가?
							br = true;
						} else if(Map[bx + Direction[i][0]][by + Direction[i][1]] == 'O') {	//구멍을 만나는가?
							bo = true;
							break;
						}
						bx += Direction[i][0];
						by += Direction[i][1];
					}
					if(br) {	//빨강을 만난다면 끝까지 간 후 반대 방향으로 한번 물러선다.
						bx -= Direction[i][0];
						by -= Direction[i][1];
					}
					if(ro && !bo) {	//빨강만 구멍에 빠졌다면 바로 끝낸다 (bfs이므로)
						Min = bp.depth;
						return;
					}else if(bo) {	//파랑이 빠졌다면 큐에 추가하지 말고 다음으로 넘어간다.
					}else {
						if(rx == bp.redX && ry == bp.redY && bx == bp.blueX && by == bp.blueY) { //움직임이 없었다면 큐에 넣을 필요가 없다.
							
						}else {
							queue.add(new BeadPosition(rx, ry, bx, by, i, bp.depth + 1));
						}
					}
				}
			}
		}
	}
}
class BeadPosition {
	int redX, redY, blueX, blueY, currentDirection, depth;
	public BeadPosition(int redX, int redY, int blueX, int blueY, int currentDirection, int depth) {
		this.redX = redX;
		this.redY = redY;
		this.blueX = blueX;
		this.blueY = blueY;
		this.currentDirection = currentDirection;
		this.depth = depth;
	}
}
