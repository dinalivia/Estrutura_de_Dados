import java.util.LinkedList;


public class Pilha<T> {

	private LinkedList<T> conteudo;
	
	public Pilha(){
		conteudo = new LinkedList<>();
	}
	
	public void empilha(T novoDado){
	
		conteudo.addFirst(novoDado);
	}
		
	public T desempilha(){
		if(estaVazia()){
			throw new Error("Lista Vazia");
		}
		T first;
		first=conteudo.removeFirst(); 
		return first;
		
	}
	
	public T topo(){
		if(estaVazia()){
			throw new Error("Lista Vazia");
		}
		return conteudo.getFirst();
	}

	// public void clear(){
	// 	conteudo.clear();
	// }

	public void reinicialize(){
		conteudo.clear();
	}

	public boolean estaVazia(){
		return conteudo.isEmpty();
	}
	public String toString(){

		return conteudo.toString();
	}

	public String toStringInverse(){
		Pilha temp = new Pilha();
		String retorno=""; 
		for (int i=0; i<conteudo.size();i++){
			if (i==0)
				temp.conteudo.addFirst(conteudo.get(i));
			else 
				temp.conteudo.addFirst(conteudo.get(i)+", ");
		}
		while(!temp.estaVazia()){
			retorno+=temp.desempilha();
		}
		retorno = "["+retorno+"]";
		return retorno;
	}

	static void test1() {
		Pilha<Double> aPilha = new Pilha<Double>();
		System.out.println(aPilha);
		aPilha.empilha(1.1);
		aPilha.empilha(2.1);
		aPilha.empilha(3.1);
		aPilha.empilha(4.1);
		aPilha.empilha(5.1);
		double valor = 0.0;
		valor = aPilha.topo();
		System.out.println("topo pilha = " + valor);
		valor = aPilha.desempilha();
		System.out.println("topo pilha = " + valor);
		valor = aPilha.desempilha();
		System.out.println("topo pilha = " + valor);
		valor = aPilha.desempilha();
		System.out.println("topo pilha = " + valor);
		valor = aPilha.topo();
		System.out.println("topo pilha = " + valor);
		valor = aPilha.desempilha();
		System.out.println("topo pilha = " + valor);
	}
	static void test2() {
		Pilha<Double> aPilha = new Pilha<Double>();
		System.out.println(aPilha);
		aPilha.empilha(1.1);
		System.out.println(aPilha);
		aPilha.empilha(2.1);
		System.out.println(aPilha);
		aPilha.empilha(3.1);
		System.out.println(aPilha);
		double valor = 0.0;
		valor = aPilha.desempilha();
		System.out.println("topo pilha = " + valor );
		System.out.println(aPilha);
		valor = aPilha.desempilha();
		System.out.println("topo pilha = " + valor );
		System.out.println(aPilha);
		valor = aPilha.desempilha();
		System.out.println("topo pilha = " + valor );
		System.out.println(aPilha);
	}
	public static void main(String[] args) {
		test2();
}
	

}
