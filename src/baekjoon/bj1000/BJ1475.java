package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//방 번호
public class BJ1475 {
	static int[] nums = new int[9];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		solve(s);
	}
	static void solve(String s) {
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) - '0' == 9) {	//6,9는 같다고 친다.
				nums[6]++;
			}else {
				nums[s.charAt(i) - '0']++;
			}
		}
		int max = 0;
		nums[6] = nums[6] / 2 + nums[6] % 2;	//2개가 1셋트에 담기므로 2개씩 짝짓는다.
		for(int i = 0; i < 9; i++) {
			if(max < nums[i]) {
				max = nums[i];
			}
		}
		System.out.println(max);
	}
}
