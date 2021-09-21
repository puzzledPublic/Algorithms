package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//N번째 큰 수
public class BJ2075 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];	//행렬
		int[] pos = new int[N];	//각 열에 대해 현재 삽입된 숫자 위치
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			pos[i] = N - 1;
		}
		
		for(int i = 0; i < N; i++) {	//맨 마지막 행을 힙에 추가
			pq.add(arr[N - 1][i]);
		}
		
		for(int i = 0; i < N - 1; i++) {	//N - 1번 동안
			int num = pq.poll();	//현재 힙에 제일 큰 수 뽑는다.
			for(int j = 0; j < N; j++) {	//행렬에서 현재 숫자와 같은 곳을 찾아 위치를 위로 옮긴 후 그 숫자를 다시 힙에 추가
				if(arr[pos[j]][j] == num) {
					pos[j]--;
					pq.add(arr[pos[j]][j]);
					break;
				}
			}
		}
		
		bw.write(pq.peek() + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
