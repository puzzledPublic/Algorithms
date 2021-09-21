package java8;

import java.util.Scanner;

//이진탐색
//오름차순의 순서대로 정렬되어 있는 N개의 데이터에서 특정한 숫자가 몇 번째 위치인지를 출력하라
//첫 줄에 N이 주어진다. N은 정렬되어 주어지는 데이터의 수이다.(1≤N≤50,000)
//둘째 줄에는 N개의 서로 다른 수가 정렬되어 주어진다. 각 수는 공백 하나로 분리되어 주어진다.
//셋째 줄에는 데이터에서 찾아야할 특정한 수의 개수 T가 주어진다. 즉, T가 3이면 3개의 수를 정렬된 데이터에서 찾아야 한다.(1≤T≤10,000)
//넷째 줄에는 T개의 수가 공백 하나로 분리되어 주어진다.
//찾아야할 수가 정렬되어 주어진 데이터의 수중에서 앞에서부터 몇 번째에 있는지 그 위치를 출력한다. 첫 번째 위치는 1이다. 만약, 찾으려는 수가 주어지는 데이터에 존재하지 않는다면, 0을 출력한다.
public class Jungol1295 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n, t;

		n = scanner.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}

		t = scanner.nextInt();
		int[] numbers = new int[t];
		for (int i = 0; i < t; i++) {
			numbers[i] = scanner.nextInt();
		}
		for (int i = 0; i < t; i++) {
			binarySearch2(arr, numbers[i]);
		}
	}
/*
	static void binarySearch(int[] arr, int number) {
		int low = 0;
		int high = arr.length;
		int index = (arr.length - 1) / 2;
		int count = 0;
		while (arr[index] != number ) {
			if (number < arr[index]) {
				high = index;
				index = (low + index) / 2;
			} else {
				low = index;
				index = (index + high) / 2;
			}
			count++;
			if(count > arr.length / 2 + 1){
				break;
			}
		}
		if (count > arr.length / 2 + 1) {
			System.out.println(0);
		} else {
			System.out.println(index + 1);
		}
	}*/
	static void binarySearch2(int[] arr, int number){
		int low = 0;
		int high = arr.length;
		int index = -1;
		while(low<=high){
			index = (low + high)/2;
			if(arr[index] == number){
				break;
			}
			else if(arr[index] > number){
				high = index - 1;
				
			}else{
				low = index + 1;
			}
		}
		if(low>high){
			System.out.println(0);
		}else{
			System.out.println(index + 1);
		}
	}
}
