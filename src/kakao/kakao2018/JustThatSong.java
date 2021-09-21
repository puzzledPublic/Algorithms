package kakao.kakao2018;

import java.util.LinkedHashMap;
import java.util.Map;
//방금그곡
public class JustThatSong {
	/*static String[] ms = {	//네오가 들은 음악 중간 혹은 전체 내용 (i = 입력 순서)
		"ABCDEFG",
		"CC#BCC#BCC#BCC#B",
		"ABC"
	};
	static String[][][] timetables = { //음악의 시작, 끝난 시간 (i = 입력 순서, j = 음악의 순서, k = 0 ->시작 시간 or 1 -> 끝난 시간)
		{
			{"12:00", "12:14"}, 
			{"13:00", "13:05"}
		},
		{
			{"03:00", "03:30"}, 
			{"04:00", "04:08"}
		},
		{
			{"12:04", "12:14"},
			{"13:00", "13:05"}
		}
	};
	static String[][] musicNames = { //음악 제목 (i = 입력 순서, j = 음악 제목의 순서)
		{"HELLO", "WORLD"},
		{"FOO", "BAR"},
		{"HELLO", "WORLD"}
	};
	static String[][] musics = {	//음악 (각 음당 재생 1분 소요) (i = 입력 순서, j = 음악의 순서)
		{"CDEFGAB", "ABCDEF"},
		{"CC#B", "CC#BCC#BCC#B"},
		{"C#DEFGAB", "ABCEDF"}
	};*/
	static class MusicInfo {
		String musicName;
		int playedTime;
		public MusicInfo(String musicName, int playedTime) {
			this.musicName = musicName;
			this.playedTime = playedTime;
		}
	}
	public static void main(String[] args) {
//		for(int i = 0; i < ms.length; i++) {
//			solve(ms[i], timetables[i], musicNames[i], musics[i]);
//		}
		String[] heardMusic = {
			"ABCDEFG",
			"CC#BCC#BCC#BCC#B"
		};
		String[][] musicinfos = {
			{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"},
			{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}
		};
		for(int i = 0; i < heardMusic.length; i++) {
			System.out.println(solve2(heardMusic[i], musicinfos[i]));
		}
	}
	//실제버전
	static String solve2(String m, String[] musicinfos) {
		
		String transformedM = transformSharp(m);
		
		String[][] parsedMusiinfos = new String[musicinfos.length][4];
		for(int i = 0; i < musicinfos.length; i++) {
			String[] tmp = musicinfos[i].split(",");
			for(int j = 0; j < 4; j++) {
				parsedMusiinfos[i][j] = tmp[j];
			}
		}
		
		String[] transformedMusic = new String[musicinfos.length];
		for(int i = 0; i < transformedMusic.length; i++) {
			transformedMusic[i] = transformSharp(parsedMusiinfos[i][3]);
		}
		
		Map<String, MusicInfo> playedMusics = new LinkedHashMap<>();
		
		for(int i = 0; i < parsedMusiinfos.length; i++) {
			int time = betweenTime(parsedMusiinfos[i][0], parsedMusiinfos[i][1]);
			StringBuilder playedMusic = new StringBuilder();
			if(time <= transformedMusic[i].length()) {
				playedMusic.append(transformedMusic[i].substring(0, time));
			}else {
				for(int j = 0; j < time / transformedMusic[i].length(); j++) {
					playedMusic.append(transformedMusic[i]);
				}
				playedMusic.append(transformedMusic[i].substring(0, time % transformedMusic[i].length()));
			}
			playedMusics.put(playedMusic.toString(), new MusicInfo(parsedMusiinfos[i][2], time));
		}
		int longestPlayedTime = 0;
		String answer = "(None)";
		for(String key : playedMusics.keySet()) {
			if(key.contains(transformedM)) {
				int playedTime = playedMusics.get(key).playedTime;
				if(longestPlayedTime < playedTime) {
					longestPlayedTime = playedTime;
					answer = playedMusics.get(key).musicName;
				}
			}
		}
		return answer;
	}
	
	/*static void solve(String m, String[][] timetable, String[] musicName, String[] music) {
		//모든 #을 가진 음을 소문자로 대체한다.
		String transformedM = transformSharp(m);
		String[] transformedMusic = new String[music.length];
		
		for(int i = 0; i < music.length; i++) {
			transformedMusic[i] = transformSharp(music[i]);
		}
		
		//시간에 따라 재생된 음들을 담을 map (삽입 순서가 보장돼야한다. 출력시 같은 음을 포함하고, 재생된 시간도 같을 경우 먼저 재생된 음악 제목을 출력해야 하므로.)
		Map<String, String> playedMusics = new LinkedHashMap<>();
		
		for(int i = 0; i < timetable.length; i++) {
			int time = betweenTime(timetable[i][0], timetable[i][1]);	//각 음악 재생시간
			String playedMusic = "";	//재생한 시간이 음악 재생 시간에 비해 엄청 길 경우 (StringBuilder를 사용하는 것이 효율적일듯)
			if(time <= transformedMusic[i].length()) {	//재생한 시간 <= 음악 재생 시간인 경우
				playedMusic = transformedMusic[i].substring(0, time); 
			} else {	//재생한 시간 > 음악 재생 시간인 경우
				int addCount = time / transformedMusic[i].length();
				for(int j = 0; j < addCount; j++) {
					playedMusic += transformedMusic[i];
				}
				playedMusic += transformedMusic[i].substring(0, (time % transformedMusic[i].length()));
			}
			playedMusics.put(playedMusic, musicName[i]);	//재생된 음들과 해당하는 음악 제목 추가
		}
		
		int longestPlayedTime = 0; //네오가 기억하는 음을 포함하는 음악 중에서 가장 긴 재생 시간을 가지는 음악
		String result = "(None)";
		
		for(String key: playedMusics.keySet()) {
			if(key.contains(transformedM)) {
				int playedTime = playedMusics.get(key).length();
				if(longestPlayedTime < playedTime) {
					longestPlayedTime = playedTime;
					result = playedMusics.get(key);
				}
			}
		}
		
		System.out.println(result);
	}*/
	//#을 가진 음을 소문자로 처리 (ex C# -> c, D# -> d ...)
	static String transformSharp(String m) {
		StringBuilder sb = new StringBuilder();
		char current, next;
		int length = m.length();
		for(int i = 0; i < length - 1; i++) {
			current = m.charAt(i);
			next = m.charAt(i + 1);
			if(next == '#') {
				sb.append((char)(current + 32));
				i++;
			}else {
				sb.append(current);
			}
		}
		char last = m.charAt(length - 1);
		if(last != '#') {
			sb.append(last);
		}
		return sb.toString();
	}
	//시작 시간, 끝난 시간의 차이를 구하는 함수(분)
	static int betweenTime(String start, String end) {
		String[] splitedStart = start.split(":");
		String[] splitedEnd = end.split(":");
		return (Integer.parseInt(splitedEnd[0]) * 60 + Integer.parseInt(splitedEnd[1])) - (Integer.parseInt(splitedStart[0]) * 60 + Integer.parseInt(splitedStart[1]));
	}
	
}
