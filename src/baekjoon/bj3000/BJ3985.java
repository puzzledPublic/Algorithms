package baekjoon.bj3000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//롤 케이크
public class BJ3985 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int L = Integer.parseInt(br.readLine());
		int[] cake = new int[L + 1];	//케이크 조각에 쓰인 번호들을 나타내는 배열
		
		int N = Integer.parseInt(br.readLine());
		int[] count = new int[N + 1];	//방청객이 케이크를 몇 조각 얻는지 나타내는 배열
		
		int before = -1, after = -1;	//가장 많이 받을것으로 기대되는 방청객 번호, 실제 가장 많이 받는 방청객 번호
		int max = -1;
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if(max < e - s + 1) {	//가장 많이 받을것으로 기대되는 방청객 번호 알아내기
				max = e - s + 1;
				before = i;
			}
			for(int j = s; j <= e; j++) {	//s~e 구간을 체크
				if(cake[j] == 0) {	//선점 되지않았다면 체크 
					cake[j] = i; 
					count[i]++;	//i번째 방청객이 얻는 케이크 조각 개수 증가
				}
			}
		}
		
		max = -1;
		for(int i = 1; i <= N; i++) {	//실제 케이크 조각을 가장 많이 받는 방청객 알아내기
			if(max < count[i]) {
				max = count[i];
				after = i;
			}
		}
		
		bw.write(before + "\n" + after);
		
		bw.flush();
		bw.close();
		br.close();
	}
}
