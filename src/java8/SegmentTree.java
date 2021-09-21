package java8;

//세그먼트 트리 (RMQ)
public class SegmentTree {
	
	int[] segmentArr;	//세그먼트 트리
	int length;	//데이터 배열의 길이
	
	public SegmentTree(int[] arr, int n) {
		segmentArr = new int[n * 4];	//넉넉하게 원 배열 길이의 4배로 잡는다. (원래는 n이 2의제곱꼴이면 2n-1개, 2의제곱꼴이 아니라면 2^(logn + 1) - 1개가된다)
		this.length = n;
		init(arr, 0, n - 1, 1);	//(segmentArr의 시작 인덱스는 1부터)
	}
	
	//초기화
	int init(int[] arr, int left, int right, int node) {
		if(left == right) {
			return segmentArr[node] = arr[left];
		}
		int mid = (left + right) / 2;
		return segmentArr[node] = Math.min(init(arr, left, mid, node * 2), init(arr, mid + 1, right, node * 2 + 1));
	}
	
	//쿼리 (left, right -> 구하고자하는 범위, nodeLeft, nodeRight -> 현재 탐색 범위)
	private int query(int left, int right, int node, int nodeLeft, int nodeRight) {
		if(left > nodeRight || right < nodeLeft) {	//구하고자 하는 범위와 현재 탐색 범위가 겹치지 않는경우 더 탐색할 필요없음. (구할 수 없음)
			return 987654321;
		}
		if(left <= nodeLeft && right >= nodeRight) {	//구하고자 하는 범위가 현재 탐색 범위를 포함한다면 더 탐색할 필요 없음. (현재 위치 노드값을 반환)
			return this.segmentArr[node];
		}
		//그 외의 경우 탐색 범위를 반으로 나눠 다시 탐색
		int mid = (nodeLeft + nodeRight) / 2;
		return Math.min(query(left, right, node * 2, nodeLeft, mid), query(left, right, node * 2 + 1, mid + 1, nodeRight));
	}
	
	int query(int left, int right) {
		return this.query(left, right, 1, 0, this.length - 1);
	}
	
	//갱신	(index -> 값을 바꾸기 위한 배열상의 위치, value -> 바꾸려는 값, nodeLeft, nodeRight -> 현재 탐색 범위)
	private int update(int index, int value, int node, int nodeLeft, int nodeRight) {
		if(index < nodeLeft || index > nodeRight) {	//현재 범위에 포함이 되지 않으면 바로 리턴
			return this.segmentArr[node];
		}
		if(nodeLeft == nodeRight) {	//리프노트까지 가서 값 변경
			return this.segmentArr[node] = value;
		}
		//반으로 나눠 탐색 (여기서는 RMQ(최소값 세그먼트 트리이므로 리프를 변경하고 되돌아 오면서 최소 값들을 갱신한다.)
		int mid = (nodeLeft + nodeRight) / 2;
		return this.segmentArr[node] = Math.min(update(index, value, node * 2, nodeLeft, mid), update(index, value, node * 2 + 1, mid + 1, nodeRight));
		
	}
	
	int update(int index, int value) {
		return update(index, value, 1, 0, this.length - 1);
	}
	
	public static void main(String[] args) {
		int[] arr = {5, 3, 7, 9, 6, 4, 1, 2, 1};
		SegmentTree st = new SegmentTree(arr, arr.length);
	}
}
