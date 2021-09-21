package programmers;

//멀쩡한 사각형 (2019 winter coding)
public class FineRectangle {
	public static void main(String[] args) {
		int w = 3;
		int h = 8;
		System.out.println(solution(w, h));
	}
	public static long solution(int w,int h) {
		long answer = (long)w * (long)h;
		long a = w;
		long b = h;
		answer -= (a + b - gcd(a, b));
		return answer;
	}
	public static long gcd(long a, long b) {
		if(b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
}
