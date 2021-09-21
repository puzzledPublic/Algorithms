package java8;

import java.util.Scanner;

//삽입정렬
//모든 요소를 앞에서부터 차례대로 이미 정렬된 배열 부분과 비교하여, 자신의 위치를 찾아 삽입하는 방법
//첫줄에 수열의 길이 N(4≤N≤100)이 주어진다.
//두 번째 줄에 N개의 0이상 100이하의 정수가 주어진다.
public class Jungol1158 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n, temp, index;
		n = scanner.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scanner.nextInt();
		}
		for(int i = 1; i < n; i++){
			temp = arr[i];
			index = i - 1;
			while(index>=0 && arr[index] > temp){
				arr[index+1] = arr[index];
				index--;
			}
			arr[index+1] = temp;
			for (int j = 0; j < n; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
		}
		/*
		for(int i = 1 ; i < n; i++){
			index = i;
			for(int j = i-1; j >= 0; j--){
				if(arr[index]<arr[j]){
					temp = arr[index];
					arr[index] = arr[j];
					arr[j] = temp;
					index--;
				}else{
					break;
				}
			}
			for (int j = 0; j < n; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
		}*/
	
	}
}
