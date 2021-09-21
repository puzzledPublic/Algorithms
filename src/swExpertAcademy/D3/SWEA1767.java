package swExpertAcademy.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//[SW TEST 샘플문제] 프로세서 연결하기
public class SWEA1767 {
	static int[][] mexinos = new int[12][12];	//맥시노스
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static List<int[]> processors;	//전선을 놓을 프로세서 위치들
	static int N, maxProcessor, maxLength;	//N = 맥시노스 크기, maxProcessor = 연결 가능한 가장 많은 프로세서 수, maxLength = maxProcessor개의 프로세서를 연결할때 가장 짧은 전선 길이
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int k = 1; k <= T; k++) {
			N = Integer.parseInt(br.readLine().trim());
			maxProcessor = maxLength = 0;
			processors = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					mexinos[i][j] = Integer.parseInt(st.nextToken());
					if(mexinos[i][j] == 1 && (i != 0) && (j != 0) && (i != N - 1) && (j != N - 1)) {	//외곽을 제외하고 프로세서의 위치 저장
						processors.add(new int[]{i, j});
					}
				}
			}
			
			solve(0, 0, 0);
			bw.write("#" + k + " " + maxLength + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(int n, int processor, int length) {	//dfs	각 프로세서에 대해 사방으로 전선을 놓아본다.
		if(N - n + processor < maxProcessor) {
			return;
		}
		
		if(n == processors.size()) {	//모든 프로세서를 훑으면
			if(maxProcessor == processor && maxLength > length) {	//현재 연결 가능한 가장 많은 프로세서 수와 같고 전선 길이가 더 짧다면 전선 길이 갱신
				maxLength = length;
			}else if(maxProcessor < processor) {	//만일
				maxProcessor = processor;
				maxLength = length;
			}
			return;
		}
		
		int x = processors.get(n)[0];	//프로세서 현재 위치
		int y = processors.get(n)[1];
		for(int i = 0; i < d.length; i++) {
			boolean isPossible = true;	//전선을 놓을 수 있는가?
			int nx = x + d[i][0], ny = y + d[i][1];
			while((0 <= nx && nx < N) && (0 <= ny && ny < N)) {	//놓으려는 방향으로 전선이나 프로세서가 존재하는지 검사.
				if(mexinos[nx][ny] != 0) {	//전선을 못 놓는다면
					isPossible = false;	//플래그 설정
					break;
				}
				nx += d[i][0];
				ny += d[i][1];
			}
			if(isPossible) {	//전선을 놓을 수 있다면
				int count = 0;
				nx = x + d[i][0];
				ny = y + d[i][1];
				while((0 <= nx && nx < N) && (0 <= ny && ny < N)) {	//전선을 놓는다.
					count++;
					mexinos[nx][ny] = 2;	//전선 놓는것을 2로 표시하자.
					nx += d[i][0];
					ny += d[i][1];
				}
				solve(n + 1, processor + 1, length + count);	//다음 프로세서로
				nx = x + d[i][0];
				ny = y + d[i][1];
				while((0 <= nx && nx < N) && (0 <= ny && ny < N)) {	//백트래킹. 전선을 제거한다.
					mexinos[nx][ny] = 0;
					nx += d[i][0];
					ny += d[i][1];
				}
			}else {				//전선을 놓을 수가 없다면
				solve(n + 1, processor, length);	//현재 프로세서는 고르지 않는다.
			}
		}
	}
}
