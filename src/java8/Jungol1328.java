package java8;

import java.util.Scanner;

//빌딩, 자료구조1
public class Jungol1328 {

	static int buildings[];	//빌딩 높이 배열
	static int stack[][];	//스택 배열 [][0] = 빌딩 높이 값, [][1] = 빌딩 위치 값
	static int result[];	//결과 배열
	static int top = -1;	//스택 포인터
	
	public static void main(String[] args) {
		//입력
		Scanner input = new Scanner(System.in);
		int N;
		N = input.nextInt();
		
		buildings = new int[N];
		stack = new int[N][2];
		result = new int[N];
		
		for(int i = 0 ; i < N; i++){
			buildings[i] = input.nextInt();
		}
		
		//계산
		push(buildings[0], 0); //처음 아이템 스택 삽입
		
		for(int i = 1; i < N; i++){
			
			if(stack[top][0] > buildings[i]){	//현재 스택포인터의 빌딩 높이가 현재 건물 높이보다 높으면 스택 삽입.
				push(buildings[i], i);
			}
			else{
				while(top > -1 && stack[top][0] < buildings[i] ){	//스택이 남아있고 현재 스택포인터의 빌딩 높이가 현재 건물 높이보다 큰 동안..
					result[stack[top][1]] = i+1; //현재 스택포인터의 빌딩 위치의 결과값에 현재 빌딩 위치 대입 (건물 위치는 1부터 시작하므로 +1 해준다)
					pop();	//결과가 나온 스택값은 제거
					
				}
				push(buildings[i], i);	//현재 건물도 스택에 삽입
			}
		}
		
		//출력
		for(int i = 0 ; i < result.length; i++){
			System.out.println(result[i]);
		}
	}
	
	//스택 아이템 삽입
	static void push(int bSize, int pos){
		if(top + 1 == stack.length - 1){
			return;
		}
		top++;
		stack[top][0] = bSize;
		stack[top][1] = pos;
	}
	
	//스택 아이템 제거
	static void pop(){
		if(top < 0){
			return;
		}
		top--;
	}
}
