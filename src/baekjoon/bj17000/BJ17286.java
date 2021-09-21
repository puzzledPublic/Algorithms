package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//유미
public class BJ17286 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[][] order = {
				{0, 1, 2, 3},
				{0, 1, 3, 2},
				{0, 2, 1, 3},
				{0, 2, 3 ,1},
				{0, 3, 1, 2},
				{0, 3, 2, 1}
		};
		int[][] humans = new int[4][2];
		for(int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			humans[i][0] = Integer.parseInt(st.nextToken());
			humans[i][1] = Integer.parseInt(st.nextToken());
		}
		
		double minDist = 987654321.0;
		for(int i = 0; i < order.length; i++) {
			double sumDist = 0;
			for(int j = 1; j < 4; j++) {
				sumDist += getDist(humans, order[i][j - 1], order[i][j]);
			}
			System.out.println();
			if(minDist > sumDist) {
				minDist = sumDist;
			}
		}
		
		bw.write((int)minDist + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	static double getDist(int[][] humans, int u, int v) {
		double a = Math.abs(humans[u][0] - humans[v][0]);
		double b = Math.abs(humans[u][1] - humans[v][1]);
		return Math.sqrt(a * a + b * b);
	}
}
