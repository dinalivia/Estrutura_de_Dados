import java.security.MessageDigest;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class SecurityProvider
{
	public static String salt = "5a1t";

	public static String md5(String stringToConvert)
	{
		String hashtext="";
		stringToConvert +=salt;
		MessageDigest m;
		try
		{
			m = MessageDigest.getInstance("MD5");
			m.reset();
			m.update(stringToConvert.getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1,digest);
			hashtext = bigInt.toString(16);
		}
		catch (NoSuchAlgorithmException ex)
		{
			Logger.getLogger(SecurityProvider.class.getName()).log(Level.SEVERE, null, ex);
		}
		return hashtext;
	}
	public static String md5ToServer(Conta conta)
	{
		String cat = conta.getAgencia()+conta.getNumero()+conta.getSenha()+SecurityProvider.salt;
		String retorno;
		retorno = md5(cat);
		return retorno;
		
	}
	public static void test1()
	{
		System.out.println(SecurityProvider.md5("teste"));
	}
	public static void test2()
	{
		Conta c = new Conta("1234", "2222","1245");
		System.out.println(SecurityProvider.md5ToServer(c));
	}
	public static void main(String[] args) {
		test2();
	}
}
