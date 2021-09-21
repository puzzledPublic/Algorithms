package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//숫자 야구
public class BJ2503 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] ans = new int[N][5];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			for(int j = 2; j >= 0; j--) {
				ans[i][j] = num % 10;
				num /= 10;
			}
			ans[i][3] = Integer.parseInt(st.nextToken());
			ans[i][4] = Integer.parseInt(st.nextToken());
		}
		int result = 0;
		for(int i = 123; i <= 987; i++) {	//3가지 서로 다른 숫자이므로 브루트포스.
			if(isPossible(i, ans)) {
				result++;
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static boolean isPossible(int number, int[][] ans) {
		int[] num = new int[3];
		for(int i = 2; i >= 0; i--) {
			num[i] = number % 10;
			if(num[i] == 0) {	//숫자에 0이 들어간 경우
				return false;
			}
			number /= 10;
		}
		if(num[0] == num[1] || num[0] == num[2] || num[1] == num[2]) {	//같은 숫자가 있는 경우
			return false;
		}
		for(int i = 0; i < ans.length; i++) {
			int strike = 0, ball = 0;
			for(int j = 0; j < 3; j++) {
				for(int k = 0; k < 3; k++) {
					if(j != k && num[j] == ans[i][k]) {	//위치가 다르고 숫자가 같으면 볼
						ball++;
					}else if(j == k && num[j] == ans[i][k]) {	//위치가 같고 숫자가 같으면 스트라이크
						strike++;
					}
				}
			}
			if(strike != ans[i][3] || ball != ans[i][4]) {	//답과 다르면 후보 가능성 없음.
				return false;
			}
		}
		return true;
	}
}
