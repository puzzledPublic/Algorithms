package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//너의 이름은
public class BJ14653 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		boolean[] arr = new boolean[26];
		int[] reader = new int[K];	//i메시지를 안읽은 사람 수
		char[] sender = new char[K];	//i메시지를 보낸 사람
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			reader[i] = Integer.parseInt(st.nextToken());
			sender[i] = st.nextToken().charAt(0);
		}
		
		arr[0] = true;	//'A'는 모든 메시지를 본다.
		for(int i = 0; i < K; i++) {
			if(reader[Q - 1] <= reader[i]) {	//Q번째 메시지 이후 메시지를 보낸사람들, Q번째 이전의 메시지를 안읽은 사람 수가 Q번째 메시지를 안읽은 사람 수와 같은 경우.
				arr[sender[i] - 'A'] = true;
			}
		}
		
		if(reader[Q - 1] > 0) {	//Q번째 메시지를 안읽은 사람이 1명 이상이면 가능한 사람 출력
			for(int i = 0; i < N; i++) {
				if(!arr[i]) {
					bw.write((char)('A' + i) + " "); 
				}
			}
		}else {
			bw.write("-1\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
