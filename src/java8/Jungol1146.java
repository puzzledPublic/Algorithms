package java8;

import java.util.Scanner;

//선택정렬
//1. 주어진 수열 중에 최소값을 찾는다.
//2. 찾은 최소값을 맨 앞의 값과 자리를 바꾼다.
//3. 맨 앞의 값을 뺀 나머지 수열을 같은 방법으로 전체 개수-1번 반복 실행한다.
//n개의 주어진 수열을 위와 같은 방법으로 정렬한다.
//수열이 주어지면 선택정렬의 과정을 한 단계씩 출력한다.
//입력: 수열의 길이 N(4<= N <=100), N개의 정수들(0 <= <= 100)
public class Jungol1146 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n, min = 1001, k = 0, least, temp;
		n = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		for(int i = 0 ; i < n - 1; i++){
			least = i;
			for(int j = i+1; j < n; j++){
				if(arr[j] < arr[least]) {
					least = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[least];
			arr[least] = temp;
			for (int j = 0; j < n; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
		}
		/*
		for (int i = 0; i < n - 1; i++) {
			for (int j = i; j < n; j++) {
				if (min > arr[j]) {
					min = arr[j];
					k = j;
				}
			}
			arr[k] = arr[i];
			arr[i] = min;
			min = 1001;
			for (int j = 0; j < n; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
		}*/
	}
}
