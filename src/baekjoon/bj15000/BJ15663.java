package baekjoon.bj15000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.StringTokenizer;

//N과 M (9)
public class BJ15663 {
	static int N, M;	//N개중 M개를 고르기 (숫자가 중복되어 주어질 수 있으며, 중복되는 수열은 출력하면 안된다.)
	static int[] nums, result;	//nums = 입력 숫자들, result = 만들어진 수열
	static boolean[] chk;	//nums의 i번째 숫자가 쓰였는지 여부
	static boolean[][] already;	//i번째 순서에서 j 숫자가 이미 쓰였는지 여부
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		chk = new boolean[N];
		nums = new int[N];
		result = new int[M];
		already = new boolean[M][10001];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);	//증가하는 순서로 출력해야하므로 정렬
		solve(0, bw);
		
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(int m, Writer w) throws IOException {
		if(m == M) {	//M개를 골랐으면 출력
			for(int i = 0; i < M; i++) {
				w.write(result[i] + " ");
			}
			w.write("\n");
			return;
		}
		for(int i = 0; i < N; i++) {
			if(!chk[i] && !already[m][nums[i]]) {	//i번째 숫자가 안쓰였고, m번째 단계에서 nums[i]가 쓰이지 않았다면 해당 숫자를 골라도 된다.
				result[m] = nums[i];
				already[m][nums[i]] = true;
				chk[i] = true;
				solve(m + 1, w);
				chk[i] = false;
			}
		}
		Arrays.fill(already[m], false);		//m번째 단계를 벗어날때 체크해놓은 체크배열을 원상복구한다.
	}
}
