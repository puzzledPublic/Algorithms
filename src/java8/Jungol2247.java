package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//도서관
/*N(1≤N≤10,000)의 학생이 도서관을 이용한다고 할 때, 다음을 계산하는 프로그램을 작성하시오. 
- 적어도 한 명 이상의 학생이 머물었던 가장 긴 시간 
- 학생들이 다녀간 전체 시간 중 학생이 한 명도 머물지 않았던 가장 긴 시간
첫 줄에 정수 N(1≤N≤10000)이 입력된다.
두 번째 줄부터 N개의 줄에 걸쳐 두 정수 S, E(1≤S≤E≤2^31-1) 가 입력된다. S는 도서관에 들어온 시각 E는 학생이 도서관을 나간 시각이다.
한 명 이상의 학생이 머물었던 가장 긴 시간과 학생이 한 명도 머물지 않았던 가장 긴 시간을 공백을 구분하여 한 줄에 출력하시오.*/
public class Jungol2247 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N;
		N = input.nextInt();
		int[][] visitTime = new int[N][2];
		List<Integer> longTime = new ArrayList<>();
		List<Integer> noneTime = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			visitTime[i][0] = input.nextInt();
			visitTime[i][1] = input.nextInt();
		}
		// 정렬
		/*Arrays.sort(visitTime,(a, b) -> {
			if (a[0] < b[0]) {
				return -1;
			} else if (a[0] > b[0]) {
				return 1;
			}
			return 0;
		});*/
		int temp3[];
		for(int i = 0 ; i < visitTime.length - 1; i++){
			for(int j = i ; j < visitTime.length; j++){
				if(visitTime[i][0] > visitTime[j][0]){
					temp3 = visitTime[i];
					visitTime[i] = visitTime[j];
					visitTime[j] = temp3;
					
				}
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.println(visitTime[i][0]+" "+ visitTime[i][1]);
		}
		//탐색
		int lowestTime = visitTime[0][0];
		int highestTime = visitTime[0][1];
		for (int i = 0; i < visitTime.length; i++) {
			if (visitTime[i][0] <= highestTime) {
				if (visitTime[i][1] > highestTime) {
					highestTime = visitTime[i][1];
				}
			} else {
				longTime.add(highestTime - lowestTime);
				noneTime.add(visitTime[i][0] - highestTime);

				lowestTime = visitTime[i][0];
				highestTime = visitTime[i][1];
			}
		}
		longTime.add(highestTime - lowestTime);
		System.out.println(Collections.max(longTime) + " "
				+ Collections.max(noneTime));
	}
}
