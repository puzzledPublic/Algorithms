package java8;

import java.util.Scanner;

//좋은 수열
/*숫자 1 2 3으로만 이루어지는 수열이 있다. 
임의의 길이의 인접한 두 개의 부분 수열이 동일한 것이 있으면, 그 수열을 나쁜 수열이라고 부른다. 
그렇지 않은 수열은 좋은 수열이다.
길이가 N인 좋은 수열들을 N자리의 정수로 보아 그중 가장 작은 수를 나타내는 수열을 구하는 프로그램을 작성하라.
예를 들면 1213121과 2123212는 모두 좋은 수열이지만 그 중에서 작은 수를 나타내는 수열 1213121이다.
입력파일은 숫자 N 하나로 이루어진다.
N은 1 이상 80 이하이다.
첫 번째 줄에 1, 2, 3으로만 이루어져 있는 길이가 N인 좋은 수열들 중에서 가장 작은 수를 나타내는 수열만 출력한다.
수열을 이루는 1, 2, 3들 사이에는 빈칸을 두지 않는다.*/
public class Jungol1027 {
	static int N;
	static int sequence[];
	static int can;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		N = input.nextInt();
		sequence = new int[81];
		
		sequence[1] = 1;
		solve(1);
		
		for(int i = 1 ; i < sequence.length; i++) {
			if(sequence[i] == 0) {
				break;
			}
			System.out.print(sequence[i]);
		}
	}
	
	static void solve(int n) {	//n자리까지 좋은 수열
		if(!isGoodSequence(n)) {	//지금까지 만든 수열이 좋은 수열인가?
			return;
		}
		if(n == N) {	//원하는 자리수까지 진행시 종료
			can = 1;
			return;
		}
		
		for(int i = 1; i <= 3; i++) {	//1, 2, 3이 올 수 있다.
			if(can == 0) {	
				sequence[n + 1] = i;	//수열을 추가한다.
				solve(n + 1);	//n + 1자리로
			}
		}
	}
	static boolean isGoodSequence(int end) {	//좋은 수열인지 확인하는 메소드	ex) index가 1~5 인 배열에서 (5,4) 비교, (5,3),(4,2) 비교를 해서 같지 않으면 좋은 수열이다
		int time = end / 2;
		for(int i = 1; i <= time; i++) {
			int count = 0;
			for(int j = 1; j <= i; j++) {
				if(sequence[end - j + 1] == sequence[end - j + 1 - i]) {
					count++;
				}else {
					break;
				}
			}
			if(count == i) {
				return false;
			}
		}
		return true;
	}
}
