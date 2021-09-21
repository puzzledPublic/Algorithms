package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//제곱ㄴㄴ수
public class BJ1016 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		solve(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
	}
	static void solve(long min, long max) {
		int diff = (int)(max - min) + 1;	//최대값, 최소값의 차이
		int[] arr = new int[diff];			//그 차이만큼 배열 생성
		int limit = (int)Math.sqrt(max);	//소수들을 구하기 위한 최대값의 제곱근. 제곱수로 나눠지는 수들의 규칙을 살펴보면 소수의 제곱들만 중복이 안된다.
		boolean[] erasto = new boolean[limit + 1];	//에라토스테네스의 체
		for(int i = 2; i <= limit; i++) {
			if(!erasto[i]) {
				for(int j = i * 2; j < erasto.length; j += i) {
					erasto[j] = true;
				}
			}
		}
		
		for(long k = 2; k <= limit; k++) {	//체를 돌며
			if(erasto[(int)k] == false) {	//소수면
				long start = min % (k * k) == 0 ? min : min - (min % (k * k)) + (k * k); 
				for(long j = start; j <= max; j += k * k) {
//				for(long j = ((min - 1) / (k * k) + 1) * (k * k); j <= max; j += (k * k)) {	//소수의 제곱으로 나눠지는 최소값 이상의 최초 숫자부터 돌며 에라토스테네스 체 처럼 표시
					arr[(int)(j - min)] = 1;												//예를 들면 소수 2의 제곱은 4이고 min이 97일때 98부터 시작
				}
			}
		}

		int count = 0;
		for(int i = 0; i < arr.length; i++) {	//제곱 ㄴㄴ 수를 센다.
			if(arr[i] == 0) {
				count++;
			}
		}
		System.out.println(count);
	}
}
