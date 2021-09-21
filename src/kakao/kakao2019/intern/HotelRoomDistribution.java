package kakao.kakao2019.intern;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//호텔 룸 배정
public class HotelRoomDistribution {
	public static void main(String[] args) {
		long k = 10;
		long[] room_number = { 1, 3, 4, 1, 3, 1 };
		
		System.out.println(Arrays.toString(solution(k, room_number)));
	}
	
	//처음 버전..
	static long[] solution(long k, long[] room_number) {
		long[] answer = new long[room_number.length];
		
		Map<Long, Long> map = new HashMap<>();	//<i, j> = i번째 방은 사용 중이고 i번 이상이면서 빈 방 번호는 j?임을 나타낸다.
		
		for(int i = 0; i < room_number.length; i++) {
			if(map.containsKey(room_number[i])) {	//현재 방이 사용중이면
				long root = find(map, room_number[i]);	//다음 방 번호를 구한다.
				map.replace(root, root + 1);	//다음 방 번호 사용 표시.
				if(map.containsKey(root + 2)) {	//다다음 방이 사용 중인 경우 경로를 이어준다.
					map.put(root + 1, root + 2);
				}else {
					map.put(root + 1, root + 1);
				}
				answer[i] = root + 1;
			}else {	//사용 중이 아닌 경우
				if(map.containsKey(room_number[i] - 1)) {	//이전 방번호가 사용중이면 경로를 이어준다.
					map.replace(room_number[i] - 1, room_number[i]);
				}
				if(map.containsKey(room_number[i] + 1)) {	//다음 방번호가 사용중이면 경로를 이어준다.
					map.put(room_number[i], room_number[i] + 1);
				}else {
					map.put(room_number[i], room_number[i]);
				}
				answer[i] = room_number[i];
			}
		}
		
		return answer;
	}
	
	static long find(Map<Long, Long> map, long u) {
		long p = map.get(u);
		if(p == u) {
			return p;
		}
		map.replace(u, find(map, p));
		return map.get(u);
	}
	
	//개선된 버전.
	static long[] solution2(long k, long[] room_number) {
		long[] answer = new long[room_number.length];
		
		Map<Long, Long> map = new HashMap<>();	//<i, j> = i번째 방은 사용 중이고 i번 이상이면서 빈 방 번호는 j임을 나타낸다.
		
		for(int i = 0; i < room_number.length; i++) {
			answer[i] = find2(map, room_number[i]);
		}
		
		return answer;
	}
	
	static long find2(Map<Long, Long> map, long u) {
		if(!map.containsKey(u)) {	//u번 방이 비었다면 u번방 사용표시.
			map.put(u, u + 1);
			return u;
		}
		map.replace(u, find2(map, map.get(u)));	//u번방의 다음 방 번호를 최신 번호로 갱신.
		
		return map.get(u);
	}
	
}
