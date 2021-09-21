package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.StringTokenizer;

//이전 순열
public class BJ10973 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] seq = new int[N + 1];
		boolean[] check = new boolean[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i < N + 1; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		solve(N, seq, check, bw);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int N, int[] seq, boolean[] check, Writer w) throws IOException {
		
		int index = N;
		while(index > 0 && seq[index] > seq[index - 1]) {	//순열의 끝에서 부터 내림차순이 아닌 곳을 찾는다.
			index--;
		}
		
		if(index == 0) {	//내림차순이면 제일 첫 순열이므로 -1을 출력
			w.write("-1\n");
			return;
		}
		
		index--;
		for(int i = 1; i < index; i++) {	//순열에 처음 부터 구한 index까지는 그대로 출력하며 사용했다는 표시를 한다.
			w.write(seq[i] + " ");
			check[seq[i]] = true;
		}
		
		for(int i = seq[index] - 1; i > 0; i--) {	//현재 순열에서 index 위치의 값보다 작은 값중 사용하지 않은 최대 값을 출력
			if(!check[i]) {
				w.write(i + " ");
				check[i] = true;
				break;
			}
		}
		
		for(int i = N; i > 0; i--) {	//나머지 순열은 사용하지 않은 숫자들을 모두 내림차순으로 출력
			if(!check[i]) {
				w.write(i + " "); 
			}
		}
	}
}