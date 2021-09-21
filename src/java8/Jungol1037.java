package java8;

import java.util.Scanner;

//오류교정,  Ulm Local 1998
public class Jungol1037 {
	//정의된 배열들 1부터 시작
	static int parity[][];
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int size, rowCount = 0, colCount = 0, x = 0, y = 0;
		size = input.nextInt();
		parity = new int[size+1][size+1];
		
		//입력
		for(int i = 1 ; i < size + 1; i++){		
			for(int j = 1 ; j < size + 1; j++){
				parity[i][j] = input.nextInt();
			}
		}
		//입력 끝
		
		for(int i = 1; i < size + 1; i++){
			for(int j = 1; j < size + 1; j++){
				parity[i][0] += parity[i][j]; //i행 합
				parity[0][i] += parity[j][i]; //i열 합
			}
		}
		
		for(int i = 1; i < size + 1; i++){
			if(parity[i][0]%2 == 1){
				rowCount++;	//행의 합이 홀수인 개수
				x = i;		//그 좌표
			}
			if(parity[0][i]%2 == 1){
				colCount++; //열의 합이 홀수인개수
				y = i;		//그 좌표
			}
		}
		
		//출력
		if(rowCount == 0 && colCount == 0){
			System.out.println("OK");
		}
		else if(rowCount == 1 && colCount == 1){ //홀수 개수가 1개씩 존재하면 오류 교정 가능
			System.out.println("Change bit (" + x + "," + y + ")");
		}
		else{
			System.out.println("Corrupt");
		}
		//출력 끝
		
	}
}
