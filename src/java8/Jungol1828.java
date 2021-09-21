package java8;

import java.util.Scanner;

//냉장고
/*N개의 화학 물질 C1, C2, …, Cn이 있다. 이들 각각은 보관되어야 할 온도가 각기 다른데, 
   각 Ci마다 최저 보관 온도 xi와 최고 보관 온도 yi가 정해져 있다. 즉 Ci는 온도 xi이상, yi이하의 온도에서 보관되어야만 안전하다.
   이 화학 물질들을 모두 보관하기 위해서는 여러 대의 냉장고가 필요한데 가능하면 적은 수의 냉장고를 사용하고 싶다. 이를 해결하는 프로그램을 작성하시오.
입력: 첫줄에 화학물질의 수 N이 입력된다. N의 범위는 1이상 100 이하이다.
       두 번째 줄부터 N+1줄까지 최저보관온도와 최고보관온도가 입력된다.
       보관온도는 -270° ~ 10000°이며, 각 냉장고는 임의의 정해진 온도를 일정하게 유지할 수 있고, 냉장고는 아주 크다고 가정한다.
출력: 첫줄에 최소로 필요한 냉장고의 대수를 출력한다.
*/

public class Jungol1828 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		n = input.nextInt();
		int[] lowestTemp = new int[n];
		int[] highestTemp = new int[n];
		for(int i = 0 ; i < n; i++){
			lowestTemp[i] = input.nextInt();
			highestTemp[i] = input.nextInt();
		}
		//최소보관온도 순으로 정렬
		sort(lowestTemp, highestTemp);
		int count = 0;
		/*
		int base;
		for(int i = 0 ; i < lowestTemp.length; i++){
			count++;
			base = highestTemp[i];
			for(int j = i+1; j < lowestTemp.length; j++){
				//System.out.println(i+" "+j);
				i = j;
				if(lowestTemp[j]>base){
					//i = j-1;
					i--;
					break;
				}
			}
		}*/
		//기본으로 냉장고 하나
		count = 1;
		//현재 화학물질 온도 범위
		int lowTemp = lowestTemp[0], highTemp = highestTemp[0];
		for(int i = 1 ; i < lowestTemp.length; i++){
			//탐색하는 화학물질 최대보관온도가 더 작으면 최대 기준 온도를 낮춘다
			if(highTemp > highestTemp[i]){
				highTemp = highestTemp[i];
			}//탐색하는 화학물질 최소보관온도가 더 높다면 최소 기준 온도를 높인다
			if(lowTemp < lowestTemp[i]){
				lowTemp = lowestTemp[i];
			}
			//탐색하는 최소보관온도가 기준 온도범위를 벗어난다면 냉장고 추가 후 기준 초기화
			if(lowestTemp[i]> highTemp ){
				//System.out.println(lowestTemp[i]+" "+ highTemp);
				count++;
				lowTemp = lowestTemp[i];
				highTemp = highestTemp[i];
			}
		}
		System.out.println(count);
	}
	//정렬
	private static void sort(int[] lowest, int[] highest){
		
		int temp, temp2;
		for(int i = 0 ; i < lowest.length - 1; i++){
			for(int j = i+1; j < lowest.length; j++){
				if(lowest[i]>lowest[j]){
					temp = lowest[i];
					lowest[i] = lowest[j];
					lowest[j] =temp;
					
					temp2 = highest[i];
					highest[i] = highest[j];
					highest[j] = temp2;
				}
			}
		}/*
		for(int i =0;i<lowest.length;i++){
			System.out.println(lowest[i]+" "+highest[i]);
		}*/
	}
}
