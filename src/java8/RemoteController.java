package java8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//리모컨(문제해결을 위한 창의적 알고리즘(중급))
public class RemoteController {
	// 리모컨 누르는 횟수가 무제한으로 걸릴수 있기에(ex:+1,-1,+1,-1...) 제한을 위한 제한횟수를 나타내는 변수?
	static int limit = 40;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int p, q, cnt = 0;
		p = input.nextInt();
		q = input.nextInt();

		//find(p, 0, q);
		//System.out.println(limit);
		
		find2(p,q);
	}
	//깊이우선탐색
	private static void find(int p, int cnt, int q) {
		if (cnt > limit) {
			return;
		}
		if (p == q) {
			if (cnt < limit) {
				limit = cnt;
			}
			return;
		}
		if (p < cnt) {
			find(p + 1, cnt + 1, q);
			find(p + 5, cnt + 1, q);
			find(p + 10, cnt + 1, q);
		} else {
			find(p - 1, cnt + 1, q);
			find(p - 5, cnt + 1, q);
			find(p - 10, cnt + 1, q);
		}
	}
	//너비우선탐색
	private static void find2(int p, int q) {
		Queue<Remote> queue = new LinkedList<Remote>();
		Remote remote = new Remote(p, 0);
		queue.add(remote);
		while (!queue.isEmpty()) {
			remote = queue.remove();
			if (remote.current == q) {
				
				break;
			}
			if (remote.current < q) {
				queue.add(new Remote(remote.current + 1, remote.cnt + 1));
				queue.add(new Remote(remote.current + 5, remote.cnt + 1));
				queue.add(new Remote(remote.current + 10, remote.cnt + 1));
			}
			else {
				queue.add(new Remote(remote.current-1,remote.cnt+1));
				queue.add(new Remote(remote.current-5,remote.cnt+1));
				queue.add(new Remote(remote.current-10,remote.cnt+1));
			}
		}
		System.out.println(remote.cnt);
	}
}

class Remote {

	int current;
	int cnt;

	Remote(int current, int cnt) {
		this.current = current;
		this.cnt = cnt;

	}
}
