package union_find;

public class WeightedQuickUnion {
	private int[] id;
	private int[] wt;

	public WeightedQuickUnion(int n) {
		id = new int[n];
		wt = new int[n];
		for (int i = 0; i < n; i++) {

			id[i] = i;
			wt[i] = 1;
		}
	}

	int root(int i) {
		while (i != id[i]) {
			i = id[i];
			// id[i] = id[id[i]];
		}
		return i;
	}

	boolean isConnected(int p, int q) {
		return root(p) == root(q);

	}

	void union(int p, int q) {
		int proot = root(p);
		int qroot = root(q);
		if (wt[proot] < wt[qroot]) {
			id[proot] = qroot;
			wt[qroot] += wt[proot];
		} else {
			id[qroot] = proot;
			wt[proot] += wt[qroot];
		}
		// id[proot] = qroot;
	}

	public static void main(String[] args) {

		WeightedQuickUnion uf = new WeightedQuickUnion(10);
		uf.union(5, 7);
		uf.union(2, 8);
		uf.union(3, 1);
		uf.union(0, 6);
		uf.union(8, 9);
		uf.union(9, 4);
		uf.union(2, 7);
		uf.union(1, 0);
		uf.union(0, 8);
		for (int e : uf.id) {
			System.out.print(e + " ");

		}

	}

}
