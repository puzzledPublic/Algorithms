package baekjoon.bj3000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//영화 수집
public class BJ3653 {
	static int[] segTree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			segTree = new int[(N + M) * 4];
			//dvd를 위로 쌓는데 비어진 공간을 채우기보다 그냥 냅둔다고 생각하자.
			//그렇다면 어떤 dvd 위치보다 위에 있는 dvd들의 개수를 세그먼트 트리로 구할 수 있다.
			//M번을 더 위로 쌓을 수 있으므로 N + M개의 공간이 필요하다.
			//어떤 dvd 위치가 k라면 k+1 ~ N+M 사이의 dvd 개수를 세면 되는것이다.
			//어떤 dvd를 상단에 올리면 그 위치에 update를 하고 현재 위치도 update를 하면 되겠다.
			
			int[] position = new int[N + 1];
			for(int i = 1; i <= N; i++) {
				position[i] = N - i + 1;	//i번 dvd는 처음에 N - i + 1위치에 존재한다.
				update(1, 1, N + M, i, 1);	//세그먼트 트리 초기화, 1부터 N까지 dvd가 존재. (초기상태)
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[M + 1];
			for(int i = 1; i <= M; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int top = N;	//현재 맨 위에 있는 dvd 위치
			
			for(int i = 1; i <= M; i++) {
				bw.write(query(1, 1, N + M, position[arr[i]] + 1, N + M) + " ");	//arr[i]번 dvd 위치보다 위에 있는 dvd 개수를 구한다.
				update(1, 1, N + M, position[arr[i]], 0);	//현재 dvd 위치에 dvd 없음으로 표시
				position[arr[i]] = ++top;	//맨 위 dvd위치 증가.
				update(1, 1, N + M, position[arr[i]], 1);	//올린 dvd 위치에 dvd 있음으로 표시
			}
			
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int query(int index, int left, int right, int qLeft, int qRight) {
		if(right < qLeft || left > qRight) {
			return 0;
		}
		if(qLeft <= left && right <= qRight) {
			return segTree[index];
		}
		int mid = (left + right) / 2;
		return query(index * 2, left, mid, qLeft, qRight) + query(index * 2 + 1, mid + 1, right, qLeft, qRight);
	}
	
	static int update(int index, int left, int right, int valueIndex, int value) {
		if(left == right && left == valueIndex) {
			return segTree[index] = value;
		}
		if(valueIndex < left || valueIndex > right) {
			return segTree[index];
		}
		int mid = (left + right) / 2;
		return segTree[index] = update(index * 2, left, mid, valueIndex, value) + update(index * 2 + 1, mid + 1, right, valueIndex, value);
	}
}
