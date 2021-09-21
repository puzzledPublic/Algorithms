package java8;

import java.util.Scanner;

//수열
//0~9로 이루어진 N개의 숫자가 나열된 수열이 있다.
//이 수열에서 연속해서 커지거나 연속해서 작아지는 (같은 것 포함) 수열 중 가장 긴 수열의 길이를 출력하라
//입력: 수열의 길이 N(1 <= N <= 100,000), N개의 공백으로 구분된 0~9사이의 숫자들
public class Jungol1998 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;
		n = scanner.nextInt();
		int[] sequence = new int[n];
		for(int i = 0 ; i < n ; i++){
			sequence[i] = scanner.nextInt();
		}
		if(n == 1){
			System.out.println(1);
			return;
		}
		int max = 0;
		int hSequence = 1;
		int lSequence = 1;
		
		for(int i = 0 ; i < sequence.length-1; i++){
			if(sequence[i] <=sequence[i+1]){
				hSequence++;
				if(i==n-2){
					max = Math.max(max, hSequence);
				}
			}else{
				max = Math.max(max, hSequence);
				hSequence = 1;
			}
			if(sequence[i]>=sequence[i+1]){
				lSequence++;
				if(i==n-2){
					max = Math.max(max, lSequence);
				}
			}else{
				max = Math.max(max, lSequence);
				lSequence = 1;
			}
		}
		
		System.out.println(max);
	}
}
