package java8;

import java.util.Scanner;

//동전 자판기 下 (그리디)
public class Jungol1183 {
	static int coins[] = {500, 100, 50, 10, 5, 1};
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int price;
		int coinCounts[] = new int[6];
		int result[] = new int[6];
		
		//입력
		price = input.nextInt();
		for(int i = 0 ; i < coinCounts.length; i++){
			coinCounts[i] = input.nextInt();
		}
		
		//계산
		for(int i = 5; i >= 1; i--){
			if(price == 0){	//price를 맞추면 stop
				break;
			}
			price -= (coins[i] * coinCounts[i]);
			result[i] = coinCounts[i];
			
			while(price % coins[i-1] != 0){
				price += coins[i];
				result[i]--;
				if(result[i] == -1){	// -1이 나오는 경우 지금의 상태로는 price를 맞출 수 없으므로 모두 0으로 바꿈
					for(int j = i ; j < 6; j++){
						result[j] = 0;
					}
				}
			}
		}
		
		result[0] = price / coins[0];	//price에 맞게 끔 입력이 들어온다는 가정이 있으므로 안전
		
		//출력
		int count = 0;
		for(int i : result){
			count += i;
		}
		System.out.println(count);
		for(int i : result){
			System.out.print(i+" ");
		}
	}
}
