package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//서버
public class BJ10409 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), T = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int result = N;		//초기값은 모두 처리한다는 가정하에 N으로한다.
		for(int i = 1; i <= N; i++) {
			if((T -= Integer.parseInt(st.nextToken())) < 0) {	//시간내에 못끝내면 종료
				result = i - 1;
				break;
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
