package programmers;

import java.util.Arrays;

//숫자 블록
public class NumberBlock {
	public static void main(String[] args) {
		int[] begin = {1};
		int[] end = {1000};
		for(int i = 0; i < begin.length; i++) {
			System.out.println(Arrays.toString(solution(begin[i], end[i])));
		}
	}

	static int[] solution(long begin, long end) {
		int[] answer = new int[(int)(end - begin + 1)];
		int index = 0;
		for(long i = begin; i <= end; i++) {
			if(i == 1) {	//제일 처음 블록은 채워지지않는다.
				answer[index++] = 0;
			}
			else if(isPrime(i)) {	//블록위치가 소수인경우 1
				answer[index++] = 1;
			}else {
				int div = 2;		//어떤 위치 x에 넣는 블록은 그 이전 x / k (k>=2)위치에서 시작할 수 있고 이는 나눠떨어져야한다.
				while(i % div != 0) {
					div++;
				}
				answer[index++] = (int)(i / div);
			}
		}
		
		return answer;
	}
	
	static boolean isPrime(long n) {
		for(long i = 2; i * i <= n; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
