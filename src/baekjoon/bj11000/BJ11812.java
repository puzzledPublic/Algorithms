package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//K진 트리
public class BJ11812 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long N = Long.parseLong(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			long X = Long.parseLong(st.nextToken());
			long Y = Long.parseLong(st.nextToken());
			
			if(K == 1) {	//K가 1일때는 연결리스트 꼴이므로 두 정점간 거리를 바로 구할 수 있다.
				bw.write(Math.abs(X - Y) + "\n");
			} else {	//그 외의 경우
				long count = 0;
				while(X != Y) {	//같은 부모 정점이 될 때까지
					if(X < Y) {	//X > Y가 되도록 만든다.
						long temp = X;
						X = Y;
						Y = temp;
					}
					
					//하나의 정점은 K개의 자식을 갖는다. 최상위 부모의 번호를 1부터 매기면 어떤 정점 N의 자식 번호들은 K*N-(K-2) ~ K*N+1이다.
					//그러므로 어떤 정점 번호 N의 부모 정점 번호는 N/K (0<= N%K <=1), N/K+1 (2 <= N%K)가 된다.
					long d = X % K;	// N%K
					X /= K;	// N/K
					if(d >= 2) {	//나머지가 2보다 크면 1증가.
						X++;
					}
					
					count++;	//거리증가
				}
				bw.write(count + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
