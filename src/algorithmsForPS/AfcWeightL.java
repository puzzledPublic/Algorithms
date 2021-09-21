package algorithmsForPS;

import java.util.Scanner;

public class AfcWeightL {
	
	static int[] weights = {1, 3, 9, 27, 81, 243, 729};
	static int[] output = new int[9];
	static int[] three = new int[7];
	static int w, index = 0; 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		w = input.nextInt();
		
		//제일 처음은 주어진 무게
		output[index++] = w;
		
//		do {
//			toThree(w);
//			
//		}while(check() == 2);
//		
//		//중간 구분 0 을 위한 인덱스 건너뛰기
//		index++;
//		
//		
//		for(int i = 0; i < 7; i++) {
//			if(three[i] == 1) {
//				output[index++] = weights[i];
//			}
//		}
//		
//		//출력
//		for(int i = 0; i < index; i++) {
//			System.out.print(output[i] + " ");
//		}
		solve(w);
	}
	//3진수로 변환
	static void toThree(int num) {
		for(int i = 0; num != 0; i++, num = num / 3) {
			three[i] = num % 3;
		}
	}
	//오른편에 무게 추가 똑같은것이 2개 존재하면 양 쪽에 그 추를 추가하여 오른쪽 무게 추를 3개 만든다.
	//이 무게 추 3개는 상위 무게 추 1개로 변환된다. 
	static int check() {
		for(int i = 0; i < 7; i++) {
			if(three[i] == 2) {
				w = w + weights[i];
				output[index++] = weights[i];
				return 2;
			}
		}
		return 0;
	}
	
	static void solve(int num) {
		for(int i = 0; num != 0; i++, num = num / 3) {
			three[i] = num % 3;
		}
		
		for(int i = 0; i < three.length; i++) {
			if(three[i] == 2) {
				three[i + 1]++;
				three[i] = 0;
				output[index++] = weights[i];
			}
			if(three[i] == 3) {
				three[i + 1]++;
			}
			
		}
		index++;
		for(int i = 0; i < three.length; i++) {
			if(three[i] == 1) {
				output[index++] = weights[i];
			}
		}
		for(int i = 0; i < index; i++) {
			System.out.print(output[i] + " ");
		}
	
	}
}
