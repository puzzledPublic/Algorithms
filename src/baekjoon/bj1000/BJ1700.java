package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//멀티탭 스케줄링 (그리디)
public class BJ1700 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

		List<Integer> list = new ArrayList<>(N);	//멀티탭
		int[] usageOrder = new int[K];				//사용순서
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < K; i++) {
			usageOrder[i] = Integer.parseInt(st.nextToken());
		}
		
		int index = 0;
		while(list.size() < N && index < usageOrder.length) {	//사용 순서를 돌며 남는 멀티탭만큼 꽂는다. 이미 꽂혀있는 경우와 (남는 플러그 > 사용량)인 경우도 주의.
			if(!list.contains((Integer)usageOrder[index])) {
				list.add(usageOrder[index]);
			}
			index++;
		}

		int count = 0;
		for(int i = index; i < usageOrder.length; i++) {	//다 꽂고 난뒤 사용순서대로 계산.
			if(list.size() < N && !list.contains((Integer)usageOrder[i])) {	//아직 플러그가 다 안꽂혀있으면 더 꽂는다.
				list.add(usageOrder[i]);
			}
			else if(!list.contains((Integer)usageOrder[i])) {	//플러그가 다 사용 중이고 사용하려는 job이 플러그에 안 꽂혀 있으면
				int[] nextStep = new int[list.size()];			//현재 사용하려는 job에서 이후에 플러그에 꽂혀있는 job이 제일 처음 나오는 거리
				for(int j = 0; j < list.size(); j++) {
					nextStep[j] = 101;
					int step = 0;
					for(int k = i + 1; k < usageOrder.length; k++) {	//현재 사용하려는 job 이후에 플러그에 꽂혀있는 job이 나오는 거리를 계산.
						if(list.get(j) == usageOrder[k]) {
							nextStep[j] = step;
							break;
						}
						step++;
					}
				}
				
				int maxIndex = 0, maxStep = nextStep[0];	//제일 늦게 나오는 job을 찾는다. (그리디)
				for(int j = 1; j < list.size(); j++) {
					if(maxStep < nextStep[j]) {
						maxIndex = j;
						maxStep = nextStep[j];
					}
				}
				list.remove(maxIndex);		//제일 늦게 나오는 job을 빼고 사용하려는 job을 플러그에 꽂는다.
				list.add(usageOrder[i]);
				count++;	//플러그를 뺐으므로 횟수증가.
			}
		}
		bw.write(count + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
