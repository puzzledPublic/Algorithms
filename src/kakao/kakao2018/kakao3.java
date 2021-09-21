package kakao.kakao2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//캐시
public class kakao3 {
	
	public static void main(String[] args) {
		String[][] strs = {{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}
		,{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}
		,{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}
		,{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}
		,{"Jeju", "Pangyo", "NewYork", "newyork"}
		,{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}};
		
		int cacheSizes[] = {3, 3, 2, 5, 2, 0};
		
		for(int i = 0; i < strs.length; i++) {
			System.out.println(solution(cacheSizes[i], strs[i]));
		}
	}
	static int solution(int cacheSize, String[] cities){
		int answer = 0;
		List<String> cache = new ArrayList<>();
		int[] lru = new int[cacheSize];
		
		if(cacheSize == 0){
			return cities.length * 5;
		}
		for(int i = 0 ; i < cacheSize; i++){
			lru[i] = cacheSize - i - 1;
		}
		
		for(int i = 0 ; i < cities.length ; i++){
			//적중시
			if(cache.contains(cities[i].toLowerCase())){
				for(int j = 0 ; j < lru.length; j++){
					lru[j]++;
				}
				lru[cache.indexOf(cities[i].toLowerCase())] = 0;
				answer +=1;
			}
			else{
				int max = lru[0];
				int index = 0;
				for(int j = 1; j < lru.length; j++){
					if(max < lru[j]){
						max = lru[j];
						index = j;
					}
				}
				for(int j = 0 ; j < lru.length; j++){
					lru[j]++;
				}
				lru[index] = 0;
				if(cache.size() < cacheSize){
					cache.add(index, cities[i].toLowerCase());
				}
				else{
					cache.set(index, cities[i].toLowerCase());
				}
				answer +=5;

			}
//			for(int j = 0 ; j < cache.size(); j++){
//				System.out.print(cache.get(j)+"("+lru[j]+") ");
//			}
//			System.out.println();
		}
		
		return answer;
	}
}
