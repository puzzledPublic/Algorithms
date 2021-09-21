package baekjoon.bj3000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//최종 순위
public class BJ3665 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] in = new int[N + 1];	//각 팀의 indegree를 담을 배열
			int[] temp = new int[N + 1];	//위와 같음
			st = new StringTokenizer(br.readLine(), " ");
			int index = 0;
			for(int j = 0; j < N; j++) {
				index = Integer.parseInt(st.nextToken());
				temp[index] = in[index] = N - j - 1;	//1순위 팀 부터 indegree 계산
			}											//본인 팀 순위 아래의 팀들에서 간선이 들어온다고 볼 수 있다. (ex. 1순위는 2,3,4,5..순위에서 간선이 들어온다, 2순위는 3, 4, 5...순위에서 간선이 들어온다.)
			int M = Integer.parseInt(br.readLine());
			for(int j = 0; j < M; j++) {	//상대적 팀 순위 변동시 방향을 가진 간선들은 반대 방향으로 바뀐다.
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(temp[a] < temp[b]) {	//in 배열 하나로 indegree를 바꾸면 중간에 indegree가 같아지므로 미리 복사한 배열을 바탕으로 비교한다.
					in[a]++;			// 양 팀간 순위가 변하니 indegree도 변동
					in[b]--;
				}else {
					in[a]--;
					in[b]++;
				}
			}
//			System.out.println(Arrays.toString(in));
			int[] result = new int[N + 1];	//결과를 담을 배열
			int count = 0;	//시작점이 있는가? (indegree가 0인 팀이 있는가?)
			boolean flag = false;	//(indegree가 중복되는 팀이 있는가?) 팀들의 순위는 중복되지 않으므로 indegree가 0부터 차례로 1씩 증가 해야 순위가 존재한다.	
			for(int j = 0; j < in.length; j++) {
				result[j] = -1;
			}
			for(int j = 1; j < in.length; j++) {
				if(in[j] == 0) {	//시작점이 존재하면
					count++;
				}
				if(result[in[j]] == -1) {
					result[in[j]] = j;
				}else {	//indegree가 중복되는 팀이 있으면
					flag = true;
				}
			}
			if(count == 1 && !flag) {	//시작점도 있고 indegree가 중복되지 않으면 순위가 존재하므로 출력
				for(int j = in.length - 2; j >= 0; j--) {
					if(j != 0) {
						bw.write(result[j] + " ");
					}else {
						bw.write(result[j] + "");
					}
				}
				bw.write("\n");
			}
//			else if(count == 1 && flag) {	//입력에서 상대적인 순위가 바뀐 모든 팀의 목록이 주어진다고 했으므로 순위가 안 만들어지면 무조건 순위를 정할 수 없다.
//				bw.write("?\n");
//			}
			else {	//그 외 경우 불가능
				bw.write("IMPOSSIBLE\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
