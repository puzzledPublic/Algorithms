package algorithmsForPS;

import java.util.Scanner;

//선물(S)
public class AfcPresent {
	static int N;
	static int presents[];
	static int A,B,C;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		N = input.nextInt();
		presents = new int[N];
		for(int i = 0; i < N; i++) {
			presents[i] = input.nextInt();
		}
		//내림차순 정렬
		for(int i = 0 ; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				if(presents[i] < presents[j]) {
					int temp = presents[i];
					presents[i] = presents[j];
					presents[j] = temp;
				}
			}
		}
		solve(0,0,0,0);
		
		System.out.println(A +" " + B + " " + C);
	}
	
	//depth가 15를 넘어서면 time fail
	static void solve(int depth, int a, int b, int c) {
		if(depth < N) {
			solve(depth + 1, a + presents[depth], b, c);	//a가 갖는 경우
			solve(depth + 1, a, b + presents[depth], c);	//b가 갖는 경우
			solve(depth + 1, a, b, c + presents[depth]);	//c가 갖는 경우
		}
		else if(a >= b && b >= c) {	// a>=b>=c 순이어야 함
			A = a;
			B = b;
			C = c;
		}
	}
	
}
