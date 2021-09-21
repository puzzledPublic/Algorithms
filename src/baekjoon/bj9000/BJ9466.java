package baekjoon.bj9000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//텀 프로젝트
public class BJ9466 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[N + 1];
			int[] chk = new int[N + 1];
			for(int j = 1; j <= N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			int count = 0;
			for(int j = 1; j <= N; j++) {	//모든 정점을 탐색
				if(chk[j] == 0) {			//아직 탐색안한 정점이면 탐색시작.
					int next = arr[j];		//다음 학생.
					chk[j] = j;				//현재 정점으로 시작하는 경로를 현재 정점 번호로 매긴다.
					count++;
					while(chk[next] == 0) {	//쭉 따라간다. (모든 학생이 한 학생을 지목하므로 사이클은 반드시 존재한다)
						chk[next] = j;		//경로 매기기.
						next = arr[next];
						count++;
					}
					if(chk[next] == j) {	//사이클이 존재한다면(현재 정점 번호로 하는 경로가 다시 나타나면)
						chk[next] = -1;		//사이클이 시작되는 정점을 시작으로 다시 사이클을 돌며 경로를 -1로 매긴다.
						next = arr[next];
						count--;
						while(chk[next] != -1) {
							chk[next] = -1;
							next = arr[next];
							count--;
						}
					}
				}
			}
//			중간 count연산이 없을시 사용한 답 구하기.
//			for(int j = 1; j <= N; j++) {
//				if(chk[j] != -1) {
//					count++;
//				}
//			}
			bw.write(count + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
