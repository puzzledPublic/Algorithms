package kakao.kakao2018;

import java.util.HashMap;
import java.util.Map;

//압축
//result = [11, 1, 27, 5]
//[20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
//[1, 2, 27, 29, 28, 31, 30]
public class Compression {
	static String[] str = {
		"KAKAO",
		"TOBEORNOTTOBEORTOBEORNOT",
		"ABABABABABABABAB"
	};
	static int OFFSET = 64;
	static Map<String, Integer> map = new HashMap<>();
	
	public static void main(String[] args) {
		for(int i = 0; i < str.length; i++) {
			map.clear();
			solve(str[i]);
			for(String key : map.keySet()) {
				System.out.print("[" +key + ": " + map.get(key) + "], ");
			}
			System.out.println();
		}
		
	}
	
	static void solve(String msg) {
		int index = 26;
		for(int i = 0; i < msg.length(); i++) {
			if(i == msg.length() - 1) {
				System.out.print((msg.charAt(i) - OFFSET) + " ");
				break;
			}
			
			for(int j = msg.length() - 1; j >= i; j--) {
				if(i == j) {
					System.out.print((msg.charAt(i) - OFFSET) + " ");
					map.put(msg.substring(i, j + 2), ++index);
					break;
				}else {
					String tempMsg = msg.substring(i,  j + 1);
					if(map.containsKey(tempMsg)) {
						System.out.print(map.get(tempMsg) + " ");
						if(j + 2 < msg.length()) {
							map.put(msg.substring(i, j + 2), ++index);
						}
						i += (j - i);
						break;
					}
				}
			}
		}
		
		System.out.println();
	}
}
