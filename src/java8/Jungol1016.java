package java8;

import java.util.Scanner;

//3가지 숫자 정렬하기
public class Jungol1016 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int total = input.nextInt();	//3가지 숫자 배열 길이
		int[] numbers = new int[total+1]; //3가지 숫자 배열
		int[] countOfNum = new int[4];	//1과 2와 3의 갯수
		
		//입력
		int temp;
		for(int i = 1 ; i <= total; i++){
			temp = input.nextInt();
			numbers[i] = temp;
			countOfNum[temp]++;
		}
		
		int result = 0;	//결과값 초기화
		
		int frontIndex = 1; //바꿔야할 숫자의 배열 인덱스
		//2가 있어야하는 구역을 탐색
		for(int i = countOfNum[1]+frontIndex ; i <= countOfNum[1]+countOfNum[2]; i++){
			if(numbers[i] == 1){	//1인 숫자가 있으면
				while(frontIndex <= countOfNum[1]){	//1이 있어야하는 구역에서
					if(numbers[frontIndex] == 2){	//숫자 2가 있으면 브레이크
						break;
					}
					frontIndex++;
				}
				//숫자 교환
				temp = numbers[i];
				numbers[i] = numbers[frontIndex];
				numbers[frontIndex] = temp;
				result++;
			}
		}
		
		frontIndex = 1;
		//3이 있어야하는 구역을 탐색
		for(int i = countOfNum[1]+countOfNum[2]+frontIndex ; i <= total; i++){
			if(numbers[i] == 1){	//1인 숫자가 있으면
				while(frontIndex <= countOfNum[1]){	//1이 있어야하는 구역에서
					if(numbers[frontIndex] != 1){	//숫자 2,3 이 있으면 브레이크
						break;
					}
					frontIndex++;
				}
				//숫자교환
				temp = numbers[i];
				numbers[i] = numbers[frontIndex];
				numbers[frontIndex] = temp;
				result++;
			}
		}
		
		frontIndex = countOfNum[1]+1;
		//3이 있어야하는 구역을 탐색
		for(int i = countOfNum[2]+frontIndex ;i <= total; i++){
			if(numbers[i] == 2){	//2인 숫자가 있으면
				while(frontIndex <= countOfNum[1]+countOfNum[2]){	//2가 있어야하는 구역에서
					if(numbers[frontIndex] != 2){	//3이 있으면 브레이크
						break;
					}
					frontIndex++;
				}
				//숫자교환
				temp = numbers[i];
				numbers[i] = numbers[frontIndex];
				numbers[frontIndex] = temp;
				result++;
			}
		}
		//출력
		System.out.println(result);
	}
}
