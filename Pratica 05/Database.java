public class Database
{
  public static final ArrayList<Letra> caracteres;
  static
  {
    caracteres = new ArrayList<Letra>();
  }
  public static Letra getLetra(String md5){

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
		test6();
	}
}
