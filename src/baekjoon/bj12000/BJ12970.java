package baekjoon.bj12000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//AB
public class BJ12970 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int A, B;
		if(N % 2 == 0) {	//N을 각 A, B 반 씩 나눈다.
			A = B = N / 2;
		}else {
			A = N / 2 + 1;
			B = N / 2;
		}
		
		if(A * B < K) {	//A * B가 최대 짝의 개수다. 이를 넘어가는 문자열은 조건을 만족하지 못한다.
			bw.write("-1\n");
		}else {
			List<Integer> list = new ArrayList<>();
			for(int i = 0; i < B; i++) {	//B개수의 숫자들의 합으로 K를 만들 수 있어야한다. 그리디하게 분배 해 준다. 이때 각 숫자의 범위는 0 ~ A다.
				if(K >= A) {
					list.add(A);
					K -= A;
				}else {
					list.add(K);
					K -= K;
				}
			}
			//숫자 리스트를 기반으로 오름차순으로 돌며 문자열을 만든다.
			//예를들면 N = 10, K = 12라면 A=5, B=5이고 숫자 리스트는 [5, 5, 2, 0, 0]이 된다.
			//오름차순이므로 뒤에서부터 보자. 각 숫자는 B가 있을때 왼쪽에 A의 개수를 나타낸다.
			//0은 B의 왼쪽에는 A가 0개여야 하므로 B가 먼저 쓰인다.
			//이런 방식으로 쭉 문자열을 만들면 BBAABAAABB가 된다.
			StringBuilder sb = new StringBuilder();
			int countA = 0;
			for(int i = list.size() - 1; i >= 0; i--) {
				if(list.get(i) > countA) {
					while(countA != list.get(i)) {
						sb.append('A');
						countA++;
					}
					sb.append('B');
				}else {
					sb.append('B');
				}
			}
			while(sb.length() < N) {
				sb.append('A');
			}
			bw.write(sb.toString() + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
