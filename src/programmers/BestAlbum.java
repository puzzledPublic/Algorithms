package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//베스트 앨범
public class BestAlbum {
	static class Music {
		int index, listenAmount;
		public Music(int index, int listenAmount) {
			this.index = index;
			this.listenAmount = listenAmount;
		}
	}
	static class MusicInfo {
		int total;
		PriorityQueue<Music> pq = new PriorityQueue<>((a, b) -> b.listenAmount - a.listenAmount);
		public MusicInfo(int total, Music music) {
			this.total = total;
			pq.add(music);
		}
	}
	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		
		System.out.println(Arrays.toString(solution(genres, plays)));
	}
	
	static int[] solution(String[] genres, int[] plays) {
        int[] answer;
        Map<String, MusicInfo> map = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
        	if(map.containsKey(genres[i])) {
        		map.get(genres[i]).total += plays[i];
        		map.get(genres[i]).pq.add(new Music(i, plays[i]));
        	}else {
        		map.put(genres[i], new MusicInfo(plays[i] , new Music(i, plays[i])));
        	}
        }
        
        List<MusicInfo> list = new ArrayList<>();
        for(String s : map.keySet()) {
        	list.add(map.get(s));
        }
        
        Collections.sort(list, (a, b) -> b.total - a.total);
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
        	for(int j = 0; j < 2; j++) {
        		Music m = list.get(i).pq.poll();
        		if(m != null) {
        			result.add(m.index);
        		}
        	}
        }
        answer = new int[result.size()];
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = result.get(i);
        }
        return answer;
    }
}
