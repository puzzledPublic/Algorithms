package algorithmsForPS;


//별 그리기 (문제해결을 위한 창의적 알고리즘)
public class AfcDrawStar {
	static StringBuilder str = new StringBuilder();
	public static void main(String[] args) {
		long mid, endTime, startTime = System.currentTimeMillis();
		solve(10);
		endTime = System.currentTimeMillis();
		mid = (endTime- startTime);
		startTime = System.currentTimeMillis();
		solve2(10);
		endTime = System.currentTimeMillis();
		System.out.println("solve1 : " + mid/1000.0);
		System.out.println("solve2 : " + (endTime- startTime)/1000.0);
	}
	//하나 하나 찍는 경우 느리다.
	static void solve(int n){
		
		if(n == 0){
			return;
		}
		solve(n - 1);
		for(int i = 0 ; i < n; i++){
			System.out.print('*');
		}
		System.out.println();
	}
	//문자열로 출력하여 좀 더 빠른 버전.
	static void solve2(int n){
		if(n == 0){
			return;
		}
		solve2(n - 1);
		str.append('*');
		System.out.println(str);
	}
}
