package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//이름궁합 테스트
public class BJ17269 {
	static int[] alpha = {3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		String A = st.nextToken();
		String B = st.nextToken();
		
		int[] list = new int[N + M];
		
		int aIndex = 0, bIndex = 0;
		
		int k = 0;
		while(true) {	//번갈아가면서 배치하기
			if(aIndex == N && bIndex == M) {
				break;
			}else if(aIndex < N && bIndex == M) {
				list[k++] = alpha[A.charAt(aIndex++) - 'A'];
			}else if(bIndex < M && aIndex == N) {
				list[k++] = alpha[B.charAt(bIndex++) - 'A'];
			}else {
				list[k++] = alpha[A.charAt(aIndex++) - 'A'];
				list[k++] = alpha[B.charAt(bIndex++) - 'A'];
			}
		}
		
		for(int i = N + M - 1; i > 1; i--) {	//궁합계산
			for(int j = 0; j < i; j++) {
				list[j] = (list[j] + list[j + 1]) % 10;	//10을 넘으면 일의자리만
			}
		}
		
		bw.write((Integer.parseInt(list[0] + "" + list[1])) + "%\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
