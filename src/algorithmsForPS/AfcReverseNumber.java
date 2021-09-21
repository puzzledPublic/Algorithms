package algorithmsForPS;

//숫자 뒤집기 - (문제해결을 위한 창의적 알고리즘)
public class AfcReverseNumber {
	static int first = 1;
	static int cache[] = new int[50001];
	public static void main(String[] args) {
		
		solve(12300700);
		System.out.println();
		System.out.println(solve2(12300700));
		System.out.println(solve3(12300700));
		System.out.println(solve4(12301));
		System.out.println(solve5(12301));
	}
	
	//기본적으로 생각할 수 있는 재귀
	static void solve(int n){
		if(n == 0){
			return;
		}
		if(first == 1 && n%10 == 0){
			solve(n/10);
		}else{
			System.out.print(n%10);
			first = 0;
			solve(n/10);
		}
	}
	//마지막 수를 분리하고 나머지 수를 다음으로 넘김
	static int solve2(int n){
		if(n < 10){
			return n;
		}
		return solve2(n/10) + (n % 10) * (int)Math.pow(10.0, (int)Math.log10(n));
	}
	
	//solve2 개량버전 (첫자리 수, 마지막 수를 분리하고 나머지 가운데 수를 다음으로 넘김)
	static int solve3(int n){
		if(n < 10){
			return n;
		}
		int T = (int)Math.pow(10,(int)Math.log10(n));
		return (n % 10) * T + 10 * solve3((n % T) / 10) + n / T;
	}
	
	//상향식 접근 방법(bottom-up) 
	static int solve4(int n) {
		if(n > 50001) {
			return -1;
		}
		int dt[] = new int[50001];
		for(int i = 1; i <= n; i++) {
			if(i < 10) {
				dt[i] = i;
			}
			else {
				dt[i] = dt[i / 10] + (i % 10) * (int)Math.pow(10.0, (int)Math.log10(i));
			}
		}
		
		return dt[n];
	}
	
	//하향식 접근 방법(top-down)
	static int solve5(int n) {
		if(n < 10) {
			return n;
		}
		
		if(cache[n] != -1) {
			cache[n] = solve5(n / 10) + (n % 10) * (int)Math.pow(10.0, (int)Math.log10(n));
		}
		
		return cache[n];
	}
}
