package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//반복수열
public class BJ2331 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		int count = 1;
		Map<Integer, Integer> map = new HashMap<>();	//<수열 숫자, 인덱스>
		
		while(true) {
			if(map.containsKey(A)) {	//해당 숫자가 존재하면 사이클의 시작.
				bw.write((map.get(A).intValue() - 1) + "\n");
				break;
			}else {	//그 외의 경우 수열을 넣어준다.
				map.put(A, count++);
			}
			
			int T = 0;	//수열 생성
			while(A > 0) {
				int T2 = (A % 10);
				int T3 = 1;
				for(int j = 0; j < P; j++) {
					T3 *= T2;
				}
				T += T3;
				A /= 10;
			}
			A = T;
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
