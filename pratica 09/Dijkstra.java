import java.util.PriorityQueue;
import java.util.ArrayList;

// Algoritmo de Dijkstra
public class Dijkstra {
	final Graph g; 
	final int n; 
	final int source; 
	final int dest; 
	int[] dist;
	int[] pred;
	boolean[] settled; 
	PriorityQueue<Node> naoacomodados;
	Fenetre f; 

	// construtor
	Dijkstra(Graph g, int source, int   dest) {
		this.g = g;
		n = g.n;
		this.source = source;
		this.dest = dest;
		dist = new int[n];
		pred = new int [n];
		settled = new boolean[n];
		naoacomodados = new PriorityQueue<Node>();
		for (int i=0;i<n;i++){
			dist[i]=Integer.MAX_VALUE;
			pred[i]=-1;
			settled [i]=false;
		}
		pred[source] = source;
		dist[source] = 0;
		settled[source]=false;
	}
	
	// atualizacao da distancia, da prioridade, e do predecessor de um no
	void update(int y, int x) {
		int custoAtual = dist[y];
		int novoCusto = dist[x] + g.value(x,y);
		if (novoCusto<custoAtual){
			dist[y]=novoCusto;
			naoacomodados.add(new Node(y,novoCusto));
		}
	}
	
	// retorna o próximo nó a ser acomodado
	int nextNode() {
		if(naoacomodados.isEmpty()){
			return -1;
		}
		
		int menor = naoacomodados.poll().val;
		
		if(settled[menor] == false){
			return menor;
		}
		else{
			return -1;
		}

	}
	
	// uma etapa do algoritmo de Dijkstra
	int oneStep() {
		int noAtual = nextNode();
		if(noAtual != -1){
			settled[noAtual] = true; 
			ArrayList<Integer> vizinhos = g.successors(noAtual);
			for (int i=0; i<vizinhos.size(); i++){ //for cada vizinho
				update(vizinhos.get(i),noAtual);
			}
			return noAtual;
		}
		else{
			return -1;
		}
		
		//throw new Error("para completer");
	}
	
	// algoritmo de Dijsktra completo
	int compute() {
		while (oneStep() != -1 && oneStep() != dest){
			oneStep();
		}
		return dist[dest];
		 // throw new Error("para completer");
	}
	
	// desacelera o visualizador
	void slow(){
	    if(f == null) return;
	    try {
	        Thread.sleep(5);
	    } catch (InterruptedException e) {}
	}
}
