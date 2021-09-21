package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//케이크 자르기 (이분탐색)
public class BJ17179 {
	static int N, M, L;
	static int[] cutPoint;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		cutPoint = new int[M];
		for(int i = 0; i < M; i++) {
			cutPoint[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i < N; i++) {
			int count = Integer.parseInt(br.readLine());
			
			int l = 0, r = L;
			while(l + 1 < r) {
				int mid = (l + r) / 2;
				if(isPossible(count, mid)) {
					l = mid;
				}else {
					r = mid;
				}
			}
			
			bw.write(l + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static boolean isPossible(int count, int base) {	//케이크를 잘랐을때 조각의 최소길이가 base이상이며 자른 횟수가 count 이상일 수 있는가?
		int cutCount = 0;
		int next = 0; //이전에 자른 위치
		
		for(int i = 0; i < cutPoint.length; i++) {
			if(cutPoint[i] - next < base || L - cutPoint[i] < base) {	//잘랐을때 좌, 우의 잘린 케이크 길이가 base 이상이어야 한다.
				continue;
			}
//			System.out.println((cutPoint[i] - next) + " " + (L - next));
			next = cutPoint[i];
			cutCount++;
		}
//		System.out.println(" " + base + " " + count + " " + cutCount);
		return count <= cutCount;
	}
}
