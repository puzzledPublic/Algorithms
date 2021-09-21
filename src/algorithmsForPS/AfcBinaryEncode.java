package algorithmsForPS;
//이진 압축
public class AfcBinaryEncode {
	static char[] S;
	public static void main(String[] args) {
		S = "00111101".toCharArray();
		solve(0,S.length);
	}
	//a부터 n길이의 암호화
	static void solve(int a, int n){
		
		if(n == 1){	//길이가 1이면 그 위치의 값 0 or 1 압축 결과 출력
			System.out.print(S[a]);
			return;
		}
		
		int sum = 0;
		
		for(int i = a; i < a + n; i++){	//길이가 1 이상인 경우 모두 1 or 0인지 확인
			sum += (S[i] - '0');
		}
		
		if(sum == 0  || sum == n){	//sum 더한 결과가 0인 경우 모두 0이거나 길이와 같은 경우 모두 1이었음.
			System.out.print(sum > 0 ? "1" : "0");	//해당 값으로 압축 결과 출력
		}
		else{	//모두 동일한 숫자가 아니라면 분할
			System.out.print("-");
			solve(a, n / 2);
			solve(a + n / 2, n / 2);
		}
	}
}
