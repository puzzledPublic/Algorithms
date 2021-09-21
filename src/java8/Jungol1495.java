package java8;

import java.util.Scanner;

//대각선 지그재그
public class Jungol1495 {

	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int n;
		n = scanner.nextInt();
		zigzag(n);
	}
	public static void zigzag(int n){
		int arr[][] = new int[n][n];
		//0으로 초기화
		for(int i = 0 ; i < n;i++){
			for(int j = 0 ; j<n;j++){
				arr[i][j] = 0;
			}
		}
		//시작 넘버
		int num = 1;
		int x=0,y=0;
		//0,0 위치 숫자 삽입
		arr[x][y] = num++;
		//num가 n*n까지 출력 될 때까지
		while(num <= n*n){
			//아래부터 시작해서 넣을 수 있다면 삽입
			if(x<n-1){
				x++;
				arr[x][y] = num++;
			}//없다면 오른쪽에 삽입
			else{
				y++;
				arr[x][y] = num++;
			}
			//오른쪽 위 대각선 방향으로 삽입 
			while(arr[x-1][y+1] == 0){
				x--;
				y++;
				arr[x][y] = num++;
				//배열의 크기를 넘어 검사하기전 break;
				if(x == 0 || y == n-1)break;
			}
			//y축 끝에 도달하면 오른쪽에 넣을 수 있다면 삽입 
			if(y<n-1){
				y++;
				arr[x][y] = num++;
			}//아니라면 아래에 삽입
			else{
				x++;
				arr[x][y] = num++;
			}
			//n-1,n-1 위치까지 도달하면 끝낸다.
			if(x == n-1 && y== n-1) break;
			//왼쪽 아래 대각선 방향으로 삽입
			while(arr[x+1][y-1] == 0){
				x++;
				y--;
				arr[x][y] = num++;
				if(y == 0 || x == n-1)break;
			}
		}
		//출력
		for(int i = 0 ; i < n;i++){
			for(int j = 0 ; j<n;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
