package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

//달리기
public class BJ2517 {
	static class Pair {
		int first, second;
		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
	static int[] segTree;
	static List<Pair> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		segTree = new int[N * 4];
		int[] arr = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			int skill = Integer.parseInt(br.readLine());
			arr[i] = skill;
			list.add(new Pair(0, skill));
		}
		
		list.sort((a, b) -> a.second - b.second);	//좌표 압축을 위해 실력 순으로 정렬
		for(int i = 0; i < list.size(); i++) {	//실력 순으로 1부터 매긴다.
			list.get(i).first = i + 1;
		}
		//현재 내 순위보다 윗 순위에 있는 사람들 중 내 실력보다 낮은 실력의 사람 수를 구해야한다.
		//실력 크기가 10억으로 높고 사람 수는 50만으로 작으니 좌표 압축한다.
		//좌표 압축된 것으로 세그먼트 트리를 이용해 일정 범위의 실력을 가진 사람 수를 (구간 합) 빠르게 구하도록 한다.
		for(int i = 1; i <= N; i++) {
			int index = binarySearch(arr[i]);	//입력된 실력에 맞는 좌표압축된 수를 구한다.
			int count = query(1, 1, N, 1, list.get(index).first - 1);	//나의 실력보다 낮은 실력의 사람이 몇명 있는지 구한다.
			update(1, list.get(index).first, 1, N);	//내 실력의 개수를 증가시킨다.
			bw.write((i - count) + "\n"); //가능한 최고 순위.
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int binarySearch(int skill) {
		int start = 0, end = list.size() - 1;
		while(start < end) {
			int mid = (start + end) / 2;
			int s = list.get(mid).second;
			if(s == skill) {
				return mid;
			}else if(s > skill) {
				end = mid;
			}else {
				start = mid + 1;
			}
		}
		return start;
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
	
	static int update(int index, int valueIndex, int left, int right) {
		if(left == right && left == valueIndex) {
			return segTree[index] += 1;
		}
		if(valueIndex < left || valueIndex > right) {
			return segTree[index];
		}
		int mid = (left + right) / 2;
		return segTree[index] = update(index * 2, valueIndex, left, mid) + update(index * 2 + 1, valueIndex, mid + 1, right);
	}
}
