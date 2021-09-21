package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//에너지 모으기
public class BJ16198 {
	static int N;
	static int[] arr;
	static boolean[] check;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr = new int[N];
		check = new boolean[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		solve(0, 0);
		
		bw.write(max + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int sum, int count) {
		if(count == N - 2) {	//N - 2개 모두 선택.
			if(max < sum) {	//에너지 총합 갱신.
				max = sum;
			}
			return;
		}
		
		for(int i = 1; i < N - 1; i++) {	//가장 왼쪽, 오른쪽 수를 제외하고 수를 고른다.
			if(!check[i]) {	//아직 안고른 수인 경우
				check[i] = true;
				int t = i, t2 = i;
				while(check[t]) {	//왼쪽의 아직 안 지워진 수 찾기
					t--;
				}
				while(check[t2]) {	//오른쪽의 아직 안 지워진 수 찾기
					t2++;
				}
				solve(sum + (arr[t] * arr[t2]), count + 1);
				check[i] = false;	//백트래킹
			}
		}
	}
}
