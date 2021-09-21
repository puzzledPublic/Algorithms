package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//오일러 서킷(모든 정점을 한번씩만 지나 자기 자신으로 오는 경로) 
//(모든 정점이 가진 간선 수가 짝수개여야한다)
public class EulerianCircuit {
	// a b c d e f g h
	static int[][] graphMatrix = { { 0, 1, 0, 0, 1, 0, 0, 0 },
			{ 1, 0, 1, 0, 0, 0, 0, 0 }, { 0, 1, 0, 1, 0, 0, 0, 0 },
			{ 0, 0, 1, 0, 1, 1, 0, 1 }, { 1, 0, 0, 1, 0, 0, 0, 0 },
			{ 0, 0, 0, 1, 0, 0, 1, 0 }, { 0, 0, 0, 0, 0, 1, 0, 1 },
			{ 0, 0, 0, 1, 0, 0, 1, 0 } };

	

	public static void main(String[] args) {
		//서킷을 담을 리스트
		List<Integer> circuit = new ArrayList<Integer>();
		
		//오일러서킷 시작
		findRandomCircuit(0, circuit);
		//서킷을 뒤집는다
		Collections.reverse(circuit);
		
		//출력
		for (int i : circuit) {
			System.out.print((char)(i+'A')+" ");
		}
	}

	private static void findRandomCircuit(int here, List<Integer> circuit) {
		//현재 정점에서 주변 정점을 탐색하며 
		for (int i = 0; i < graphMatrix.length; i++) {
			//간선이 존재하면
			while (graphMatrix[here][i] > 0) {
				//간선을 지우고(다시 못돌아오도록)
				graphMatrix[here][i]--;
				graphMatrix[i][here]--;
				//다음 정점으로 이동
				findRandomCircuit(i, circuit);
			}
		}
		//역행하며 오일러 서킷을 만듬
		circuit.add(here);
	}
}
