import java.io.*;

public class CalcRPN {
	// variáveis da instancia :
	// uma pilha para os cálculos
	Pilha<Double> aPilha;
	//pilha do histórico
	Pilha<Operacao> hist;
	// construtor
	CalcRPN () {
		aPilha = new Pilha();
		hist = new Pilha();
	}
	// Adiçao de dois elementos do topo da pilha
	void mais() {
		double a=aPilha.desempilha();
		double b=aPilha.desempilha();
		aPilha.empilha(b+a);
		hist.empilha(new Operacao('+',a,b));
	}
	// Subtraçao de dois elementos do topo da pilha
	void menos() {
		double a=aPilha.desempilha();
		double b=aPilha.desempilha();
		aPilha.empilha(b-a);
		hist.empilha(new Operacao('-',a,b));
	}
	// Multiplicaçao de dois elementos do topo da pilha
	void vezes() {
	 	double a=aPilha.desempilha();
		double b=aPilha.desempilha();
		aPilha.empilha(b*a);
		hist.empilha(new Operacao('*',a,b));
	}
	// Divisao de dois elementos no topo da pilha
	void dividido() {
		double a=aPilha.desempilha();
		double b=aPilha.desempilha();
		aPilha.empilha(b/a);
		hist.empilha(new Operacao('/',a,b));
	}
	// retorna o conteudo do topo da pilha
	Double resultado() {
		return aPilha.topo();
	}
	// interpretador de comandos
	void exec(String cmd) {
		if(cmd.equals("+"))
			mais();
		else if (cmd.equals("-"))
			menos();
		else if (cmd.equals("*"))
			vezes();
		else if (cmd.equals("-"))
			menos();
		else if (cmd.equals("/"))
			dividido();
		else if (cmd.equals("clear")){
			aPilha.reinicialize();
			hist.reinicialize();
		}
		else if(cmd.equals("hist")){
			System.out.println("Historico = " + hist.toStringInverse());
		}
		else if(cmd.equals("undo")){
			cancela();
			System.out.println("Historico = " + hist.toStringInverse());
		}
		else{
			double numero;
			numero= Double.parseDouble(cmd);
			aPilha.empilha(numero);
			hist.empilha(new Operacao(numero));
		}

	}
	void cancela(){
		Operacao ultima = hist.desempilha();
		if(ultima.getCode()=='e'){ 
			aPilha.desempilha();
		}
		else{
			aPilha.desempilha();
			aPilha.empilha(ultima.getB());
			aPilha.empilha(ultima.getA());
		}

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
		System.out.println(calc.resultado());calc = new CalcRPN();
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
		BufferedReader reader = new BufferedReader
		(new InputStreamReader (System.in));
		while((line = reader.readLine()) != null) {
		if (line.isEmpty())
		continue;
		for (String s : line.split(" "))
		calc.exec(s);
		System.out.println("Pilha = " + calc.aPilha);
		}
		System.out.println("Até logo");
	}

	public static void main(String[] args) throws IOException {
		interfaceUsuario();
	}

}
