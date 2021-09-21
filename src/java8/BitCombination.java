package java8;
//비트마스크로 조합만들기
public class BitCombination {
	static char[] arr = {'a', 'b', 'c', 'd'};
	public static void main(String[] args) {

		int n = 4;
		
		for(int i = 0; i < (1 << (n)); i++) {	//0 ~ 2^n - 1까지
			System.out.println(i);
			for(int j = 0; j < n; j++) {	//0 ~ n만큼 1을 쉬프트해서 비트마스크 생성
				if((i & (1 << j)) > 0) {	//숫자 i 각 비트에 1이 있으면 선택됐음을 표시
					System.out.print(arr[j] + " ");
				}
			}
			System.out.println();
		}
//		dfs(0);
	}
	static boolean[] chk = new boolean[4];
	static void dfs(int n) {
		if(n == 4) {
			for(int i = 0; i < 4; i++) {
				if(chk[i]) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		dfs(n + 1);
		chk[n] = true;
		dfs(n + 1);
		chk[n] = false;
	}
}
