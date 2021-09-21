package java8;

import java.util.Scanner;

//1459숫자고르기 Jungol
public class Jungol1459 {
	
	static boolean[] isChecked; //현재 확인된 숫자
	static int[] secondRowValues; //입력으로 들어올 두번째 줄 숫자들
	static int current; //현재 탐색 시작하는 숫자
	static boolean flag; //재귀를 통해 끝까지 갔을때 현재 탐색 숫자와 같지 않으면 true
	static int count = 0; //isChecked 배열 중 true인 숫자 개수
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		int N;
		//숫자 갯수
		N = input.nextInt();
		isChecked = new boolean[N+1];
		secondRowValues = new int[N+1];
		//숫자들 입력
		for(int i = 1 ; i < N + 1; i++){
			secondRowValues[i] = input.nextInt();
		}
		
		for(int i = 1 ; i < N + 1; i++){
			if(isChecked[i] != true){
				current = i;
				flag = false;
				toTheDeep(i);
			}
		}
		for(int i = 1 ; i < N + 1; i++){
			if(isChecked[i] == true){
				count++;
			}
		}
		System.out.println(count);
		for(int i = 1 ; i < N + 1; i++){
			if(isChecked[i] == true){
				System.out.println(i);
			}
		}
		
	}
	private static void toTheDeep(int i){
		
		isChecked[i] = true;
		if(isChecked[secondRowValues[i]] == true && secondRowValues[i] == current){
			return;
		}
		if(isChecked[secondRowValues[i]] == true && secondRowValues[i] != current){
			isChecked[i] = false;
			//현재 탐색 숫자와 같지 않으므로 true
			flag = true;
			return;
		}
		toTheDeep(secondRowValues[i]);
		//백트래킹하며 flag==true(탐색숫자와 끝나는 숫자가 다른 경우)
		if(flag){
			isChecked[i] = false;
		}
	}
}
