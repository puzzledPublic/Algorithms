package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//부등호	(그리디, 위상정렬)
public class BJ2529 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int K = Integer.parseInt(br.readLine());
		int[][] result = new int[K + 1][2];		//result[0~k+1][0] = max값을 이루는 숫자들 , result[0~k+1][1] = min값을 이루는 숫자들
		int[][] indegree = new int[K + 1][2];	//indegree[i][1] = 부등호로 그래프를 만들었을때 정점i의 진입차수, indegree[i][0] = 그래프를 반대로 만들었을때 진입차수.
		int[][] startNum = {{9, -1}, {0, 1}};	//startNum[0][0] = max값을 구하기 위해 시작하는 숫자, startNum[0][1] = min값을 구하기 위해 시작하는 숫자
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < K; i++) {
			if(st.nextToken().equals("<")) {	// '<'일때 i -> i+1로의 간선이 있다고 하자.
				indegree[i][0]++;
				indegree[i + 1][1]++;
			}else {								// '>'일때 i+1 -> i로의 간선이 있다고 하자.
				indegree[i + 1][0]++;
				indegree[i][1]++;
			}
		}
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();	//최소 또는 최대의 결과를 구해야 하므로 왼쪽(0 -> k+1)부터 최소 또는 최대숫자가 되게끔 우선순위큐를 사용한다(그리디)
		for(int i = 0; i < 2; i++) {	//i = 0일때 최대값 구하기, i = 1일때 최소값 구하기
			
			for(int j = 0; j < K + 1; j++) {	//진입차수가 0인 정점들로 큐를 초기화한다.
				if(indegree[j][i] == 0) {
					pq.add(j);
				}
			}
			
			//위상정렬 시작.
			while(!pq.isEmpty()) {
				int index = pq.poll();
				result[index][i] = startNum[i][0];	//현재 큐에서 뽑은 정점에 숫자를 부여한다.
				startNum[i][0] += startNum[i][1];
				
				//현재 정점하고 연결된 정점은 index-1 또는 index+1밖에 없으므로 두개 정점을 조사해 간선을 없앤다.
				if(index - 1 >= 0)	{	//범위 검사.
					if(indegree[index - 1][i] == 1) {	//진입차수가 0이되면 큐에 넣는다.
						pq.add(index - 1);
					}
					indegree[index - 1][i]--;
				}
				if(index + 1 < K + 1) {
					if(indegree[index + 1][i] == 1) {
						pq.add(index + 1);
					}
					indegree[index + 1][i]--;
				}
			}
			
			for(int j = 0; j < K + 1; j++) {	//결과값 출력
				bw.write(result[j][i] + "");
			}
			bw.write("\n");
			
			pq.clear();	//다음 계산을 위해 큐 초기화
		}		
		bw.flush();
		bw.close();
		br.close();
	}
}
