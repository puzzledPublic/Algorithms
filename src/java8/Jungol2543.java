package java8;

import java.util.Scanner;

//타일 채우기, (분할 정복)
// 바닥을 중앙 기준 4개로 나누고 타일 깔기가 불가능한 위치를 이용해 맞는 타일 중앙에 배치하는 아이디어가 필요.
//이 코드는 느리므로 다른 코드 참조가 필요
public class Jungol2543 {
	
	static int floor[][];
	static int tile[][][] = {	//사각형에서 왼쪽 위 기준(0,0)으로 상대위치
								{{0, 1}, {1, 0}, {1, 1}},	//1번타일 
								{{0, 0}, {1, 0}, {1, 1}},	//2번
								{{0, 0}, {0, 1}, {1, 1}},	//3번
								{{0, 0}, {0, 1}, {1, 0}}	//4번
							};
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//입력
		int N, x, y;
		N = input.nextInt();
		x = input.nextInt();
		y = input.nextInt();
		
		floor = new int[N][N];
		
		
		for(int i = 0 ; i < N ; i++){	//바닥을 -1로 초기화
			for(int j = 0 ; j < N ; j++){
				floor[i][j] = -1;
			}
		}
		
		floor[x][y] = 0;	//배수구 위치 0으로 초기화
		
		//분할정복 시작
		fillingTile(0, 0, N);
		
		//출력
		for(int i = 0 ; i < N ; i++){
			for(int j = 0 ; j < N ; j++){
				System.out.print(floor[i][j] +" ");
			}
			System.out.println();
		}
	}
	
	static void fillingTile(int sx, int sy, int size){
		int tileNum, nextSize, x = 0, y = 0;
		nextSize = size/2;	// 바닥을 1/4로 나눈 사각형의 한변의 길이
		
		for(int i = 0 ; i < size; i++){		//사각형 내에서 이미 차지하는 영역의 위치를 알아낸다
			for(int j = 0; j < size; j++){
				if(floor[sx + i][sy + j] >= 0){
					x = sx + i;
					y = sy + j;
					break;
				}
			}
		}
		
		if(x < sx + nextSize && y < sy + nextSize){			//이미 차지하는 영역의 위치를 이용해 사각형 중앙에 넣을 타일번호를 알아낸다.
			tileNum = 0;
		}
		else if(x < sx + nextSize && y >= sy + nextSize){
			tileNum = 1;
		}
		else if(x >= sx + nextSize && y < sy + nextSize){
			tileNum = 2;
		}
		else{
			tileNum = 3;
		}
		//System.out.println("x: "+ x + " y: "+ y + " tileNum: "+ tileNum);
		
		int dx, dy;
		for(int i = 0; i < tile[0].length; i++){			//사각형 중앙에 타일 배치
			dx = sx + nextSize - 1 + tile[tileNum][i][0];
			dy = sy + nextSize - 1 + tile[tileNum][i][1];
			floor[dx][dy] = tileNum + 1;
			
		}
		if(size == 2){		//기저사례
			return;
		}
		// 1/4로 나눈 만큼 각 사각형으로 분할정복(재귀)
		fillingTile(sx, sy, nextSize);
		
		fillingTile(sx, sy + nextSize, nextSize);
		
		fillingTile(sx + nextSize, sy, nextSize);
		
		fillingTile(sx + nextSize, sy + nextSize, nextSize);
	}
}
