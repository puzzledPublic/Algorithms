package java8;

import java.util.Arrays;
import java.util.Scanner;

//저울
/*무게가 양의 정수인 N개의 저울추가 주어질 때, 이 추들을 사용하여 측정할 수 없는 양의 정수 무게 중 최소값을 구하는 프로그램을 작성하시오.
예를 들어, 무게가 각각 3, 1, 6, 2, 7, 30, 1인 7개의 저울추가 주어졌을 때, 이 추들로 측정할 수 없는 양의 정수 무게 중 최소값은 21이다.
<제약조건>
1≤N≤10인 경우는 전체 테스트 데이터의 30%이다.
첫 째 줄에는 저울추의 개수를 나타내는 양의 정수 N이 주어진다. N은 1 이상 1,000 이하이다.
둘째 줄에는 저울추의 무게를 나타내는 N개의 양의 정수가 빈칸을 사이에 두고 주어진다.
각 추의 무게는 1이상 1,000,000 이하이다.
첫째 줄에 주어진 추들로 측정할 수 없는 양의 정수 무게 중 최소값을 출력한다.*/
public class Jungol2499 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		int weights[] = new int[N];
		for(int i = 0 ; i < N; i++){
			weights[i] = input.nextInt();
		}
		Arrays.sort(weights);
		if(weights[0]!=1){
			System.out.println(1);
			return;
		}
		int sum = weights[0];
		for(int i = 1 ; i < weights.length; i++){
			if(sum+1>=weights[i]){
				sum+=weights[i];
			}else
			{
				break;
			}
		}
		System.out.println(sum+1);
	}
}
