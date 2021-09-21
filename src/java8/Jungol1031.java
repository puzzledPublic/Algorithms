package java8;

import java.util.Scanner;

//빙고
//5x5 빙고 테이블이 주어지고 호출되는 숫자열이 있을때 빙고를 외치는 순서번호를 출력하라
//빙고는 3줄이 불려졌다면 빙고를 외친다.
public class Jungol1031 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int bingoTable[][] = new int[5][5];
		int numbers[] = new int[25];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				bingoTable[i][j] = scanner.nextInt();
			}
		}
		for (int i = 0; i < 25; i++) {
			numbers[i] = scanner.nextInt();
		}
		bingo(bingoTable, numbers);
	}
	//5x5로 고정돼서 하나가 불려질때 마다 빙고판 전체를 검사해봄
	static void bingo(int[][] bingoTable, int[] numbers) {
		//한줄이 빙고인지 확인할 변수
		int count = 0;
		//3줄 이상 빙고인지 확인할 변수
		int bingoCount = 0;
		for (int k = 0; k < numbers.length; k++) {
			for (int i = 0; i < bingoTable.length; i++) {
				for (int j = 0; j < bingoTable[0].length; j++) {
					if(bingoTable[i][j] == numbers[k]){
						bingoTable[i][j] = 0;
						break;
					}
				}
			}
			for(int i = 0 ; i < bingoTable.length; i++){
				for(int j = 0 ; j < bingoTable[0].length;j++){
					if(bingoTable[j][i]==0){
						count++;
					}
				}
				if(count==5){
					bingoCount++;
				}
				count = 0;
				for(int j = 0 ; j < bingoTable[0].length;j++){
					if(bingoTable[i][j]==0){
						count++;
					}
				}
				if(count==5){
					bingoCount++;
				}
				count = 0;
			}
			for(int j = 0;j < bingoTable[0].length;j++){
				if(bingoTable[j][j] == 0){
					count++;
				}
			}
			if(count==5){
				bingoCount++;
			}
			count = 0;
			for(int j = 0;j < bingoTable[0].length;j++){
				if(bingoTable[j][bingoTable[0].length-1-j] == 0){
					count++;
				}
			}
			if(count==5){
				bingoCount++;
			}
			count = 0;
			if(bingoCount >2){
				System.out.println(k+1);
				break;
			}
			bingoCount =0;
		}
	}
}
