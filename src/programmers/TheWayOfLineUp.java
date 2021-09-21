package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//줄 서는 방법
public class TheWayOfLineUp {
	public static void main(String[] args) {
		int[] n = { 3 };
		int[] k = { 6 };
		for (int i = 0; i < n.length; i++) {
			System.out.println(Arrays.toString(solution(n[i], k[i])));
		}
	}

	static int[] solution(int n, long k) {
		int[] answer = {};
		
		List<Integer> list = new ArrayList<>();
		boolean[] chk = new boolean[n];		//몇번째 숫자를 썼는지 체크할 배열

		long index = facto(--n);	//k위치를 알기위한 구간당 순열 개수
		while(true) {
			if(index == 0) {		//순열이 더이상 없으면 자기 위치다.
				break;
			}
			long t = k % index == 0 ? k / index - 1 : k / index;	//전체 구간에서 상대적 구간 위치

			int g = (int)t;		//아직 안쓰여진 숫자들 중 t번째 숫자가 순열에 들어갈 숫자.
			for(int i = 0; i < chk.length; i++) {
				if(g <= 0 && chk[i] == false) {
					list.add(i + 1);
					chk[i] = true;
					break;
				}
				if(!chk[i]) {
					g--;
				}
			}
			
			k -= (index * t);	//k위치를 구간 내의 위치로 갱신
			index = facto(--n);	//해당 구간에서의 다시 구간당 순열 개수
		}
		for(int i = 0; i < chk.length; i++) {	//마지막으로 안쓰인 숫자를 넣는다.
			if(!chk[i]) {
				list.add(i + 1);
			}
		}
		answer = list.stream().mapToInt((a) -> a).toArray();
		return answer;
	}
	static long facto(long n) {		//n!계산
		return n == 0 ? 0 : n == 1 ? 1 : facto(n - 1) * n;
	}
}
