package baekjoon.bj4000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//개미 (그리디)
public class BJ4037 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine()), len, N, earlyMax, lateMax, early = 0, late = 0, ant;
		StringTokenizer st;
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			len = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			earlyMax = 0;	//중간 변수 초기화 할것!
			lateMax = 0;
			//개미가 떨어지는 '최소' 시간은 각 개미 위치에서 가장 '빠르게' 떨어지는 시간들 중에 '최대' 값.
			//개미가 떨어지는 '최대' 시간은 각 개미 위치에서 가장 '늦게' 떨어지는 시간들 중에 '최대' 값.
			for(int j = 0; j < N; j++) {	
				ant = Integer.parseInt(br.readLine());	//개미 위치
				earlyMax = Math.max(earlyMax, Math.min(ant, len - ant));	//왼쪽, 오른쪽으로 움직여 막대기 끝까지 갈때의 '최소값'을 구해 그 중 '최대값' 유지
				lateMax = Math.max(lateMax, Math.max(ant, len - ant));		//왼쪽, 오른쪽으로 움직여 막대기 끝까지 갈때의 '최대값'을 구해 그 중 '최대값' 유지
//				if(ant < len - ant) {
//					early = ant;
//					late = len - ant;
//				}else {
//					early = len - ant;
//					late = ant;
//				}
//				if(earlyMax < early) {
//					earlyMax = early;
//				}
//				if(lateMax < late) {
//					lateMax = late;
//				}
			}
			bw.write(earlyMax + " " + lateMax + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
