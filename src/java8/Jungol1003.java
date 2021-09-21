package java8;

import java.util.Scanner;

//줄세우기, KOI 2004 초등부
public class Jungol1003 {
	static int studentCnt;	//학생 수 
	static int numbers[]; //학생들이 뽑은 수
	static int studentOrder[]; //학생들 순서
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		studentCnt = input.nextInt();
		studentOrder = new int[studentCnt];
		numbers = new int[studentCnt];
		
		for(int i = 0 ; i < studentCnt; i++){
			numbers[i] = input.nextInt();
			studentOrder[i] = i + 1;
		}
		
		for(int i = 1; i < numbers.length; i++){
			//0이면 안움직임
			if(numbers[i] != 0){
				reorder(i, numbers[i]);
			}
		}
		//출력
		for(int i = 0 ; i < studentOrder.length; i++){
			System.out.print(studentOrder[i]+" ");
		}
	}
	//재정렬
	static void reorder(int b, int size){
		int temp;
		for(int i = 0; i < size; i++){
			temp = studentOrder[b - i];
			studentOrder[b - i] = studentOrder[b - i - 1];
			studentOrder[b - i - 1] = temp;
		}
	}
}
