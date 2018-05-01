public class FenwickTree{
	int value;
	int leftsize; //numero de folhas na subarvore a esquerda
	FenwickTree left;
	FenwickTree right;

	FenwickTree(int Value){
		this.value=Value;
	}
	FenwickTree(int leftsize, FenwickTree left, FenwickTree right){
		this.leftsize=leftsize;
		this.left=left;
		this.right=right;
		this.value=left.value+right.value;
	}
	public String toString(){
		String retorno;
		if(!(this.left==null))
			retorno = "["+ this.value + ", " + this.leftsize + ", " +
				 this.left.toString() + ", " + this.right.toString() + "]";
		else
			retorno = "["+ this.value + ", " + this.leftsize +"]";

		return retorno;

	}

	public int size(){
		if(this.left==null)
			return 1;
		else
			return this.leftsize+this.right.size();

	}

	static FenwickTree allZeros(int n){
		if (n==0) return null;
		if (n==1) return new FenwickTree(0);
		int m = n/2;
		return new FenwickTree(n-m, allZeros(n-m), allZeros(m));
	}

	public void increment(int i, int delta){
		if( this.left == null )
			this.value+=delta;
		else if ( this.leftsize >i ){
			this.value+=delta;
			this.left.increment(i,delta);
		}
		else{
			this.value+=delta;
			this.right.increment(i - this.leftsize,delta);
		}
	}

	public static void main(String[] args){
		// teste de correcao
		System.out.println("Verificacao de correcao da funcao...");
		FenwickTree T = new FenwickTree(3,
		new FenwickTree(1, new FenwickTree(0),
		new FenwickTree(1, new FenwickTree(0), new FenwickTree(0))),
		new FenwickTree(1, new FenwickTree(0),
		new FenwickTree(1, new FenwickTree(0), new FenwickTree(0))));
		System.out.println("Arvore this : " + T);
		T.increment(0, 4);
		System.out.println("Resultado de increment(0, 4) : " + T);
		T.increment(1, 2);
		System.out.println("Resultado de increment(1, 2) : " + T);
		T.increment(2, 5);
		System.out.println("Resultado de increment(2, 5) : " + T);
		T.increment(3, 3);
		System.out.println("Resultado de increment(3, 3) : " + T);
		T.increment(4, 6);
		System.out.println("Resultado de increment(4, 6) : " + T);
		T.increment(5, 1);
		System.out.println("Resultado de increment(5, 1) : " + T);
	}
}
