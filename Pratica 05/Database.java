import java.util.ArrayList;

public class Database
{
  public static final ArrayList<Letra> caracteres;
  static
  {
    caracteres = new ArrayList<Letra>();
    caracteres.add(new Letra(" "));
    for (char i='A';i<='Z';i++){
      caracteres.add(new Letra(Character.toString((i))));
    }
    for (char i='a';i<='z';i++){
      caracteres.add(new Letra(Character.toString((i))));
    }
    for (char i='0';i<='9';i++){
      caracteres.add(new Letra(Character.toString((i))));
    }
  }
  public static Letra getLetra(String md5){
    for (int i=0;i<caracteres.size();i++){
  		if(caracteres.get(i).getMd5Code().equals(md5)){
  			return caracteres.get(i);
  		}
  	}
  	return null;
  }
  public static Conta getConta(String[] letras){
    String nome="";
    String saldo="";
    boolean espaço=false;
    for(int i=0;i<letras.length;i++){
      Letra ll = Database.getLetra(letras[i]);
      if(ll.getCaractere()==" "){
      	espaço=true;
      }
      if(espaço){
      	nome+=ll.getCaractere();
      }
      else{
      	saldo+=ll.getCaractere();
      }
     }
    Conta retorno = new Conta(nome,saldo);
    return retorno;
  }
  public static void test5()
  {
    Conta c = new Conta("124", "333", "1234","10", "john doe");
    ServerDatabase.insereConta(c);
    String chave = SecurityProvider.md5ToServer(c);
    Conta conta = ServerDatabase.getConta(chave);
    String chars[];
    chars = SecurityProvider.md5ToClient(conta);
    System.out.println(Database.getConta(chars));
  }
  public static void test6()
  {
    Letra l = new Letra("a");
    String md5 = l.getMd5Code();
    System.out.println(md5);
    Letra ll = Database.getLetra(md5);
    System.out.println(ll.getCaractere());
  }
  public static void main(String[] args) {
		test5();
	}
}
