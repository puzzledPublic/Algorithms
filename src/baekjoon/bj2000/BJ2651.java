package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//자동차 경주대회
public class BJ2651 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int distance = Integer.parseInt(br.readLine());
		int centerAmount = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] dist = new int[centerAmount + 2];	//0 ~ i번째 정비소까지의 거리 (누적합)
		int[] center = new int[centerAmount + 2];	//i번째 정비소의 정비시간
		int[] dp = new int[centerAmount + 2];	//dp[i] = i번째 정비소에 들릴때 지금까지의 최소 정비시간
		int[] dpR = new int[centerAmount + 2];	//정비소 번호를 백트래킹을 위한 배열
		
		for(int i = 1; i <= centerAmount + 1; i++) {
			dist[i] += (dist[i - 1] + Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i < centerAmount + 1; i++) {
			center[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < centerAmount + 2; i++) {
			dp[i] = 987654321;
		}
		
		
		for(int i = 1; i < centerAmount + 2; i++) {
			for(int j = i - 1; j >= 0; j--) {
				if(dist[i] - dist[j] <= distance) {	//i번째에 정비소에 도착하려면 거리가 distance 이하인 정비소나 출발지여야 한다.
					if(dp[i] > dp[j] + center[i]) {	//i번째 정비소에 올 수 있는 정비소나 출발지 중 최소 정비시간 + i번째 정비소 정비시간
						dp[i] = dp[j] + center[i];
						dpR[i] = j;	//j 정비소에서 i정비소로 왔음을 표시
					}
				}
			}
		}
		
		//정비시간을 최소로 하는 정비소 번호들.
		List<Integer> list = new ArrayList<>();
		int next = dpR[centerAmount + 1];
		while(next != 0) {
			list.add(next);
			next = dpR[next];
		}
		
		if(!list.isEmpty()) {	//정비소를 들리는 경우 출력
			bw.write(dp[centerAmount + 1] + "\n");
			bw.write(list.size() + "\n");
			for(int i = list.size() - 1; i >= 0; i--) {
				bw.write(list.get(i) + " ");
			}
		}else {	//안들려도 되는 경우 출력
			bw.write("0\n0");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}