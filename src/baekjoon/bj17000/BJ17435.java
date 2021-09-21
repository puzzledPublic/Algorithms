package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//합성함수와 쿼리
public class BJ17435 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int M = Integer.parseInt(br.readLine());
		int[][] parent = new int[M + 1][20];	//500,000이므로 2^19 = 524,288 정도면 모두 담을 수 있다.
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= M; i++) {
			parent[i][0] = Integer.parseInt(st.nextToken());
		}
		
		//sparse table 만들기
		//parent[i][j] = f(i)를 2^j번 합성했을때 얻는 수.
		for(int j = 0; j < 19; j++) {
			for(int i = 1; i <= M; i++) {
				parent[i][j + 1] = parent[parent[i][j]][j];
			}
		}
		
		int Q = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			
			//f(X)를 N번 합성했을때 얻는 수를 알려면 N을 2진수로 봤을때
			//예를들어 N = 11이라면 2진수는 1011이고 2^0 = 1, 2^1 = 2, 2^3 = 8이다.
			//그래서 f(X)를 N번 합성한 수는 f(X)를 1번 합성한 수를 또 2번 합성한 수에 다시 8번 합성한 수라고 볼 수 있다.
			//이로인해 미리 구해놓은 sparse table로 빠르게 구할 수 있다.
			for(int j = 0; N > 0; j++) {
				if(N % 2 > 0) {
					X = parent[X][j];
				}
				N /= 2;
			}
			bw.write(X + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
