package calculadora;
import java.io.*;
import static java.lang.Double.parseDouble;

class CalcRPN {
// variÂ´aveis da instancia :
// uma pilha para os cÂ´alculos
Pilha<Double> aPilha;

CalcRPN () {
    aPilha = new Pilha();
}
// AdiÂ¸c~ao de dois elementos do topo da pilha
void mais() {
    double x = aPilha.desempilha();
    double y = aPilha.desempilha();
    aPilha.empilha(x+y);
}
// SubtraÂ¸c~ao de dois elementos do topo da pilha
void menos() {
    double x = aPilha.desempilha();
    double y = aPilha.desempilha();
    aPilha.empilha(y-x);
}
// MultiplicaÂ¸c~ao de dois elementos do topo da pilha
void vezes() {
    double x = aPilha.desempilha();
    double y = aPilha.desempilha();
    aPilha.empilha(x*y);
}
// Divis~ao de dois elementos no topo da pilha
void dividido() {
    double x = aPilha.desempilha();
    double y = aPilha.desempilha();
    aPilha.empilha(y/x);
}
// retorna o conteudo do topo da pilha
Double resultado() {
    return aPilha.topo();
}
// interpretador de comandos
void exec(String cmd) {
    if (cmd.equals("+")){
        mais();
    }
    else if (cmd.equals("-")){
        menos();
    }
    else if (cmd.equals("/")){
        dividido();
    }
    else if (cmd.equals("*")){
        vezes();
    }
    else if (cmd.equals("clear")){
        aPilha.reinicialize();
    }
    else {
        double z=parseDouble(cmd);
        aPilha.empilha(z);
    }
}

//    static void interfaceUsuario() throws IOException {
//        CalcRPN calc = new CalcRPN() ;
//        String line;
//        BufferedReader reader = new BufferedReader(new InputStreamReader (System.in));
//        while((line = reader.readLine()) != null) {
//        if (line.isEmpty())
//        continue;
//        for (String s : line.split(" "))
//        calc.exec(s);
//        System.out.println("Pilha = " + calc.aPilha);
//        }
//        System.out.println("Até logo");
//    }


}

