import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class RSABigInteger {
	
	 static BigInteger p;
	 static BigInteger q;
	 static BigInteger N;
	 static BigInteger phi;
	 static BigInteger e;
	 static BigInteger d;
	 static int bitlength = 1024;
	 static Random  r;

	 public static void main(String args[])
	 {
		 
		 Scanner sc = new Scanner(System.in);
	     r = new Random();
	     p = BigInteger.probablePrime(bitlength, r);
	     q = BigInteger.probablePrime(bitlength, r);
	     N = p.multiply(q);
	     phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
	     e = BigInteger.probablePrime(bitlength / 2, r);
	     while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0)
	     {
	         e.add(BigInteger.ONE);
	     }
	     d = e.modInverse(phi);
	     
	     
	     System.out.println("Enter message");
	     String msg = sc.nextLine();
	     BigInteger m = new BigInteger(msg.getBytes());
	     BigInteger c = m.modPow(e, N);
	     BigInteger r = c.modPow(d, N);
		 System.out.println("Encrypted data is " + c);
		 System.out.println("Decrypted data is " + r);
		 String decrypt = new String(r.toByteArray());
		 System.out.println(decrypt);
	}
}
