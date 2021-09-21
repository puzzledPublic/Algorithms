package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//용감한 용사 진수
public class BJ14718 {
	static class Soldier implements Comparable<Soldier>{
		int x, y, z;
		public Soldier(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
		@Override
		public int compareTo(Soldier o) {
			return Integer.compare(this.z, o.z);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Soldier> soldiers = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			soldiers.add(new Soldier(x, y, z));
		}

		Collections.sort(soldiers);	//z에 대해 오름차순 정렬
		
		int result = Integer.MAX_VALUE;
		//x와 y의 조합을 구하고 K명 이상을 이기는 경우 중 가장 낮은 스탯을 갖는 경우를 찾는다.
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int x = soldiers.get(i).x, y = soldiers.get(j).y;	//x, y를 정하고
				int win = 0;
				for(int k = 0; k < N; k++) {
					if(soldiers.get(k).x <= x && soldiers.get(k).y <= y) {	//x, y를 비교하여 이기는 병사 수를 구한다. z의 경우 오름차순이므로 최소화하는 z를 구하게 된다.
						win++;
					}
					if(win == K) {	//K명을 이기는 순간
						if(result > x + y + soldiers.get(k).z) {	//그때의 z를 포함하는 x,y,z의 합들 중 최소값을 찾는다.
							result = x + y + soldiers.get(k).z;
						}
					}
				}
			}
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
