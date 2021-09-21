package baekjoon.bj5000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//타임 카드
public class BJ5575 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] times = new int[6];
			for(int j = 0; j < 6; j++) {
				times[j] = Integer.parseInt(st.nextToken());
			}
			int t, m, s;
			if(times[2] <= times[5]) {	//초
				s = times[5] - times[2];
				if(times[1] <= times[4]) {	//분
					m = times[4] - times[1];
				}else {
					m = 60 - times[1] + times[4];
					times[3]--;
				}
				t = times[3] - times[0];	//시
			}else {							//초
				s = 60 - times[2] + times[5];
				times[4]--;
				if(times[1] <= times[4]) {	//분
					m = times[4] - times[1];
				}else {
					m = 60 - times[1] + times[4];
					times[3]--;
				}
				t = times[3] - times[0];	//시
			}
			bw.write(t + " " + m + " " + s + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
