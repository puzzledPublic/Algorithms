package java8;

import java.util.Scanner;

//불쾌한날, USACO 2006 November Silver
public class Jungol1141{
	static int cowNum;
	static int stack[];
	static int top = -1;
	static long sum;	//합의 크기가 큼
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		cowNum = input.nextInt();
		stack = new int[cowNum];
		
		int temp;
		for(int i = 0; i < cowNum ; i++){	//스택을 이용하여 계산 횟수를 줄여봄
			temp = input.nextInt();
			while(top != -1 && stack[top] <= temp){
				pop();
			}
			push(temp);
			sum += top;
		}
		
		System.out.println(sum);
		
	}
	static void push(int height){
		if(stack.length == top + 1){
			return;
		}
		stack[top+1] = height;
		top++;
	}
	static int pop(){
		if(top < 0){
			return -1;
		}
		return stack[top--];
	}
}
//시간 초과!!! 
/*public class Jungol1141 {
	static int cowNum;
	static int cowHeights[];
	static int sum;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		cowNum = input.nextInt();
		cowHeights = new int[cowNum];
		//입력
		for(int i = 0 ; i < cowNum; i++){
			cowHeights[i] = input.nextInt();
		}
		//입력 끝
		
		int tempCount = 0;
		
		for(int i = 0 ; i < cowHeights.length; i++){
			tempCount = 1;
			while(i + tempCount < cowHeights.length && cowHeights[i] > cowHeights[i + tempCount]){
				tempCount++;
				sum++;
			}
		}
		
		//출력
		System.out.println(sum);
		//출력 끝
	}
}*/
