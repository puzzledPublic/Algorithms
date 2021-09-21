package java8;

import java.util.Scanner;

//벨트 KOI 2015 초등부
public class Jungol2912 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int M;
		M = input.nextInt();
		int arr[][] = new int[M][3]; //M번째 바퀴 회전수, 연결된 바퀴 회전 수, 벨트 형태(0->0자 형태, 1->8자 형태)
		
		boolean flag = true; //시계방향
		
		for(int i = 0 ; i < M; i++){	//입력
			arr[i][0] = input.nextInt();
			arr[i][1] = input.nextInt();
			arr[i][2] = input.nextInt();
		}
		arr[0][1] /= arr[0][0]; //첫번째 바퀴 회전수를 1로 맞춘다
		arr[0][0] /= arr[0][0]; 
		if(arr[0][2] == 1){		//아래 for문에서 i = 1 부터 시작이므로 i = 0일때 벨트 형태 수정 
			flag = !flag;
		}
		for(int i = 1 ; i < M; i++){
			//바퀴 회전 수를 서로 맞춰 줌
			if(arr[i][0] > arr[i-1][1]){ 
				arr[i][1] /=(arr[i][0]/arr[i-1][1]);
			}
			else{
				 arr[i][1] *= (arr[i-1][1]/arr[i][0]);
			}
			//벨트 형태 조정
			if(arr[i][2] == 1){
				flag = !flag;
			}
		}
		System.out.println((flag? 0:1) + " " + arr[M-1][1]);
	}
}
