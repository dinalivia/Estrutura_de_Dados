package calculadora;
import java.io.*;
import java.util.LinkedList;
/**
 *
 * @author C6-PROF
 */
public class Pilha<T>{
        private LinkedList<T> conteudo;

        public Pilha(){
            conteudo = new LinkedList<T>();
        }

        public boolean estaVazia(){
            return conteudo.isEmpty();
        }

        public void empilha(T ele){
            conteudo.addFirst(ele);
        }

        public T desempilha(){
            if(estaVazia()){
                throw new Error("TÃ¡ vazia");
            }
            return conteudo.removeFirst();
        }

        public T topo(){
            if(estaVazia()){
                throw new Error("TÃ¡ vazia");
            }
            return conteudo.getFirst();
        }
        
        public String toString(){
            return conteudo.toString();
        }
        
        public void reinicialize(){
            conteudo.clear();
        }
        
        

    static void test1() {
        Pilha<Double> aPilha = new Pilha<Double>();
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
        
    static void test() {
        CalcRPN calc = new CalcRPN() ;
        System.out.print("3 2 + = ");
        calc.aPilha.empilha(3.0);
        calc.aPilha.empilha(2.0);
        calc.mais();
        System.out.println(calc.resultado());
        calc = new CalcRPN();
        System.out.print("3 2 - = ");
        calc.aPilha.empilha(3.0);
        calc.aPilha.empilha(2.0);
        calc.menos();
        System.out.println(calc.resultado());
        calc = new CalcRPN();
        System.out.print("3 2 * = ");
        calc.aPilha.empilha(3.0);
        calc.aPilha.empilha(2.0);
        calc.vezes();
        System.out.println(calc.resultado());
        calc = new CalcRPN();
        System.out.print("3 2 / = ");
        calc.aPilha.empilha(3.0);
        calc.aPilha.empilha(2.0);
        calc.dividido();
        System.out.println(calc.resultado());
        calc = new CalcRPN();
        System.out.print("1 2 + 3 4 - / 10 3 - * = ");
        calc.aPilha.empilha(1.0);
        calc.aPilha.empilha(2.0);
        calc.mais();
        calc.aPilha.empilha(3.0);
        calc.aPilha.empilha(4.0);
        calc.menos();
        calc.dividido();
        calc.aPilha.empilha(10.0);
        calc.aPilha.empilha(3.0);
        calc.menos();
        calc.vezes();
        System.out.println(calc.resultado());
    }
    
    static void interfaceUsuario() throws IOException {
        CalcRPN calc = new CalcRPN() ;
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader (System.in));
        while((line = reader.readLine()) != null) {
        if (line.isEmpty())
        continue;
        for (String s : line.split(" "))
        calc.exec(s);
        System.out.println("Pilha = " + calc.aPilha);
        }
        System.out.println("At´e logo");
    }

    
    public static void main (String[] args) throws IOException{
        interfaceUsuario();
    }
}

