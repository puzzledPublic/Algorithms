package kakao.kakao2018;

import java.util.LinkedList;
import java.util.Queue;
//캐쉬
public class Cache {
	public static void main(String[] args) {
		String[][] strs = {{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}
		,{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}
		,{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}
		,{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}
		,{"Jeju", "Pangyo", "NewYork", "newyork"}
		,{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}};
		
		int cacheSizes[] = {3, 3, 2, 5, 2, 0};
		
		for(int i = 2; i < 3; i++) {
			System.out.println(solve(strs[i], cacheSizes[i]));
		}
	}
	
	static int solve(String[] str, int cacheSize) {
		if(cacheSize == 0) {
			return str.length * 5;
		}
		
		int point = 0;
		Queue<String> cache = new LinkedList<>();
		
		for(String city : str) {
			String currentCity = city.toLowerCase();
			
			if(cache.contains(currentCity)) {
				point++;
				cache.remove(currentCity);
				cache.add(currentCity);
			} else {
				if(cache.size() >= cacheSize) {
					cache.poll();	
				}
				cache.add(currentCity);
				point += 5;
			}
		}
		return point;
	}
}
