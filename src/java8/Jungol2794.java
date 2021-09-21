package java8;

import java.util.Scanner;

//색종이 KOI 2014 초등부
public class Jungol2794 {

	static int arr[][] = new int[1002][1002]; //색종이를 놓을 배열,
	static int count[]; //i번째 놓은 색종이 면적을 담을 배열
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();	//색종이 개수
		count = new int[N+1];
		int x, y, w, h; //(x,y) = 색종이 시작 좌표, w = 너비, h = 높이
		for(int i = 0 ; i < N; i++){
			x = input.nextInt();
			y = input.nextInt();
			w = input.nextInt();
			h = input.nextInt();
			for(int j = 0 ; j < w ; j++){ //i번째 색종이를 놓는다
				for(int k = 0 ; k < h; k++){
					arr[x+j][y+k] = i + 1; //배열이 0 으로 초기화 돼서 1부터 넣어야 하므로 +1 한다.
				}
			}
		}
		
		for(int j = 0 ; j < arr.length; j++){	//색종이 면적 계산
			for(int k = 0 ; k < arr[j].length; k++){
				count[arr[j][k]]++;
			}
		}
		for(int i = 1; i < count.length; i++){ //i번째 색종이 면적 출력
			System.out.println(count[i]);
		}
	}
}
