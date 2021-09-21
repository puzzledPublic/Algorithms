package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//팰린드롬?
public class BJ10942 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		boolean[][] isPalindrom = new boolean[N][N];	//isPalindrom[i][j] = i ~ j까지 수열이 팰린드롬인가?
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			isPalindrom[i][i] = true;	//자기자신은 팰린드롬이다.
		}
		
		for(int i = 1; i < N; i++) {	//s와 e가 i만큼 떨어졌을때 (s,e는 s번째 수부터 e번째 수까지 팰린드롬을 이루는지 여부)
			for(int j = 0; j < N - i; j++) {	//s = j, e = j + i;
				if(arr[j] == arr[j + i]) {	//arr[s] == arr[e]이고
					if(i == 1 || isPalindrom[j + 1][j + i - 1]) {	//isPalindrom[s+1][e-1] = true(s+1 ~ e-1까지 수열이 팰린드롬)이라면 s ~ e까지 수열도 팰린드롬이다.
						isPalindrom[j][j + i] = true;
					}
				}
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken()) - 1, e = Integer.parseInt(st.nextToken()) - 1;
			bw.write(isPalindrom[s][e] ? "1\n" : "0\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
