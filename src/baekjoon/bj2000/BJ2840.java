package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//행운의 바퀴
public class BJ2840 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int c = 0;
		
		char[] arr = new char[N];	//행운의 바퀴
		boolean[] chk = new boolean[26];	//알파벳이 1개 이상 쓰였는지 여부 체크 배열
		for(int i = 0; i < N; i++) {	//행운의 바퀴 '?'로 초기화
			arr[i] = '?';
		}
		
		boolean isLucky = true;
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			char ch = st.nextToken().charAt(0);
			c = (c + r) % N;	//다음 행운의 바퀴 위치.
			//해당 위치가 '?'가 아니면서 이미 쓰여진 알파벳과 다르거나 알파벳이 한번 이상 쓰였다면 행운의 바퀴가 아니다. (같은 위치에 같은 알파벳은 가능함에 주의)
			if((arr[c] != '?' && arr[c] != ch) || (chk[ch - 'A'] && arr[c] != ch)) {
				isLucky = false;
				break;
			}
			chk[ch - 'A'] = true;	//쓰인 알파벳 체크
			arr[c] = ch;	//알파벳을 행운의 바퀴에 쓴다.
		}
		
		if(isLucky) {	//행운의 바퀴라면 시계 순서로 출력.
			for(int i = c; i >= 0; i--) {
				bw.write(arr[i]);
			}
			for(int i = N - 1; i > c; i--) {
				bw.write(arr[i]);
			}
		}else {
			bw.write("!\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
