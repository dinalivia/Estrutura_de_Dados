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
			retorno = "[ "+ this.value + ", " + this.leftsize + ", " +
				 this.left.toString() + ", " + this.right.toString() + " ]";
		else
			retorno = "[ "+ this.value + ", " + this.leftsize +" ]";

		return retorno;

	}

}

//valor do nó é a soma de todos os outros nós abaixo deles
