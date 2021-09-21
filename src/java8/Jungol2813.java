package java8;

import java.util.Scanner;

//소수의 개수
//자연수 M과 N을 입력 받아 M부터 N까지의 소수의 개수를 구하라
//1 <= M <= N <= 2,000,000;
public class Jungol2813 {
	static boolean eratostenes[] = new boolean[2000001];

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		
		int m, n, count = 0;
		//입력
		m = scanner.nextInt();
		n = scanner.nextInt();
		//에라토스테네스 체를 사용
		eratos(n);
		//에라토스테네스 체에서 m부터 n까지의 소수의 개수를 구한다 
		for (int i = m; i <= n; i++) {
			if (eratostenes[i] == false) {
				count++;
			}
		}
		//출력
		System.out.println(count);

	}
	//에라토스테네스의 체
	static void eratos(int number) {
		//1은 소수가 아니므로 true
		eratostenes[1] = true;
		//소수를 찾으면서
		for (int i = 2; i * i <= number; i++) {
			//현재 값이 소수라면
			if (eratostenes[i] == false) {
				//그의 배수는 소수가 아니므로 모두 true 체크( i*i 전의 숫자들은 i 이전의 수들의 배수로 먼저 지워진다)
				for (int j = i * i; j <= number; j += i) {
					eratostenes[j] = true;
				}
			}
		}
	}

}
