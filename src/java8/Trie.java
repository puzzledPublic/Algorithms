package java8;

import java.util.LinkedList;
import java.util.Queue;

//문자열을 트리로 구성하는 트라이 자료구조
public class Trie {
	
	Trie[] children = new Trie[26];
	
	boolean terminal;
	
	static Queue<Trie> queue = new LinkedList<Trie>();
	
	public static void main(String[] args) {
		Trie t = new Trie();
		
		t.insert("HELLO");
		t.insert("HIGHT");
	}
	
	public void insert(String key) {
		if(key.isEmpty()) {
			terminal = true;
			return;
		}
		int next = toNumber(key.charAt(0));
		if(children[next] == null) {
			children[next] = new Trie();
		}
		children[next].insert(key.substring(1));
	}
	
	public boolean find(String key) {
		if(key.isEmpty()) {
			return true;
		}
		int next = toNumber(key.charAt(0));
		if(children[next] == null) {
			return false;
		}
		return children[next].find(key.substring(1));
	}
	
	private int toNumber(char ch) {
		return ch - 'A';
	}
}
