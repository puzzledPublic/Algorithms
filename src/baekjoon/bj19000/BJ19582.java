package baekjoon.bj19000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//200년간 폐관수련했더니 PS 최강자가 된 건에 대하여
public class BJ19582 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		int max = 0;
		int failIndex = -1;
		for(int i = 0; i < N; i++) {	//순서대로 시뮬레이션하며 못들어가는 시합이 있는지 검사.
			if(arr[i][0] < sum) {
				failIndex = i;
				break;
			}
			sum += arr[i][1];
			max = Math.max(max, arr[i][1]);	//지금까지 한 시합 중 제일 많이 받는 돈
		}
		
		if(failIndex == -1) {	//모든 시합에 나갈 수 있으면 종료
			bw.write("Kkeo-eok\n");
		}else {
			//순서대로 시뮬레이션하다가 못들어가는 시합이 존재하면 2가지 경우가 존재한다.
			//다음 시합을 안나가는 경우, 이전 시합 중 돈을 가장 많이 받는 시합을 나가지 않는 경우
			//두 경우를 가정해서 시뮬레이션시 둘 중 하나라도 가능하면 최소 N - 1개 시합에 출전 가능하다.
			boolean isPossible = true;
			int tSum = sum;
			for(int i = failIndex + 1; i < N; i++) {	//다음 시합을 무시하고 다다음 시합부터 시뮬레이션.
				if(arr[i][0] < tSum) {
					isPossible = false;
					break;
				}
				tSum += arr[i][1];
			}
			
			if(!isPossible) {	//위의 경우가 불가능하면 다음 경우를 해본다.
				isPossible = true;
				sum -= max;	//지금까지 한 시합 중 가장 돈을 많이 받는 시합을 뺀다.
				for(int i = failIndex; i < N; i++) {	//시뮬레이션.
					if(arr[i][0] < sum) {
						isPossible = false;
						break;
					}
					sum += arr[i][1];
				}
				
				if(isPossible) {
					bw.write("Kkeo-eok\n");
				}else {
					bw.write("Zzz\n");
				}
			}else {
				bw.write("Kkeo-eok\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
