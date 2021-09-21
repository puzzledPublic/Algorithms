package programmers;
//N개의 최소공배수
public class NsLCM {
	public static void main(String[] args) {
		int[][] arr = {
				{2, 6, 8, 14},
				{1, 2, 3},
				{3}
		};
		for(int i = 0; i < arr.length; i++) {
			System.out.println(solution(arr[i]));
		}
	}
	
	static int solution(int[] arr) {
	      int answer = 0;
	      int lcm = arr[0];
	      for(int i = 1; i < arr.length; i++) {
	    	  lcm = (lcm * arr[i]) / gcd(lcm, arr[i]);
	      }
	      return answer = lcm;
	}
	
	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
}
