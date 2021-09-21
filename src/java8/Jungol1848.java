package java8;

import java.util.Scanner;

//극장 좌석 (다이나믹) 2005 초등부
public class Jungol1848 {
	static int result = 1;
	static int cases[];
	static int cache[] = new int[41];
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		cases = new int[M+1];	//경우의 수 계산이 필요한 n개수 배열
		for(int i = 0 ; i < cache.length; i++){	//경우의 수를 계산하기 위해 메모이제이션 배열 초기화
			cache[i] = -1;
		}
		int prev = 0, next;		//N = 40, M = 0인 경우를 위해 prev = 0으로
		if(M > 0){				//M > 0인 경우 경계를 나눠 n개수 배열에 추가 
			prev = input.nextInt();
			cases[0] = prev - 1;
		}
		for(int i = 1 ; i < M; i++){
			next = input.nextInt();
			cases[i] = next - prev - 1;
			prev = next;
		}
		cases[M] = N - prev;	//경계 나누기 끝
		
		for(int i = 0 ; i < cases.length; i++){		//나뉜 경계 수 만큼 n개수의 경우의 수를 구해 곱한다.		
			if(cases[i] != 0){
				result *= numberOfCase(cases[i]);
			}
		}
		
		System.out.println(result);
	}
	static int numberOfCase(int n){	//n개의 수 중 인접한 2개 숫자를 교환 할 수 있을때 나열 할 수 있는 경우의 수
		if(n <= 1){
			return 1;
		}
		if(cache[n] != -1){
			return cache[n];
		}
		return cache[n] = numberOfCase(n-2) + numberOfCase(n-1);
	}
}
