package java8;

import java.util.Scanner;

//참외밭
// ㄱ자로 생긴 참외밭이 있다. 이 밭은 90, 180 270도로 회전한 상태일 수도 있다.
// 참외밭의 임의의 모서리에서 출발하여 반시계 방향으로 돌아 출발지로 다시 돌아왔을때 참외밭에 심을 수 있는 총 참외의 수를 구하라.
// 입력: 첫번쨰 줄에 1m^2당 자라는 참외 개수 K (1 <= K <=20),
//      참외밭 임의의 모서리에서 출발하여 다시 출발지까지로 돌아오는 방향(동:1, 서:2, 남:3, 북:4)과, 변의 길이(1 <= <=500)들이 주어진다.
public class Jungol2259 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//1m^2당 참외 개수
		int orientalMelonPerSpace;
		orientalMelonPerSpace = scanner.nextInt();
		//방향을 넣을 배열
		int[] direction = new int[6];
		//각 변의 길이를 넣을 배열
		int[] lengths = new int[6];
		//방향들의 개수를 넣을 배열
		int[] dirNumbers = new int[5];
		//방향과 변의 길이 입력
		for(int i = 0 ; i < 6; i++){
			direction[i] = scanner.nextInt();
			lengths[i] = scanner.nextInt();
		}
		//방향들의 개수를 계산
		for(int i = 0 ; i < direction.length;i++){
			dirNumbers[direction[i]]++;
		}
		//외곽 사각형
		int outerRect = 1;
		//내곽 사각형
		int innerRect = 1;
		//방향들의 개수들을 돌며
		for(int i = 1 ; i < dirNumbers.length; i++){
			//방향의 개수가 1이면 외곽 사각형의 높이,너비를 담당한다 (idea:각 참외밭은 동서남북 중에 1가지씩 2개 방향, 2가지씩 2개 방향(총 6개의 변)을 갖는다)
			if(dirNumbers[i] == 1){
				//방향에 대한 변의 길이를 찾아 outerRect에 곱한다.
				for(int j = 0 ; j < direction.length; j++){
					if(direction[j] == i){
						outerRect *= lengths[j];
					}
				}
				//내곽 사각형을 구하기 위해 direction 배열을 탐색
				for(int j = 0; j < direction.length; j++){
					//현재 방향과 다음 순서의 방향의 개수가 1이라면 현재 방향에서 3번 이후와 4번 이후의 변이 내곽 사각형의 높이, 너비 역할을 한다.
					if(direction[j] == i && dirNumbers[direction[(j+1)%6]] == 1){
						innerRect = lengths[(j+3)%6] * lengths[(j+4)%6];
						break;
					}
					//다음 순서의 방향의 개수가 1이 아니라면(2라면) 현재 방향에서 2번 이후와 3번 이후의 변이 내곽 사각형의 높이, 너비 역할을 한다.
					else if(direction[j] == i && dirNumbers[direction[(j+1)%6]] != 1){
						innerRect = lengths[(j+2)%6] * lengths[(j+3)%6];
						break;
					}
					//System.out.println(outerRect +" "+ innerRect);
				}
			}
		}//System.out.println(outerRect +" "+ innerRect);
		//외곽 사각형 넓이에서 내곽 사각형 넓이를 빼면 참외밭 넓이가 나오며 여기에 1m^2당 참외 개수를 더하면 최종 결과
		System.out.println((outerRect - innerRect)*orientalMelonPerSpace);
	}
}
