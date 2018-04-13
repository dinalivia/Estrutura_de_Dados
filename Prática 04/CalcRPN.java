package calculadora;
import java.io.*;

class CalcRPN {
// vari´aveis da instancia :
// uma pilha para os c´alculos
Pilha<Double> aPilha;

CalcRPN () {
    aPilha = new Pilha();
}
// Adi¸c~ao de dois elementos do topo da pilha
void mais() {
    double x = aPilha.desempilha();
    double y = aPilha.desempilha();
    aPilha.empilha(x+y);
}
// Subtra¸c~ao de dois elementos do topo da pilha
void menos() {
    double x = aPilha.desempilha();
    double y = aPilha.desempilha();
    aPilha.empilha(y-x);
}
// Multiplica¸c~ao de dois elementos do topo da pilha
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
throw new Error("a ser completado");
}
}