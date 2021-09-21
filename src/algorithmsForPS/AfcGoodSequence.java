package algorithmsForPS;

import java.util.Scanner;

public class AfcGoodSequence {
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
		
		for(int i = 1; i <= 3; i++) {	//다음 숫자로 1, 2, 3이 올 수 있다.
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
