package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//앉았다
public class BJ14717 {
	static int score;
	static int count = 0;
	static int[] arr;
	static int[] temp = new int[2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int p1 = Integer.parseInt(st.nextToken());
		int p2 = Integer.parseInt(st.nextToken());
		
		if(p1 == p2) {	//카드1과 카드2의 숫자가 같으면 이기는 경우의 수를 바로 알 수 있다.
			System.out.printf("%.3f\n", ((double)(153 - (10 - p1)) / 153d));
		}else {
			arr = new int[11];
			for(int i = 1; i <= 10; i++) {	//모든 카드는 2장씩
				arr[i] = 2;
			}
			arr[p1]--;	//내가 뽑은 카드가 있으므로 하나씩 뺀다.
			arr[p2]--;
			score = (p1 + p2) % 10;	//내가 뽑은 카드의 점수
			solve(1, 0);
			System.out.printf("%.3f\n" ,((double)count / 153d));
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int next, int n) {	//나머지 카드 18개 중 2개를 고르는 경우
		if(n == 2) {
			if((temp[0] + temp[1]) % 10 < score) {	//자신이 뽑은 카드의 점수보다 낮은 경우, 경우의 수 증가.
				count += (arr[temp[0]] * arr[temp[1]]);	//똑같은 카드가 2장씩 있으므로 가능한 경우의 수는 카드1(temp[2])의 개수 * 카드2(temp[1])의 개수
			}	
			return;
		}
		
		for(int i = next; i <= 10; i++) {	//동일한 카드는 제거하고 항상 오름차순으로 뽑도록 한다.
			temp[n] = i;
			solve(i + 1, n + 1);
		}
	}
}