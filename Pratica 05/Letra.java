public class Letra
{
  private String caractere;
  private String md5Code;



  public String getCaractere(){
      return this.caractere;
  }
  public String getMd5Code(){
      return this.md5Code;
  }
  public void setMd5Code(String md5){
    this.md5Code=md5;
  }
  public void setCaractere(String caractere){
    this.caractere=caractere;
  }
  public Letra(String caractere){
     this.md5Code=SecurityProvider.md5(caractere);
     this.caractere=caractere;
  }

}
