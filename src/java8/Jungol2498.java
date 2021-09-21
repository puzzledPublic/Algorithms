package java8;

import java.util.Scanner;

//gcd(x,y)와 lcm(x,y)이 주어질 때 x, y 값을 구하는 문제 
//x, y 쌍이 여러개일 경우 x+y가 최소 값이 되는 쌍 출력 
public class Jungol2498 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		int gcd, lcm;

		gcd = scanner.nextInt();
		lcm = scanner.nextInt();
		if (lcm % gcd != 0) {
			System.out.println("해당 x, y가 없음");
			System.exit(0);
		}
		commonNumbers(gcd, lcm);
	}

	static void commonNumbers(int gcd, int lcm) {
		// x*y = gcd(x,y)*lcm(x,y)는 다음과 같이 나타낼 수 있다.
		//gcd * a * gcd * b = gcd * lcm => a * b = lcm / gcd 
		//이때 a와 b는 소수이고 서로소다. 
		//즉 a * b 가 lcm/gcd 이면서 a와 b가 소수인 값을 구하고 a+b가 최소일때 a, b에 각각 gcd를 곱해주면 되겠다
		//이를 이용하여 mult = a * b;
		int mult = lcm / gcd;
		//a의 시작을 mult로 두고
		int a = mult;
		//b의 시작은 1부터 시작한다.
		int b = 1;
		//합의 최소를 구하기 위해 현재의 합은 a + b로 둔다
		int sum = a + b;
		//합이 최소가 되도록 하는 a, b를 저장할 변수
		int lastA = a, lastB = b;
		//a가 b보다 큰 동안
		while (a > b) {
			//b를 1 증감
			b++;
			//b 가 a * b로 나뉘면 
			if (mult % b == 0) {
				// mult / b 로 나누면 b와 곱하여 mult값이 되는 a를 구할 수 있다.
				a = mult / b;
				//이때 a와 b가 서로소이고
				if (get_gcd(a, b) == 1) {
					//현재 sum 보다 a+b가 작다면
					if (sum > a + b) {
						//더 작은 최소 값을 sum으로 한다
						sum = a + b;
						//이때의 a, b는 합의 최소가 되도록 하는 값이다.
						lastA = a;
						lastB = b;
					}
				}
			}
		}
		//합이 최소로 하는 값을 gcd를 각각 곱해준다.
		System.out.println(lastB * gcd + " " + lastA * gcd);
	}

	static int get_gcd(int x, int y) {
		int r;
		while (true) {
			r = x % y;
			if (r == 0) {
				break;
			}
			x = y;
			y = r;
		}
		return y;
	}
}
