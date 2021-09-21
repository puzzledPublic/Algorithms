package java8;

import java.util.Arrays;

public class Quantization {
	final static int INF = 99999999;
	static int A[] = {1,744,755,4,897,902,890,6,777};
	static int pSum[] = new int[100];
	static int pSqSum[] = new int[100];
	static int cache[][] = new int[100][100];

	public static void main(String args[]) {
		//-1로 캐시 초기화
		for(int i = 0; i < cache.length; i++){
			Arrays.fill(cache[i], -1);
		}
		//양자화 하기 위한 준비
		precalc();
		System.out.println(quantize(0, 3));
	}
	
	static void precalc() {
		// 양자화할 숫자들을 정렬
		Arrays.sort(A);

		// 부분합들을 계산 해 놓는다
		pSum[0] = A[0];
		pSqSum[0] = A[0] * A[0];
		for (int i = 1; i < A.length; i++) {
			pSum[i] = pSum[i - 1] + A[i];
			pSqSum[i] = pSqSum[i - 1] + (A[i] * A[i]);
		}
	}

	// 해당 부분의 최소 제곱 오차값들의 합을 구한다
	static int minError(int lo, int hi) {
		// A[]들의 부분 합
		int sum = pSum[hi] - (lo == 0 ? 0 : pSum[lo - 1]);
		// A[]^2들의 부분 합
		int sqSum = pSqSum[hi] - (lo == 0 ? 0 : pSqSum[lo - 1]);
		// 평균 값
		int m = (int) (0.5 + (double) sum / (hi - lo + 1));
		// 부분 제곱 오차값들의 합 = A[]^2 - 2 * A[] + (hi - lo + 1) * m * m(m:평균값)
		int ret = sqSum - 2 * m * sum + (hi - lo + 1) * m * m;
		return ret;
	}

	static int quantize(int from, int parts) {
		if (from == A.length) {
			return 0;
		}
		if (parts == 0) {
			return INF;
		}
		if (cache[from][parts] != -1) {
			return cache[from][parts];
		}

		int ret = INF;
		for (int partSize = 1; from + partSize <= A.length; partSize++) {
			ret = Math.min(
					ret,
					minError(from, from + partSize - 1)
							+ quantize(from + partSize, parts - 1));
		}
		return ret;
	}
}
