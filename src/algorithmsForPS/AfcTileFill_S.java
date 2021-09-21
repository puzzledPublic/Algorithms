package algorithmsForPS;

//2xn 타일 채우기 (문제해결을 위한 창의적 알고리즘)
//1<= n <= 100,000 1<= m <= 40,000
//경우의 수를 m으로 나눈 나머지를 출력
public class AfcTileFill_S {
	static int m = 100;
	public static void main(String[] args) {
		int n = 50000;
		//System.out.println(solve(n));
		//System.out.println(solve2(n));
		System.out.println(solve3(n));
	}
	//입력이 커지면 계산이 많아짐
	static int solve(int n){
		if(n <= 1){
			return 1 % m;
		}
		return (solve(n - 1) + 2 * solve(n - 2)) % m;
	}
	//개량 버전. n이 짝수인 경우, n이 홀수인 경우로 나누어 계산
	static int solve2(int n){
		if(n <= 1){
			return 1 % m;
		}
		else if(n % 2 == 0){
			return ((int)Math.pow(solve2(n / 2), 2) + 2 * (int)Math.pow(solve2(n / 2 - 1), 2)) % m;
		}
		else{
			return (solve2(n - 1) + 2 * solve2(n - 2)) % m;
		}
	}
	//n이 홀수인 경우를 개량한 버전.
	static long solve3(int n){
		if(n <= 1){
			return 1 % m;
		}
		else if(n % 2 == 0){
			return ((int)Math.pow(solve3(n / 2), 2) + 2 * (int)Math.pow(solve3(n / 2 - 1), 2)) % m;
		}
		else{
			return (solve3(n / 2) * solve3(n / 2 + 1) + 2 * (solve3(n / 2 - 1) * solve3(n / 2))) % m;
		}
	}
}
