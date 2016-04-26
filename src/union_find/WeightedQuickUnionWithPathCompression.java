package union_find;

public class WeightedQuickUnionWithPathCompression {
	private int[] id;
	private int[] wt;

	public WeightedQuickUnionWithPathCompression(int n) {
		id = new int[n];
		wt = new int[n];
		for (int i = 0; i < n; i++) {

			id[i] = i;
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

		WeightedQuickUnionWithPathCompression uf = new WeightedQuickUnionWithPathCompression(10);
		uf.union(9, 0);

		uf.union(4, 6);
		uf.union(2, 1);
		uf.union(7, 6);
		uf.union(2, 3);
		uf.union(4, 9);
		for (int e : uf.id) {
			System.out.print(e + " ");

		}

	}

}
