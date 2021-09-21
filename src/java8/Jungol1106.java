package java8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//장기, BFS
public class Jungol1106 {
	
	static boolean janggi[][];	//장기판
	static int relativePosition[][] = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};	//탐색할 상대 위치
	static Queue<Pos> queue = new LinkedList<>();	//BFS를 위한 큐
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N, M;	//NxM크기 장기판
		int startX, startY, endX, endY;	//탐색할 시작점, 목표점
		
		//입력
		N = input.nextInt();	
		M = input.nextInt();
		startX = input.nextInt();
		startY = input.nextInt();
		endX = input.nextInt();
		endY = input.nextInt();
		
		janggi = new boolean[N+1][M+1]; //장기판 생성
		
		//계산
		janggi[startX][startY] = true;	//시작점 방문
		queue.add(new Pos(startX, startY, 0));	//큐에 시작점 저장
		
		while(!queue.isEmpty()){	//큐가 빌때까지
			
			Pos pos = queue.remove();	//큐에서 아이템 뽑기
			if(pos.x == endX && pos.y == endY){		//뽑은 아이템이 목표점이라면 결과 출력 
				System.out.println(pos.z);	//방문 값 출력
				break;
			}
			int x, y;
			
			for(int i = 0 ; i < relativePosition.length; i++){	//기준위치로 부터 탐색할 위치들을 돌며
				x = pos.x + relativePosition[i][0];
				y = pos.y + relativePosition[i][1];
				if((x > 0 && x < N) && (y > 0 && y < M)){	//장기판을 넘는 좌표값인지 조사
					 if(janggi[x][y] == false){		//아직 방문되지 않았다면
						
						janggi[x][y] = true;	//방문 표시
						queue.add(new Pos(x, y, pos.z + 1));	//큐에 저장 (방문 값 1 증가)
					}
				}
			}
			
		}
		
	}
}
//큐에 저장하기 위한 좌표 클래스
class Pos{
	int x, y, z;	// (x, y) = 좌표 값, z = 방문 값
	
	public Pos(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
