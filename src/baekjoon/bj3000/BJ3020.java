package baekjoon.bj3000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//개똥벌레
public class BJ3020 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		//석순 높이
		int[] stalagmite = new int[H + 1];
		//종유석 높이
		int[] stalactite = new int[H + 1];
		
		for(int i = 0; i < N / 2; i++) {
			int stalagmiteHeight = Integer.parseInt(br.readLine());
			int statactiteHeight = Integer.parseInt(br.readLine());
			stalagmite[stalagmiteHeight]++;
			stalactite[H - statactiteHeight + 1]++;
		}
		
		for(int i = 1; i < H + 1; i++) {	//높이에 따라 충돌하는 횟수를 바로 알기 위해 연속합 계산
			stalagmite[H - i] += stalagmite[H - i + 1]; 
			stalactite[i] += stalactite[i - 1];
		}
		
		//이분탐색 (현재 충돌 횟수(mid)보다 더 낮은 충돌 횟수를 얻을 수 있는가?)
		int start = 0, end = N;
		
		while(start < end) {
			int mid = (start + end) / 2;
			boolean isPossible = false;
			for(int i = 1; i <= H; i++) {	//모든 높이(i)에 대해
				if(stalagmite[i] + stalactite[i] <= mid) {	//i 높이일때 충돌 횟수가 mid 보다 작다면
					isPossible = true;
					break;
				}
			}
			if(isPossible) {	//충돌 횟수를 낮춰본다.
				end = mid;
			}else {	//높여본다.
				start = mid + 1;
			}
		}
		
		int count = 0;
		for(int i = 1; i <= H; i++) {	//최소 충돌 횟수를 얻을 수 있는 높이들의 개수 계산
			if(stalagmite[i] + stalactite[i] == start) {
				count++;
			}
		}
		
		bw.write(start + "\n");
		bw.write(count + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
