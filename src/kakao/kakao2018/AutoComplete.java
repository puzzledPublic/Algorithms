package kakao.kakao2018;

//자동완성
public class AutoComplete {
	static String[][] words= {
		{"go", "gone", "guild"},
		{"abc", "def", "ghi", "jklm"},
		{"word", "war", "warrior", "world"}
	};
	//트라이
	static class Trie {
		Trie[] tries = new Trie[26];
		boolean terminal;
		int visited = 0;	//접두어 구분하기 위한 변수, 두번째 방문시에 1로 만듬 (이것이 0이라면 이후에 검색할 필요가 없음)
		
		//삽입 함수
		public void insert(String key) {	//재귀와 substring 함수덕에 입력이 커지면 메모리 사용량 증가 + 시간초과.. 그래서 반복문으로 풀고 인덱스로 옮기며 검사
			/*if(key.isEmpty()) {
				terminal = true;
				return;
			}
			int number = toNumber(key.charAt(0));
			if(tries[number] == null) {
				tries[number] = new Trie();
			}else {
				tries[number].visited = 1;
			}
			tries[number].insert(key.substring(1));*/
			
			int index = 0;
			Trie trie;
			if(this.tries[toNumber(key.charAt(index))] == null) {
				trie = this.tries[toNumber(key.charAt(index))] = new Trie();
			}else {
				trie = this.tries[toNumber(key.charAt(index))];
				trie.visited = 1;
			}
			index++;
			while(index < key.length()) {
				int next = toNumber(key.charAt(index));
				if(trie.tries[next] == null) {
					trie.tries[next] = new Trie();
				}else {
					trie.tries[next].visited = 1;
				}
				trie = trie.tries[next];
				index++;
			}
		}
		
		//해당 검색시 사용하는 단어 횟수 구하는 함수
		public int calcSearchTime(String key) {
			/*if(key.isEmpty() || this.visited == 0) {
				return 0;
			}
			System.out.print(key.charAt(0) + " ");
			int next = toNumber(key.charAt(0));
			if(tries[next] == null) {
				return 0;
			}
			return tries[next].calcSearchTime(key.substring(1)) + 1;*/
			
			int i = 1, index = 0;
			Trie trie = this.tries[toNumber(key.charAt(index))];
			index++;
			while(index < key.length()) {
				int next = toNumber(key.charAt(index));
				if(trie.visited == 0) {
					break;
				}
				i++;
				trie = trie.tries[next]; 
				index++;
			}
			return i;
		}
		
		public int toNumber(char c) {
			return c - 'a';
		}
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < words.length; i++) {
			solve(words[i]);
		}
	}
	
	static void solve(String[] word) {
		Trie trie = new Trie();
		trie.visited = -1;
		for(int i = 0; i < word.length; i++) {
			trie.insert(word[i]);
		}
		int result = 0;
		for(int i = 0; i < word.length; i++) {
			int temp = trie.calcSearchTime(word[i]);
//			System.out.println();
			result += temp;
		}
		System.out.println(result);
	}
}
