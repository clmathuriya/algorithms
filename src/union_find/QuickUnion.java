package union_find;

public class QuickUnion {
	private int[] id;

	public QuickUnion(int n) {
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}

	int root(int i) {
		while (i != id[i])
			i = id[i];
		return i;
	}

	boolean isConnected(int p, int q) {
		return root(p) == root(q);

	}

	void union(int p, int q) {
		int proot = root(p);
		int qroot = root(q);
		id[proot] = qroot;
	}

	public static void main(String[] args) {

		QuickUnion uf = new QuickUnion(10);
		uf.union(1, 2);
		uf.union(3, 4);
		uf.union(5, 6);
		uf.union(7, 8);
		uf.union(2, 8);
		System.out.println(uf.isConnected(1, 8));
	}

}
