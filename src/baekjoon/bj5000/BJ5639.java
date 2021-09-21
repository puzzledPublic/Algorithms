package baekjoon.bj5000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

//이진 검색 트리
public class BJ5639 {
	static List<Integer> preOrder = new ArrayList<>();
	static List<Integer> postOrder = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String num = null;
		
		preOrder = new ArrayList<>();
		while((num = br.readLine()) != null) {
			preOrder.add(Integer.parseInt(num));
		}
		
		solve(0, preOrder.size() - 1);
		
		for(int i : postOrder) {
			bw.write(i + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int left, int right) {	//left위치의 숫자가 루트가 되는 서브트리에서 후위순회
		if(left == right) {	//리프 노드라면 현재 위치 숫자 저장.
			postOrder.add(preOrder.get(left));
			return;
		}
		
		int base = preOrder.get(left);	//left위치의 숫자보다 큰 위치(mid, 오른쪽 서브트리)를 찾는다.
		int mid;
		for(mid = left + 1; mid <= right; mid++) {
			if(base < preOrder.get(mid)) {
				break;
			}
		}
		
		if(left + 1 <= mid - 1) {			
			solve(left + 1, mid - 1);	//left + 1 ~ mid - 1은 왼쪽 서브 트리
		}
		if(mid <= right) {
			solve(mid, right);	//mid ~ right는 오른쪽 서브 트리
		}
		
		postOrder.add(preOrder.get(left));	//후위 순회이므로 루트는 나중에 저장.
	}
}