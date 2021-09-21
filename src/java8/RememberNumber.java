package java8;

import java.util.Arrays;

//원주율 외우기 (종만북)
public class RememberNumber {
	static int cache[] = new int[1000];
	static String N = "43211234453463454353234";
	final static int INF = 999999999;
	public static void main(String args[]) {
		
		Arrays.fill(cache, -1);
		System.out.println("난이도: "+ memorize(0));
	}

	static int memorize(int begin) {
		if (begin == N.length()) {
			return 0;
		}
		if (cache[begin] != -1) {
			return cache[begin];
		}

		int ret = INF;
		
		for (int i = 3; i <= 5; i++) {
			if (begin + i <= N.length()) {
				ret = Math.min(ret, memorize(begin + i) + classify(begin, begin + i));
			}
		}
		return ret;

	}

	static int classify(int a, int b) {
		String m = N.substring(a,b);//(a, b - a + 1);
		// 모든 원소가 같을때 난이도 1
		if (isAllSame(m)) {
			return 1;
		}

		// 숫자가 증가하거나 감소 할 때
		boolean progressive = true;
		for (int i = 0; i < m.length() - 1; i++) {
			if (m.charAt(i + 1) - m.charAt(i) != m.charAt(1) - m.charAt(0)) {
				progressive = false;
			}
		}
		// 숫자가 1씩 증가하거나 감소 할 때 난이도 2
		if (progressive && Math.abs(m.charAt(1) - m.charAt(0)) == 1) {
			return 2;
		}
		// 두 수가 번갈아 나타날 때 난이도 4
		boolean alternating = true;
		for (int i = 0; i < m.length(); i++) {
			if (m.charAt(i) != m.charAt(i % 2)) {
				alternating = false;
			}
		}
		if (alternating) {
			return 4;
		}
		// 공차가 1이 아닌 등차 수열일 때 난이도 5
		if (progressive) {
			return 5;
		}
		// 아무것도 아니라면 난이도 10
		return 10;

	}

	static boolean isAllSame(String m) {
		for (int i = 0; i < m.length(); i++) {
			if (m.charAt(0) != m.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}
