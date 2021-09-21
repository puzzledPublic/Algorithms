package java8;


//find - union
public class DisjointSet {
	
	static int[] parent = new int[10];
	static int[] rank = new int[10];
	
	public static void main(String[] args) {
		
		for(int i = 0 ; i < parent.length; i++) {
			parent[i] = i;
		}
		
		union(0,1);
		union(1,2);
		union(3,4);
		union(4,5);
		union(5,0);
		
		for(int i = 0 ; i < parent.length; i++) {
			System.out.print("element: " + i + " parent: "+ parent[i] + " root: " + find(i));
			System.out.println();
		}
		
	}
	
	static int find(int u) {
		if(parent[u] == u) {
			return u;
		}
		return parent[u] = find(parent[u]);
	}
	
	static void union(int u, int v) {
		u = find(u);
		v = find(v);
		
		if(u == v) {
			return;
		}
		
		if(rank[u] > rank[v]) {
			int temp = u;
			u = v;
			v = temp;
		}
		
		parent[u] = v;
		
		if(rank[u] == rank[v]) {
			rank[v]++;
		}
	}
}
