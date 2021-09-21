package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//대회 OR 인턴
public class BJ2875 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		//r = 만들수 있는 최대 팀 수, rest = 최대 팀 수를 만들고 나서 남은 사람들
		int r = Math.min(N / 2, M), rest = (N - r * 2 + M - r);
		//result = 남은 사람들을 인턴쉽을 보내고 더 보내야 한다면 참여 팀 수는 = (3 * r(총 팀원수) - k(남은 인원들을 보낸 후의 K)) / 3이 된다.
		int result = (3 * r - (K < rest ? 0 : K - rest)) / 3;
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
