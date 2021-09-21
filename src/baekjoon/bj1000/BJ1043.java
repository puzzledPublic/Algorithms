package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//거짓말
public class BJ1043 {
	static int[] parent;	//find - union을 위한 배열
	static boolean[] truthPeople;	//진실을 들어야하는 사람들
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int[N + 1];
		truthPeople = new boolean[N + 1];
		for(int i = 1; i < N + 1; i++) {
			parent[i] = i;
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int amount = Integer.parseInt(st.nextToken());
		int[] peopleWhoKnowTruth = new int[amount];	//진실을 아는 사람들
		for(int i = 0; i < amount; i++) {
			peopleWhoKnowTruth[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] party = new int[M][];	//각 파티에 참여하는 사람들
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int people = Integer.parseInt(st.nextToken());
			party[i] = new int[people];
			for(int j = 0; j < people; j++) {
				party[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//각 파티에 참여하는 사람들은 모두 진실 또는 거짓을 듣게 되고 또한 한 사람이 여러 파티에 참가하는 경우 진실, 거짓 둘 다 들으면 안된다. 
		//한 파티에 참여하는 사람들을 하나의 집합으로 묶는다.
		for(int i = 0; i < M; i++) {
			for(int j = 1; j < party[i].length; j++) {
				union(party[i][j - 1], party[i][j]);
			}
		}
		
		//진실을 아는 사람이 속한 집합은 무조건 진실만을 들어야 한다.
		for(int i = 0; i < amount; i++) {
			int root = find(peopleWhoKnowTruth[i]);
			truthPeople[root] = true;	//집합의 루트에 진실을 듣는 집합임을 표시
		}
		
		int count = 0;
		for(int i = 0; i < M; i++) {
			boolean canLie = true;
			for(int j = 0; j < party[i].length; j++) {	//각 파티에서 진실을 아는 사람이 있거나 진실을 아는 사람이 속한 집합에 있는 사람인 경우 거짓말을 해야한다.
				if(truthPeople[find(party[i][j])]) {	//해당 사람이 속한 집합이 진실을 듣는 집합이라면 거짓말을 할 수 없다.
					canLie = false;
					break;
				}
			}
			if(canLie) {
				count++;
			}
		}
		
		bw.write(count + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int find(int u) {
		if(u == parent[u]) {
			return u;
		}
		return parent[u] = find(parent[u]);
	}
	
	static void union(int u, int v) {
		u = find(u);
		v = find(v);
		if(u == v) {
			return;
		}
		parent[u] = v;
	}
}
