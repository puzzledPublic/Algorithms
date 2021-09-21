package java8;

import java.util.Scanner;

//버블정렬
//두 인접한 원소를 검사하여 자리를 바꾸는 과정을 반복하며 정렬하는 방법
//1. 첫번째 값과 두번째 값을 비교하여 첫번째 값이 크면 자리를 바꾼다.
//2. 두번째 값과 세번째 값을 비교하여 두번째 값이 크면 자리를 바꾼다.
//3. 위와 같이 반복하여 N-1번째 값과 N번째 값을 비교하여 N-1번째 값이 크면 자리를 바꾼다. 
//   이 단계가 끝나면 N번째에 가장 큰 수가 자리하게 된다. (한단계완료)
//4. N번째를 제외하고 1~3을 반복하면 N-1번째에 두 번째로 큰수가 자리한다. (2단계 완료) 
//5. 위와같은 작업을 N-1번 반복하면 모든 데이터가 순서대로 정렬된다.
public class Jungol1157 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n, temp;
		n = scanner.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i]=scanner.nextInt();
		}
		
		for(int i = n-1; i > 0; i--){
			for(int j = 0; j < i; j++){
				if(arr[j]>arr[j+1]){
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}

			}
			for(int j = 0; j < n; j++){
				System.out.print(arr[j]+" ");
			}System.out.println();
		}
	}
}
