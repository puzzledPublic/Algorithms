package java8;

import java.util.Scanner;

//소수
//자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최소값을 찾아라
//소수가 없을 경우에는 -1을 출력한다.
//M <= N <= 10000
public class Jungol1740 {
	static boolean eratostenes[] = new boolean[10005];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int m, n, sum = 0, min = 99999;
		// 입력
		m = scanner.nextInt();
		n = scanner.nextInt();
		// 에라토스테네스 체 셋팅
		eratos(n);
		// 에라토스테네스 체 사용
		for (int i = m; i <= n; i++) {
			// 소수들이면
			if (eratostenes[i] == false) {
				// 소수들을 모두 합한다
				sum += i;
				// 가장 작은 소수를 구한다
				min = Math.min(min, i);
			}
		}
		// sum == 0 인 경우(소수가 없는 경우)
		if (sum == 0) {
			System.out.println("-1");
		}
		// 소수들의 합과 최소 소수를 출력
		else {
			System.out.println(sum + "\n" + min);
		}
	}

	// 에라토스테네스체
	static void eratos(int number) {

		eratostenes[1] = true;
		for (int i = 2; i * i <= number; i++) {
			if (eratostenes[i] == false) {
				for (int j = i * i; j <= number; j += i) {
					eratostenes[j] = true;
				}
			}
		}
	}
}
