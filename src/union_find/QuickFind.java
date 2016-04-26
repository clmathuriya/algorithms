package union_find;

public class QuickFind {
	private int[] id;

	public QuickFind(int n) {
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}

	boolean isConnected(int p, int q) {
		return id[p] == id[q];

	}

	void union(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pid)
				id[i] = qid;
		}
	}

	public static void main(String[] args) {

		QuickFind uf = new QuickFind(10);
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
