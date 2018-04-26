public class Conta{

  private String nomeCliente;
  private String saldo;
  private String agencia;
  private String numero;
  private String senha;
  private String md5;

  public Conta(String agencia, String numero, String senha){
      this.agencia=agencia;
      this.numero=numero;
      this.senha=senha;
      this.md5=SecurityProvider.md5ToServer(this);
  }

  public Conta(String agencia, String numero, String senha,
        String saldo, String nomeCliente){
      this.agencia=agencia;
      this.numero=numero;
      this.senha=senha;
      this.saldo=saldo;
      this.nomeCliente=nomeCliente;
      this.md5=SecurityProvider.md5ToServer(this);
  }

  public Conta(String nomeCliente,String saldo){
    this.saldo=saldo;
    this.nomeCliente=nomeCliente;
    this.md5=SecurityProvider.md5ToServer(this);
  }
  public String getNomeCliente(){
    return this.nomeCliente;
  }
  public String getSaldo(){
    return this.saldo;
  }
  public String getAgencia(){
    return this.agencia;
  }
  public String getNumero(){
    return this.numero;
  }
  public String getSenha(){
    return this.senha;
  }
  public String getMd5(){
    return this.md5;
  }
  public void setNomeCliente(String nome){
    this.nomeCliente=nome;
  }
  public void setSalto(String saldo){
    this.saldo=saldo;
  }
  public void setAgencia(String agencia){
    this.agencia=agencia;
  }
  public void setNumero(String numero){
    this.numero=numero;
  }
  public void setSenha(String senha){
   this.senha=senha;
  }
  public void setMd5(String md5){
    this.md5=md5;
  }

  public String toString(){
      String retorno;
      retorno = "AGENCIA: " + this.agencia +"\n";
      retorno +="CONTA: " + this.numero+"\n";
      retorno +="SENHA: " + this.senha+"\n";
      retorno +="NOME CLIENTE: "+ this.nomeCliente+"\n";
      retorno +="SALDO: " + this.saldo+"\n";
      retorno +="MD5: " +this.md5+"\n";
      return retorno;

  }
  public static void test()
  {
    Conta c1 = new Conta("124", "333", "1234","10", "john doe");
    System.out.println(c1);
    Conta c2 = new Conta("John Doe", "10");
    System.out.println(c2);
    Conta c3 = new Conta("123", "321","666");
    System.out.println(c3);
  }


	public static void main(String[] args) {
			test();
	}

}
