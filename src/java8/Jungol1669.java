package java8;

import java.util.Scanner;

/*소시지 공장
영훈이가 소시지 공장에 견학을 갔다. 그 소시지공장에서는 하나의 기계가 길이와 너비가 다양한 소시지를 만들어 내고 있었다.
유심히 살펴보니 그 기계는 현재 만들고 있는 소시지의 길이와 너비가 바로 전에 만들었던 소시지의 길이, 너비보다 크거나 같아야만 기계가 쉬지 않고 작동하고 있었다. 
만약 현재 만들고 있는 소시지의 길이 또는 너비가 바로 전에 만든 것보다 작다면, 기계가 준비 작업을 하는데 1분이 소요된다는 것을 알았다.
영훈이는 주문 받은 소시지의 길이와 너비를 보고 어떤 소시지부터 만들어 나가는 것이 기계의 준비 작업에 소요되는 시간을 줄일 수 있을지 고민하고 있다.
주문받은 소시지들을 만드는데 기계가 준비 작업에 소요한 최소의 시간을 구하는 프로그램을 작성하시오.
단, 첫 소시지를 만들 때는 기계의 준비작업 시간이 1분 소요된다.
첫 줄에는 주문받은 소시지의 개수 N(1≤N≤5,000)이다.
둘째 줄에는 소시지의 길이 SL과 소시지의 너비 SW가 N개의 쌍으로 나열된다.
*/
public class Jungol1669 {
	public static void main(String[] args){
		int sausageAmount;
		
		Scanner input = new Scanner(System.in);
		//소시지 개수 입력
		sausageAmount = input.nextInt();
		
		int sausageLength[] = new int[sausageAmount];
		int sausageWidth[] = new int[sausageAmount];
		boolean visited[] = new boolean[sausageAmount];
		//소시지 길이, 너비 입력
		for(int i = 0 ; i < sausageAmount ; i++){
			sausageLength[i] = input.nextInt();
			sausageWidth[i] = input.nextInt();
		}
		//길이로 정렬
		sort(sausageLength, sausageWidth);
		
		//준비시간 
		int count = 0;
		//전에 선택한 소시지 너비(이것보다 커야 준비시간을 줄일 수 있다)
		int prevWidth;
		//소시지 탐색
		for(int j = 0 ; j < sausageLength.length; j++){
			//이미 선택 된 소시지면 다음으로 넘어간다
			if(visited[j] == true){
				continue;
			}
			//아니라면 소시지를 선택하고 준비시간(count)가 증가
			prevWidth = j;
			count++;
			//선택한 소시지(j) 다음 소시지들(i)이 준비시간 없이 만들 수 있는 것을 체크
			for(int i = j ; i < sausageWidth.length; i++){
				if(visited[i] == false && sausageWidth[i] >= sausageWidth[prevWidth]){//sausageWidth[j]){
					//다음 소시지 너비와 비교 하기 위해 바로 전 소시지 너비를 저장
					prevWidth = i;
					visited[i] = true;
				}
			}
		}
		
		System.out.println(count);
		
	}
	//길이로  정렬
	private static void sort(int[] arr, int [] arr2){
		int temp = -1, temp2 = -1;
		
		for(int i = 0 ; i < arr.length - 1; i++){
			for(int j = i+1; j < arr.length; j++){
				if(arr[i] > arr[j]){
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					
					temp2 = arr2[i];
					arr2[i] = arr2[j];
					arr2[j] = temp2;
				}
			}
		}/*
		for(int i : arr){
			System.out.print(i +" ");
		}
		System.out.println();
		for(int i : arr2){
			System.out.print(i +" ");
		}*/
	}
}
