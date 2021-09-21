package java8;

import java.util.ArrayList;
import java.util.List;

//여행 짐 싸기 문제
public class Packing {
	
	static String[] str = {"laptop","camera","xbox","grinder","dumbell","encyclopedia"};
	static int volume[] = {4,2,6,4,2,10};
	static int need[] = {4,10,6,7,5,4};
	static int capacity = 27;
	static int items = 6;
	static int cache[][] = new int[1001][100];
	static List<String> picked = new ArrayList<String>();
	
	public static void main(String[] args) {
		for(int i = 0 ; i < cache.length; i++){
			for(int j = 0 ; j < cache[0].length; j++){
				cache[i][j] = -1;
			}
		}
		System.out.println(solution(capacity, 0));
		reconstruct(capacity, 0, picked);
		for(String str : picked){
			System.out.println(str);
		}
	}
	static int solution(int capacity, int item){
		
		if(item == items){	//모두 탐색했으면 리턴
			return 0;
		}
		if(cache[capacity][item] != -1){	//메모이제이션
			return cache[capacity][item];
		}
		int ret = 0;
		if(capacity >= volume[item]){	// 배낭에 여유가 되는 경우
			//아이템을 포함 하는 경우 또는 포함하지 않는 경우 중 최대값
			cache[capacity][item] = ret = Math.max(solution(capacity, item + 1), solution(capacity - volume[item], item + 1) + need[item]);
		}
		
		return ret;
	}
	//배낭 아이템 리스트 저장하는 함수
	static void reconstruct(int capacity, int item, List<String> picked){
		if(item == items){
			return;
		}
		if(solution(capacity, item) == solution(capacity, item + 1)){
			reconstruct(capacity, item + 1, picked);
		}
		else{
			picked.add(str[item]);
			reconstruct(capacity - volume[item], item + 1, picked);
		}
	}
}
