package programmers;

//3 x N 타일링
public class Tiling3XN {
	public static void main(String[] args) {
		
		int[] input = {5000};
		for(int in : input) {
			System.out.println(solution(in));
		}
	}
	static int solution(int n) {
	     int answer = 0;
	     long[] arr = new long[n + 1];
	     //홀수인 경우는 칸수가 홀수개가 되므로 채울 수가 없다.
	     arr[0] = 1;	//3x0을 채우는 경우 1개.
	     arr[2] = 3;	//3x2를 채우는 경우 3개.
	     for(int i = 4; i < n + 1; i += 2) {
	         arr[i] = 3 *  arr[i - 2];	//[i - 2]에서 3x2블록을 채워 arr[i]가 될 수 있는데 각 블록당 3개씩 연결될 수 있으므로 arr[i-2] * 3이 된다.
	         for(int j = i - 4; j >= 0; j -= 2) {	//거기에 더해 i(i >= 4)가 2씩 증가할때마다 새로운 블록 2개가 더 추가된다. 이 경우의 수도 계산하려면 이전의 arr[i - 4,6,8.. = 0] * 2를 더해줘야한다.
	             arr[i] += (2 * arr[j]);
	         }
	         arr[i] %= 1_000_000_007;
	     }
	     return answer = (int)arr[n];
	}
}
