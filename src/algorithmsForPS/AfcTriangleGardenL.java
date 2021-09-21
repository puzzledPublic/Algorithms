package algorithmsForPS;

import java.util.Scanner;

//한 변의 길이가 주어졌을때 만들 수 있는 삼각형 개수
public class AfcTriangleGardenL {
	
	static int N;
	static int count;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		N = input.nextInt();
		solve(N);
	}
	//a <= b <= c 일때 
	//가장 긴 변 c의 조건은 [n/3] <= c < n/2 (n은 2의 배수), [n/3] <= c < [n/2] (그 외)
	//가장 짧은 변 a의 조건은 1<= a < [n/3]을 만족한다.
	static void solve(int n) {
		int b;
		for(int c = n / 3;  c <= n / 2; c++) {
			for(int a = 1; a <= n / 3; a++) {
				b = n - (a + c);
				if(a + b > c && (a <= b && b <= c)) {
					count++;
				}
			}
		}
		System.out.println(count++);
	}
}
