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
	public int prefixSum(int upto){
		if (left == null) {
			if(upto!=0){
				return this.value;
			}
			else
				return 0;
		}
		else if(this.leftsize<=upto){
				return this.left.value + this.right.prefixSum(upto-this.leftsize);
		}
		else{
				return this.left.prefixSum(upto);
		}
	}

	public static void main(String[] args){
		// teste de correcao
		// teste de correcao
		System.out.println("Verificacao de correcao da funcao...");
		FenwickTree T = new FenwickTree(3, new FenwickTree(1, new FenwickTree(4),
		new FenwickTree(1, new FenwickTree(2), new FenwickTree(5))),
		new FenwickTree(1, new FenwickTree(3),
		new FenwickTree(1, new FenwickTree(6), new FenwickTree(1))));
		System.out.println("Arvore this : " + T);
		System.out.println("Soma das primeiras folhas : ");
		for(int upto = 0; upto <= 6; upto++)
		System.out.println("prefixSum(" + upto + ") : " + T.prefixSum(upto));
	}
}
