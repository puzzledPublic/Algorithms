package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//욱제는 도박쟁이야!
public class BJ14655 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//양 끝 1개, 2개도 뒤집을 수 있으므로 무슨 수열이든 모든 숫자를 양수나 음수로 만들 수 있다.
		//그러므로 구하는 최대 값은 두 라운드 모두 모든 수를 양수로 만들어 더하면 된다.
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		for(int k = 0; k < 2; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				sum += Math.abs(Integer.parseInt(st.nextToken()));
			}
		}
		
		bw.write(sum + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
