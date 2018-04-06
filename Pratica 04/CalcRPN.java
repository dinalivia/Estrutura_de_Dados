import java.io.*;

public class CalcRPN {
	// variáveis da instancia :
	// uma pilha para os cálculos
	Pilha<Double> aPilha;
	//pilha do histórico
	//Pilha<Operacao> hist;
	// construtor
	CalcRPN () {
		aPilha = new Pilha();
		//hist = new Pilha();
	}
	// Adiçao de dois elementos do topo da pilha
	void mais() {
		double a=aPilha.desempilha();
		double b=aPilha.desempilha();
		aPilha.empilha(b+a);
		//hist.empilha(new Operacao(a,b,'+'));
	}
	// Subtraçao de dois elementos do topo da pilha
	void menos() {
		double a=aPilha.desempilha();
		double b=aPilha.desempilha();
		aPilha.empilha(b-a);
	}
	// Multiplicaçao de dois elementos do topo da pilha
	void vezes() {
	 	double a=aPilha.desempilha();
		double b=aPilha.desempilha();
		aPilha.empilha(b*a);
	}
	// Divisao de dois elementos no topo da pilha
	void dividido() {
		double a=aPilha.desempilha();
		double b=aPilha.desempilha();
		aPilha.empilha(b/a);
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
		else if (cmd.equals("clear"))
			aPilha.reinicialize();
		else{
			double numero; 
			numero= Double.parseDouble(cmd);
			aPilha.empilha(numero);
		}

	}
	void undo(){

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